package com.college.repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByToken(String token);

	Optional<User> findByEmail(String email);
	Optional<User> findByToken2(String token2);

	Optional<User> findByToken3(String token3);

	Optional<User> findByEmailAndPassword(String email, String password);

}
