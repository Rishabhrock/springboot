package com.rishabh.springboot.databasecontroller;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface DataBaseRepo extends JpaRepository<DataBaseImplementaion,String> {


//
//    @Override
//    public List<DataBaseImplementaion> findAll();
//
//    @Query(nativeQuery = true,value = "Select * from table_name where ecode={ecode}")
//    public List<DataBaseImplementaion> findByUser(@Param("ecode") String ecode);

}
