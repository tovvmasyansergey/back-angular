package com.example.backangular.security;



import com.example.backangular.entity.User;
import com.example.backangular.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrentUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(username);
        if (byEmail.isEmpty()){
            throw new UsernameNotFoundException("User dose not exists");
        }
        return new CurrentUser(byEmail.get());
    }
}
