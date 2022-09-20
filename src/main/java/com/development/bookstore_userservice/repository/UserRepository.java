package com.development.bookstore_userservice.repository;

import com.development.bookstore_userservice.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData,Integer> {
    Optional<UserData> findByLoginId(String loginId);
}
