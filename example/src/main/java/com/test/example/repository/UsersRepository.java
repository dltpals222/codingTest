package com.test.example.repository;

import com.test.example.repository.entity.UsersScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersScore, Long> {
}
