package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    // Configuração de autenticação
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita CSRF se necessário
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // URLs públicas
                .anyRequest().authenticated() // Exige autenticação para outras URLs
            )
            .formLogin(form -> form
                .loginPage("/login") // Página de login customizada
                .permitAll()
            )
            .logout(logout -> logout.permitAll()); // Configuração de logout
        return http.build();
    }

    // Configuração do provedor de autenticação
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService); // Usa o CustomUserDetailsService
        authProvider.setPasswordEncoder(passwordEncoder()); // Usa o codificador de senhas
        return authProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Codifica a senha
    }
}
