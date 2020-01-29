package com.rishabh.springboot.controller;

import org.springframework.http.ResponseEntity;



public interface ControllerInterface {

    public ResponseEntity<Object> deleteUser(String ecode);
}
