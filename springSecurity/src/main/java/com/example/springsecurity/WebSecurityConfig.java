//Defines the java class which belongs to the package 
package com.example.springsecurity;

//importing all the necessary classes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//enable web security
@Configuration
@EnableWebSecurity

//provides implementation for configuring web security 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    //configure HTTP security settings
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	// storing static resources which don't need authentication
    	String[] staticResources = {
                "/Css/**",
                "/Images/**",};
    	
    	// configures which resources are accessible by which authority
        http
                .authorizeRequests()
                .antMatchers("/about").permitAll()
                .antMatchers("/home").hasAuthority("USER")
                .antMatchers("/contact").hasAuthority("ADMIN")
                //.antMatchers("/support").authenticated()
                .antMatchers("/index").authenticated()
                .antMatchers("/signup").permitAll()
                .antMatchers(staticResources).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/demo").failureUrl("/demo?error").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/denied");
    }

    
    // overriding default implementation
    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        // storing the login details (user_name, password, group, role)
        String[][] usersGroupsAndRoles = {
                {"user", "123", "USER", "USER"},
                {"johnsnow", "12345678", "USER", "USER"},
                {"admin", "789", "ADMIN", "ADMIN"},
        };

        // looping through each user
        for (String[] user : usersGroupsAndRoles) {
        	
        	// creates a list which copies the user details from the array 
            List<String> authoritiesStrings = Arrays.asList(Arrays.copyOfRange(user, 2, user.length));
            logger.info("> Registering new user: " + user[0] + " with the following Authorities[" + authoritiesStrings + "]");
            inMemoryUserDetailsManager.createUser(new User(user[0], passwordEncoder().encode(user[1]),
                    authoritiesStrings.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
        }

        // returns the user details object which contain the user details 
        return inMemoryUserDetailsManager;
    }

    // encoding the passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
