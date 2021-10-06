package com.appliance.auth.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplianceAuthController {
	  
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
		      throws AuthenticationException {
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//	    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtTokenResponse("mytoken"));
	}

	private void authenticate(String username, String password) {
	}
}
