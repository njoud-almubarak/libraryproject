package com.example.libraryproject.controller;

import com.example.libraryproject.DTO.API;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Myuser;
import com.example.libraryproject.service.Myuserservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abi/v1/myuser")
public class Myusercontroller {

    Logger logger= LoggerFactory.getLogger(Myusercontroller.class);
    private final Myuserservice userservice;

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.status(200).body(userservice.getuser());}



    @PostMapping
    public ResponseEntity<API> adduser(@RequestBody @Valid Myuser user, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new API(errors.getFieldError().getDefaultMessage(),400));
        }
        userservice.adduser(user);
        logger.info("add new user");
        return ResponseEntity.status(200).body(new API("New user added",200));}



    @GetMapping("check/{id}")
    public ResponseEntity<API> checkuserid(@PathVariable Integer id){
        userservice.checkuserid(id);
        return ResponseEntity.status(200).body(new API("Valid user",200));}
}
