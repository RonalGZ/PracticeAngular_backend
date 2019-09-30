package bco.visorhc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtils {
	
	public static final Logger logger = Logger.getLogger(PropertiesUtils.class);

	 public static Properties getProperties(String ruta, String entorno) {
	        String file = ruta + entorno;
	        FileInputStream fileInput;
	        Properties properties = null;
	        try {
	            fileInput = new FileInputStream(file);
	            properties = new Properties();
	            properties.load(fileInput);
	            fileInput.close();
	        } catch (FileNotFoundException e) {
	        	 
	            logger.error("[PropertiesUtils] No fue posible leer las propiedades. Causa: el archivo de configuracion - " +
	                               entorno + " - no pudo ser ubicado");
	        } catch (IOException e) {
	        	logger.error("[PropertiesUtils] No fue posible leer las propiedades. Causa: el archivo de configuracion - " +
	                               entorno + " - no pudo ser ubicado");
	        }
	        return properties;
	    }
}
