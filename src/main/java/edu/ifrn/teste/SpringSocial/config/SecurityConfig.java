package edu.ifrn.teste.SpringSocial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;

import edu.ifrn.teste.SpringSocial.security.FacebookConnectionSignup;
import edu.ifrn.teste.SpringSocial.security.FacebookSignInAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;
 
    @Autowired
    private UsersConnectionRepository usersConnectionRepository;

    @Autowired
    private FacebookConnectionSignup facebookConnectionSignup;
    
    @Autowired
    private FacebookSignInAdapter facebookSignInAdapter;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .csrf().disable()
         .authorizeRequests()
         .antMatchers("/entrar*","/signin/**","/signup/**","/h2/**").permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin().loginPage("/entrar").permitAll()
         .successForwardUrl("/index").and().logout().permitAll()
 		 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
 		 .logoutSuccessUrl("/entrar");
    	 
    	 
    	 
    		//Retirar quando hospedar - para utilizar o H2 
 		http.csrf().disable();
        http.headers().frameOptions().disable();
    } 
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("jeff").password("123").roles("ADMIN");

        //userDetailsService(userDetailsService)
        //.passwordEncoder(new BCryptPasswordEncoder());

    }
    
    @Bean
    public ProviderSignInController providerSignInController() {

        System.out.println("=> ProviderSignInController");

        ((InMemoryUsersConnectionRepository) usersConnectionRepository).setConnectionSignUp(facebookConnectionSignup);
        return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, facebookSignInAdapter);
    }
    
    
}