package config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // Construtor
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public CustomUserDetails(String username2, String password2, String role) {
		// TODO Auto-generated constructor stub
	}

	// Métodos obrigatórios da interface UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Altere conforme necessário
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Altere conforme necessário
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Altere conforme necessário
    }

    @Override
    public boolean isEnabled() {
        return true; // Altere conforme necessário
    }
}
