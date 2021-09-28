package maximosan.train.repositories;

import java.util.List;
import maximosan.train.models.Book;
import maximosan.train.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    @Query("SELECT u from Users u where name=:name")
    Users findByName(String name);


    Users findByUsername(String username);

    void deleteByUsername(String username);

    @Query("SELECT b.isbn from Users u  inner join Books b  on u.username = b.user_id  where u.username = :username")
    List<String> getUserBooks(String username);
}
