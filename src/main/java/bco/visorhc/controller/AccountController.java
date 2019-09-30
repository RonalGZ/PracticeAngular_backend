package bco.visorhc.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author kamal berriga
 *
 */
@RestController
public class AccountController {

	public static final Logger logger = Logger.getLogger(AccountController.class);


	// this is the login api/service
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public Principal user(Principal principal) {
		logger.info("user logged " + principal);
		return principal;
	}
	
//    @RequestMapping("/login")
//    public boolean login(@RequestBody User user) {
//        return
//          user.getUserName().equals("user") && user.getPassword().equals("password");
//    }
//     
//    @RequestMapping("/user")
//    public Principal user(HttpServletRequest request) {
//        String authToken = request.getHeader("Authorization")
//          .substring("Basic".length()).trim();
//        return () ->  new String(Base64.getDecoder()
//          .decode(authToken)).split(":")[0];
//    }

	
	
}
