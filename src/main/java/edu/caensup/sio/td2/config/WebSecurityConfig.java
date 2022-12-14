package edu.caensup.sio.td2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.caensup.sio.td2.services.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig {

	@Bean // (2)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/home", "/h2-console/**", "/webjars/**", "/users/add").permitAll() // (3)
                .anyRequest().authenticated() // (4)
                .and().formLogin() // (5)
                .loginPage("/login").defaultSuccessUrl("/orgas") // (5)
                .permitAll().and().logout().logoutSuccessUrl("/exit") // (6)
                .permitAll().and().httpBasic().and().exceptionHandling().accessDeniedPage("/403");
        http.headers().frameOptions().sameOrigin(); // (8)
        http.csrf().disable();
        return http.build();
    }
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserService(); // (2)
    }
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() { // (2)
        return new BCryptPasswordEncoder();
    }
	
}
