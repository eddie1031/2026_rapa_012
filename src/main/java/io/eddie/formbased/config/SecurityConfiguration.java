package io.eddie.formbased.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .formLogin(Customizer.withDefaults())
//                .formLogin(formConfig -> formConfig.loginPage("/login-page")
//                        .usernameParameter("loginId")
//                        .passwordParameter("loginPwd")
//                        .successForwardUrl("/")
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/login-page?error")
//                        .failureForwardUrl("/login-page?error")
//                )
                .logout(Customizer.withDefaults())
//                .logout( logoutConfig -> logoutConfig
//                        .logoutUrl("/logout")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                        .clearAuthentication(true)
//                )
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/login-page")
                                    .anonymous()
                                .requestMatchers("/sign-up")
                                    .permitAll()
//                                .anonymous()
//                                .permitAll()
//                                .hasAnyRole()
//                                .hasAnyAuthority()
//                                .hasRole()
//                                .hasAuthority()
                )
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User
                .withUsername("happy")
                .password(
                        passwordEncoder.encode("day")
                )
                .build()
        );

        return manager;

    }


}
