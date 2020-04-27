package com.capg.otms.addandassigntest.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capg.otms.addandassigntest.model.Test;

public interface ITestManagementRepo extends JpaRepository<Test, Long> {

}
