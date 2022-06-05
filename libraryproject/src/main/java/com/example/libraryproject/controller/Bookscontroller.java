package com.example.libraryproject.controller;

import com.example.libraryproject.DTO.API;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Loan;
import com.example.libraryproject.service.BookService;
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
@RequestMapping("/abi/v1/book")
public class Bookscontroller {

    Logger logger= LoggerFactory.getLogger(Bookscontroller.class);

    private final BookService bookservice;


    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.status(200).body(bookservice.getbook());}



    @PostMapping
    public ResponseEntity<API> addBook(@RequestBody @Valid Book book, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new API(errors.getFieldError().getDefaultMessage(),400));
        }
        bookservice.addbook(book);
        logger.info("add new book");
        return ResponseEntity.status(200).body(new API("New book added",200));}

    @PostMapping("lendbook/{uid}/{bid}")
    public ResponseEntity<API> lendbook(@PathVariable Integer uid,Integer bid) {

        bookservice.lendbook(uid,bid);
        logger.info("book is lended");
        return ResponseEntity.status(200).body(new API("the book is lended",200));}


    @GetMapping("check/{id}")
    public ResponseEntity<API> checkbookid(@PathVariable Integer id){
        bookservice.checkbookid(id);
        return ResponseEntity.status(200).body(new API("Valid book",200));}


  /*  @GetMapping("lendedbook")
    public ResponseEntity<List<Loan>> lendedbook(@PathVariable Integer bid){
        return ResponseEntity.status(200).body(bookservice.lendedbook(bid));}*/
}


