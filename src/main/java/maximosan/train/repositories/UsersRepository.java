package maximosan.train.repositories;

import maximosan.train.models.Book;
import maximosan.train.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    @Query("SELECT u from Users u where name=:name")
    Users findByName(String name);
}
