package com.slippery.wallet.repository;

import com.slippery.wallet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String email);
}
