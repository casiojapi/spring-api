package maximosan.train.repositories;

import maximosan.train.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT b from Books b where name=:name")
    Book findByName(String name);
}
