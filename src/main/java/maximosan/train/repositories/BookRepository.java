package maximosan.train.repositories;

import java.util.List;
import java.util.Optional;
import maximosan.train.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT b from Books b where name=:name")
    Book findByName(String name);

    List findByTitle(String bookTitle);

    Book findByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
