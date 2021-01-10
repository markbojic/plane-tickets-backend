package com.raf.nwp.planetickets.services;

import com.raf.nwp.planetickets.model.MyUser;
import com.raf.nwp.planetickets.model.UserType;
import com.raf.nwp.planetickets.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = userRepository.findByUsername(username);
        if(myUser == null) {
            throw new UsernameNotFoundException("User name " + username + " not found");
        }

        return new User(myUser.getUsername(), myUser.getPassword(), getGrantedAuthorities(myUser));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(MyUser myUser) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(myUser.getUserType().equals(UserType.ADMIN)) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
    }

}
