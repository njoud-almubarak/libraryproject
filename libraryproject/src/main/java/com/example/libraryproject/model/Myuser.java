package com.example.libraryproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Myuser {
    @Id
    @NotEmpty(message = "id is required")
    private String id;
    @Column(nullable = false)
    @NotEmpty(message = "username is required")
    private String username;
    @Column(nullable = false)
    @NotEmpty(message = "password is required")
    private String password;

   /* @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> books;*/


}
