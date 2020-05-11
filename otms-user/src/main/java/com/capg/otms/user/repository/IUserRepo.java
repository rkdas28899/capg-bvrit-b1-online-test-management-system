package com.capg.otms.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.otms.user.model.User;

public interface IUserRepo extends JpaRepository<User, Long> {

	User getByUserName(String userName);

}
