package bco.visorhc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

@SpringBootApplication
public class VisorHcApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VisorHcApplication.class).properties(getProperties());
	}
	
    static Properties getProperties() {
        Properties props = new Properties();
        //props.put("spring.config.location", "classpath:application.properties");
        //props.put("spring.config.location", "C:\\Oracle\\Middleware\\Oracle_Home\\user_projects\\domains\\base_domain\\servers\\AdminServer\\Corp\\AppProperties\\application.properties"); 
  
        String homeWL = System.getProperty("weblogic.Domain");
        props.put("spring.config.location", homeWL+"/Corp/AppProperties/application.properties"); 
        return props;
    }
    
    public static String nombreEquipo() throws UnknownHostException{
        InetAddress address = InetAddress.getLocalHost();
        return address.getHostName();
    }
    
    
	
	public static void main(String[] args) {
		SpringApplication.run(VisorHcApplication.class, args);
	}

	
}
