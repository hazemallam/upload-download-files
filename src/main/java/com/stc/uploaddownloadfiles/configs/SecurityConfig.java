package com.stc.uploaddownloadfiles.configs;

import com.stc.uploaddownloadfiles.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

       return http.authorizeHttpRequests(request ->  request.requestMatchers(HttpMethod.POST, "/api/space/create").authenticated()
                       .requestMatchers(HttpMethod.POST, "/api/folder/create").authenticated()
                       .requestMatchers(HttpMethod.POST, "/api/file/upload").authenticated()
                       .requestMatchers(HttpMethod.GET, "/api/file/download").authenticated()
                       .requestMatchers("/graphiql").authenticated()
                       .requestMatchers(HttpMethod.GET, "/api/file/metadata/**").authenticated()
               ).csrf(AbstractHttpConfigurer::disable)
               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults())
               .exceptionHandling(Customizer.withDefaults())
               .logout(Customizer.withDefaults())
               .authenticationProvider(authenticationProvider()).build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(encoder);
        return daoAuthenticationProvider;
    }

}
