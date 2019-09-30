package bco.visorhc.security;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import bco.visorhc.PropertiesUtils;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	public static String username = "";
	public static final Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// String username = authentication.getPrincipal().toString();
		username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();

		logger.info("usuario : " + username +" - intentando login" );
		//logger.info("password : " + password );
		
		int ldap;
		
		ldap = isUserLDAP(username, password);
		
		if (ldap == 3) {
			throw new BadCredentialsException("Credential incorrect");
		} else if (ldap == 1) {
			throw new LockedException("User is locked!");
		} else if (ldap == 2) {
			throw new LockedException("User is locked!");
		}
		return new UsernamePasswordAuthenticationToken(username, password, null);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public int isUserLDAP(String usuario, String clave) {

		//String rutaPropiedades = "./application.properties";
		String homeWL = System.getProperty("weblogic.Domain");
		String rutaPropiedades = homeWL+"/Corp/AppProperties/application.properties";
		// String rutaPropiedades =
		// "F:/Workspace/codigo_fuente/src/main/resources/application.properties";
		String archivoConfiguracion = "";
		int ldap = 0;

		String username = usuario + "@CD-ROSAS";
		String password = clave;
		logger.info("ruta de propiedades : " + rutaPropiedades);
		// Comentar segun sea prod o desa
		Properties properties = PropertiesUtils.getProperties(rutaPropiedades, archivoConfiguracion);
		String ldapURL = "ldap://" + properties.getProperty("IP_SERVIDOR_DOMINIO");
		// String ldapURL = "ldap://localhost:8015";
		
		logger.info("ruta de conexion ldap : " + ldapURL);

		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, ldapURL);
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.SECURITY_PRINCIPAL, username);
		environment.put(Context.SECURITY_CREDENTIALS, password);

		try {
			DirContext authContext = new InitialDirContext(environment);
			DirContext peopleContext = (DirContext) authContext.lookup("OU=Falabella Peru,DC=Falabella,DC=com");

			SearchControls sc = new SearchControls();
			sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

			String filter = "(&(sAMAccountName=" + usuario + "))";
			@SuppressWarnings("rawtypes")
			NamingEnumeration peopleEnum = peopleContext.search("", filter, sc);

			while (peopleEnum.hasMore()) {
				NameClassPair personName = (NameClassPair) peopleEnum.next();
				Attributes personAttrs = peopleContext.getAttributes(personName.getName());

				@SuppressWarnings("unused")
				Attribute attrCn = personAttrs.get("cn");
				@SuppressWarnings("unused")
				Attribute sAMAccountName = personAttrs.get("sAMAccountName");
				Attribute attrAccountControl = personAttrs.get("msExchUserAccountControl");

				if (attrAccountControl != null) {
					if (attrAccountControl.get().toString().equals("2")) {
						ldap = 2;
						logger.info("Su usuario se encuentra bloqueado.");
						throw new Exception("Su usuario se encuentra bloqueado.");
					} else if (attrAccountControl.get().toString().equals("1")) {
						ldap = 1;
						logger.info("Su usuario se encuentra bloqueado, comuníquese con Help Desk.");
						throw new Exception("Su usuario se encuentra bloqueado, comuníquese con Help Desk.");
					}
				}
			}
			peopleContext.close();
			logger.info("autentificacion exitosa");
		} catch (AuthenticationException ex) {
			logger.error("ocurrio un problema no controlado: " + ex.getMessage());
			ldap = 3;
		} catch (NamingException ex) {
			logger.error("ocurrio un problema no controlado: " + ex.getMessage());
			ldap = 3;
		} catch (Exception ex) {
			logger.error("ocurrio un problema no controlado: " + ex.getMessage());
			ldap = 3;
		}

		return ldap;
	}

}