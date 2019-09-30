package bco.visorhc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import bco.visorhc.handlers.CustomAccessDeniedHandler;
import bco.visorhc.handlers.CustomAuthenticationEntryPoint;
import bco.visorhc.handlers.CustomLoginFailureHandler;
import bco.visorhc.handlers.CustomLoginSuccessfulHandler;
import bco.visorhc.handlers.CustomLogoutSuccessfulHandler;
import bco.visorhc.security.CustomAuthenticationProvider;


/**
 * @author Chuck Norris
 *
 */
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity
// Modifying or overriding the default spring boot security.
public class WebConfig extends WebSecurityConfigurerAdapter {

	
	
	// lava
    @Autowired
    private CustomLoginSuccessfulHandler loginSuccessfulHandler;

    @Autowired
    private CustomLoginFailureHandler loginFailureHandler;

    @Autowired
    private CustomLogoutSuccessfulHandler logoutSuccessfulHandler;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	
	//lava
	
    @Autowired
    private CustomAuthenticationProvider authProvider;
        
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
    
	// This method is used for override HttpSecurity of the web Application.
	// We can specify our authorization criteria inside this method.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .requestMatchers()
        .and()  
        .authorizeRequests()
        //.antMatchers("/api/**").permitAll() //habilitar rest  
        .antMatchers("/").permitAll()
        .antMatchers("/index.html").permitAll()
        .antMatchers("/home").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/user").permitAll()
        .antMatchers("/assets/**").permitAll()
        .antMatchers("/*.js").permitAll()
        .antMatchers("/*.jpg").permitAll()
        .antMatchers("/*.css").permitAll()
        .antMatchers("/*.ttf").permitAll()
        .antMatchers("/*.woff2").permitAll()
        .antMatchers("/*.svg").permitAll()
        .antMatchers("/*.ico").permitAll()
        .anyRequest().authenticated().and()
        .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
        .authenticationEntryPoint(customAuthenticationEntryPoint).and()
	    .formLogin()
	    .loginProcessingUrl("/login")
	    .successHandler(loginSuccessfulHandler)
	    .failureHandler(loginFailureHandler)
        .and()
    	.logout()
        .deleteCookies("JSESSIONID")
        .logoutUrl("/logout")
        .and().authenticationProvider(authProvider)
        .csrf().disable();
	}
	
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and().csrf().disable();
//    }

}
