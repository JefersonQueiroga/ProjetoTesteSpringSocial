package edu.ifrn.teste.SpringSocial.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import edu.ifrn.teste.SpringSocial.model.User;
import edu.ifrn.teste.SpringSocial.repository.UserRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {
	
	@Autowired
    private UserRepository userRepository;
	
	
    public String execute(Connection<?> connection) {
        User user = new User();
        user.setName(connection.getDisplayName());
        user.setEmail( "teste@gmail.com");
        user.setPassword("123");
        
        if( userRepository.findByName(connection.getDisplayName() ) == null   ) {
        	userRepository.save(user);
        }	
        System.out.println("######################################");
        return user.getName();
    }
}
