package com.ramlearning.employee.service;

import com.ramlearning.employee.config.SecurityConfig;
import com.ramlearning.employee.entity.MyUser;
import com.ramlearning.employee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyUser register(MyUser user) {
        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder(
                        SecurityConfig.BCRYPT_ENCODER_PASSWORD_STRENGTH);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
