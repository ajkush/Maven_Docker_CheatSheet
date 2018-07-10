package in.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.rest.domain.Book; 

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
