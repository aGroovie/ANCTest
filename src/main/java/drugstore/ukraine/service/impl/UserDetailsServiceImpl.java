package drugstore.ukraine.service.impl;

import drugstore.ukraine.dao.UserRepository;
import drugstore.ukraine.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(userName);

        Set<GrantedAuthority> grantlist = new HashSet<>();
        grantlist.add(new SimpleGrantedAuthority(user.getUserRole().getRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantlist);

    }
}