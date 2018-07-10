package in.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import org.springframework.validation.annotation.Validated;

import in.rest.domain.Book;
import in.rest.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull; 
 
@Service 
@Validated 
@EnableJpaRepositories("in.rest.repository")
public class BookServiceImpl implements BookService { 
 
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    
    @Autowired 
    private final BookRepository booRepository; 
 
   
    public BookServiceImpl(final BookRepository booRepository) { 
        this.booRepository = booRepository; 
    } 
 
    @Override 
    @Transactional 
    public Book saveBook(@NotNull @Valid final Book book) { 
        LOGGER.debug("Creating {}", book); 
        Book existing = booRepository.findById(book.getId()).get(); 
        if (existing != null) { 
            throw new BookAlreadyExistsException( 
                    String.format("There already exists a book with id=%s", book.getId())); 
        } 
        return booRepository.save(book); 
    } 
 
    @Override 
    @Transactional(readOnly = true) 
    public List<Book> getList() { 
        LOGGER.debug("Retrieving the list of all users"); 
        List<Book> target = new ArrayList<>();
        (booRepository.findAll()).forEach(target::add); 
        return target;
    } 
 
    @Override 
    public Book getBook(Long bookId) { 
        return booRepository.findById(bookId).get(); 
    } 
  
    @Override 
    @Transactional 
    public void deleteBook(final Long bookId) { 
        LOGGER.debug("deleting {}", bookId); 
        booRepository.deleteById(bookId); 
    } 
 
} 