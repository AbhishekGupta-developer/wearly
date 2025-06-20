package com.myorganisation.wearly.repository;

import com.myorganisation.wearly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Custom finder methods
    User findByEmail(String email);
    List<User> findByNameContaining(String name);
}
