package hu.bme.aut.archerybe.config.services;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.bme.aut.archerybe.datamodel.entity.Authority;
import hu.bme.aut.archerybe.datamodel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private UUID id;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetails build(User user) {
        return new UserDetailsImpl(
                user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),
                mapToGrantedAuthority(user.getAuthority())
        );
    }

    public static Set<GrantedAuthority> mapToGrantedAuthority(Authority authority) {
        return Set.of(new SimpleGrantedAuthority(authority.getRole().name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
