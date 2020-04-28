package com.capg.otms.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.otms.users.model.User;

public interface IUserRepo extends JpaRepository<User, Long> {

}
