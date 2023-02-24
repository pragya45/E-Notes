package com.enotes.repository;

import com.enotes.entity.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDtls,Integer> {

    public UserDtls findByEmail(String email);


    Optional<UserDtls> findUserDtlsByName(String full_name);



}
