package com.myhotel.userservice.repository;

import com.myhotel.userservice.entity.UserDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  UserRepository extends JpaRepository<UserDatabase, String> {
     @Query("select u from UserDatabase u where u.userPh = :n")
    public UserDatabase findByByMNumber(@Param("n") String n);
}
