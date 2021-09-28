package maximosan.train.repositories;

import java.util.List;
import maximosan.train.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u from Users u where name=:name")
    User findByName(String name);


    User findByUsername(String username);

    void deleteByUsername(String username);

    @Query("SELECT b.isbn from Users u  inner join Books b  on u.username = b.user_id  where u.username = :username")
    List<String> getUserBooks(String username);
}
