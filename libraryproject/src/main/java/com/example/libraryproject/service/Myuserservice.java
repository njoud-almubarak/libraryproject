package com.example.libraryproject.service;

import com.example.libraryproject.exeption.InvalidId;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Myuser;
import com.example.libraryproject.repository.Bookrepo;
import com.example.libraryproject.repository.Myuserrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Myuserservice {
    private final Myuserrepo myuserrepo;

    public List<Myuser> getuser(){
        return myuserrepo.findAll();
    }


    public void adduser(Myuser myuser){
        myuserrepo.save(myuser);
    }


    public void checkuserid(Integer id) {
        Myuser myuser=myuserrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
    }
}
