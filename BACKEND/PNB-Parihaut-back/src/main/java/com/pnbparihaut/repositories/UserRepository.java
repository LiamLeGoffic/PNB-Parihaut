package com.pnbparihaut.repositories;

import com.pnbparihaut.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
