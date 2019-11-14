package edu.ifrn.teste.SpringSocial.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import edu.ifrn.teste.SpringSocial.model.User;
import edu.ifrn.teste.SpringSocial.repository.UserRepository;

@Component
public class FacebookSignInAdapter implements SignInAdapter {
	 
	private UserRepository userRepository;
	
	public FacebookSignInAdapter() {
        System.out.println("=>FacebookSigninAdapter");
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        System.out.println("=>UserRepository: " + userRepository);
        this.userRepository = userRepository;
    }
    
	@Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
		
		System.out.println(localUserId);
		
        System.out.println("=> Autenticação realizada com sucesso...");

		   
		Facebook facebook = (Facebook) connection.getApi();
	    String [] fields = {"name","email",};
	    User user = facebook.fetchObject("me", User.class, fields);
	        
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(connection.getDisplayName(), null, Arrays.asList(new SimpleGrantedAuthority("FACEBOOK_USER"))));

         
        return null;
    }

}
