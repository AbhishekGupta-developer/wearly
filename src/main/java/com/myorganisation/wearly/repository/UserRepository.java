package com.myorganisation.wearly.repository;

import com.myorganisation.wearly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Custom finder methods
    User findByEmail(String email);
    List<User> findByNameContaining(String name);

    @Query("SELECT u FROM User u WHERE u.name LIKE %:q% OR u.email LIKE %:q% OR u.phone LIKE %:q%")
    List<User> customSearch(@Param("q") String q);

    @Query(value = "SELECT * FROM user WHERE name LIKE %:q% OR email LIKE %:q% OR phone LIKE %:q%", nativeQuery = true)
    List<User> customSearchNative(@Param("q") String q);
}
