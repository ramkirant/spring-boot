package com.ramlearning.employee.repository;

import com.ramlearning.employee.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
}
