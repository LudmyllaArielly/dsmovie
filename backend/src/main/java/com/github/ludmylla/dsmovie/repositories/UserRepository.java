package com.github.ludmylla.dsmovie.repositories;

import com.github.ludmylla.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
