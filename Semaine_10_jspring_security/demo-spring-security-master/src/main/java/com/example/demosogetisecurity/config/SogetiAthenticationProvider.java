package com.example.demosogetisecurity.config;

import com.example.demosogetisecurity.model.Customer;
import com.example.demosogetisecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SogetiAthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Customer> customers = customerRepository.findByEmail(username);

        if(customers.size() > 0){
           if(passwordEncoder.matches(password, customers.get(0).getPwd())){
               List<GrantedAuthority> authorities = new ArrayList<>();
               authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
               return new UsernamePasswordAuthenticationToken(username, password, authorities);
           }else{
               throw new BadCredentialsException("Invalid password");
           }
        }else{
           throw new BadCredentialsException("No user registered with this information");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
