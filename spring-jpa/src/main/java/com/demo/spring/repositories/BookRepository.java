package com.demo.spring.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.dao.Book;

public interface BookRepository extends JpaRepository<Book, String>{
 
}
