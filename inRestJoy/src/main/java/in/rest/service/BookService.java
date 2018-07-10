package in.rest.service;


import javax.validation.Valid; 
import javax.validation.constraints.NotNull;

import in.rest.domain.Book;

import java.util.List; 
 
public interface BookService { 
    Book saveBook(@NotNull @Valid final Book book); 
    List<Book> getList(); 
    Book getBook(Long bookId); 
    void deleteBook(final Long bookId); 
} 