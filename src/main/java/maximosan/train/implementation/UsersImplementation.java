package maximosan.train.implementation;

import maximosan.train.models.Users;
import maximosan.train.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersImplementation {

    @Autowired
    private UsersRepository usersRepository;

    public Users findByName(String name) {
        // if (findByName(name) == null) return exception;
        return usersRepository.findByName(name);
    }
}
