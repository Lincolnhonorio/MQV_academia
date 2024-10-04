package config;

	import org.springframework.boot.CommandLineRunner;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.crypto.password.PasswordEncoder;

import model.User;
import repository.UserRepository;

	@Configuration
	public class DataLoader {

	    @Bean
	    CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        return args -> {
	            if (userRepository.findAll().isEmpty()) {
	              }
	        };
	    }
	}
