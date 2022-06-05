package com.example.libraryproject.controller;

import com.example.libraryproject.DTO.API;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Loan;
import com.example.libraryproject.service.Loanservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abi/v1/loan")
public class Loancontroller {

    Logger logger= LoggerFactory.getLogger(Loancontroller.class);
    private final Loanservice loanservice;


    @GetMapping
    public ResponseEntity getLoan() {
        return ResponseEntity.status(200).body(loanservice.getloan());}



    @PostMapping
    public ResponseEntity<API> addLoan(@RequestBody @Valid Loan loan, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new API(errors.getFieldError().getDefaultMessage(),400));
        }
        loanservice.addloan(loan);
        logger.info("add new laon");
        return ResponseEntity.status(200).body(new API("New loan added",200));}

  /*  @GetMapping("lendedbook")
    public ResponseEntity<List<Loan>> lendedbook(@PathVariable Integer bid){
        return ResponseEntity.status(200).body(loanservice.lendedbook(bid));}*/


    @PostMapping("lendedbybookid/{bid}")
    public ResponseEntity getloanbookbybookid(@PathVariable Integer bid){
        return ResponseEntity.status(200).body( loanservice.getloanbookbybookid(bid));
    }
    @PostMapping("lendedbyuserid/{uid}")
    public ResponseEntity getloanbookbyuserid(@PathVariable Integer uid){
        return ResponseEntity.status(200).body( loanservice.lendedbooksbyuserid(uid));
    }

    @GetMapping("check/{id}")
    public ResponseEntity<API> checkloanid(@PathVariable Integer id){
        loanservice.checkloanid(id);
        return ResponseEntity.status(200).body(new API("Valid loan",200));}
}
