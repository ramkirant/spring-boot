package com.ramlearning.employee.service;

import com.ramlearning.employee.entity.MyUserDetails;
import com.ramlearning.employee.entity.MyUser;
import com.ramlearning.employee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        MyUser user = userRepository.findByUsername(username);

        if(user == null) {
            System.out.println("User dont exist");
            throw new UsernameNotFoundException("User dont exist");
        }
        return new MyUserDetails(user);
    }
}
