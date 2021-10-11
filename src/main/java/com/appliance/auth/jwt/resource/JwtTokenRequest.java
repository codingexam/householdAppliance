package com.appliance.auth.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
	private static final long serialVersionUID = -5616176897013108345L;

  	private String username;
    private String password;

//    {
//    	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTYzNDUzNDY1MSwiaWF0IjoxNjMzOTI5ODUxfQ.mwVBMeQd0PplxCTkxxGgoF3N04NLtCAoj3CXgFqRbM7vjO6AwoV5sT2XAUlXtD0Cdx1R_ZN5cS_31JJNNvz7zw"
//    }
    
    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

