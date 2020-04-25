package com.capg.otms.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.otms.test.model.Test;

public interface ITestManagementRepo extends JpaRepository<Test, Long> {

}
