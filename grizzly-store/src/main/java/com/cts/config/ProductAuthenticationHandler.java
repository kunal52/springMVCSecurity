package com.cts.config;

import java.io.IOException;
import java.util.Collection;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductAuthenticationHandler implements AuthenticationSuccessHandler {

	
	RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		authorities.forEach(t-> 
		{
			
			if(t.getAuthority().equals("ROLE_USER"))
			{
				try {
					redirectStrategy.sendRedirect(request, response, "/product/list");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(t.getAuthority().equals("ROLE_ADMIN"))
			{
				try {
					redirectStrategy.sendRedirect(request, response, "/admin");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
				 throw new IllegalStateException();
			
		});
		
	}

}
