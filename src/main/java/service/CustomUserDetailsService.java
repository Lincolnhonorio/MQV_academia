package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import config.CustomUserDetails;
import model.User;
import repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Supondo que você tenha um repositório para usuários

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Usando Optional para buscar o usuário
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o nome: " + username));

        // Retorna o CustomUserDetails com as informações do usuário
        return new CustomUserDetails(user.getUsername(), user.getPassword(), user.getRole()); // Acesse as autoridades corretamente
    }
}