package com.example.cooking.user;

import com.example.cooking.common.repository.GenericSpecificationRepository;
import com.example.cooking.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericSpecificationRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
