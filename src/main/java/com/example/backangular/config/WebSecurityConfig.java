package com.example.backangular.config;


import com.example.backangular.filter.JWTAuthenticationTokenFilter;
import com.example.backangular.security.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
    private final JWTAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(HttpMethod.POST, "/user/auth").permitAll()
                                .requestMatchers(HttpMethod.POST, "/user/register").permitAll()
                                .requestMatchers(HttpMethod.GET, "/user").permitAll()
                                .requestMatchers(HttpMethod.POST, "/employee/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/employee/**").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/employee/**").hasAnyAuthority("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/author/**").authenticated()
                                //  .requestMatchers(HttpMethod.POST, "/author/**").hasAnyAuthority("ADMIN")
                                .anyRequest().authenticated()
                );
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
        //   .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
        //  .and()

//                .requestMatchers("/swagger-ui/**").permitAll()
//                .requestMatchers("/v3/api-docs/**").permitAll()
//                .requestMatchers("/countries").permitAll()
//                .requestMatchers("/books/getImage/**").permitAll()
//                .requestMatchers(HttpMethod.POST, "/author/**").hasAnyAuthority("ADMIN")


    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }


}