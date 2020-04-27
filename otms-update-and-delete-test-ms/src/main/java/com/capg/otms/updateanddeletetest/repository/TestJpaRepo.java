package com.capg.otms.updateanddeletetest.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.otms.updateanddeletetest.model.Test;


@Repository
public interface TestJpaRepo extends JpaRepository<Test, Long>{

}