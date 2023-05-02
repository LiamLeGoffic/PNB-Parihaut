package com.pnbparihaut.repositories;

import com.pnbparihaut.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    //@Query("SELECT u FROM users u WHERE u.username = ?1 AND u.password = ?2")
    //Optional<User> findByUsernameAndPwd(String username, String password);

    Optional<User> findByUsername(String username);
}
