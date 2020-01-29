package com.rishabh.springboot.databasecontroller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface BranchRepo extends JpaRepository<BranchDataBase,String> {

}
