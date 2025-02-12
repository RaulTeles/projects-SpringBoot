package br.com.raulteles.user_service.repository;

import br.com.raulteles.project_devdojo.domain.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    {
        var usr1 = new User(1L,"Raul","Teles","email@email.com");
        var usr2 = new User(2L,"Relampago","Marquinhos","katchau@email.com");
        userList.addAll(List.of(usr1,usr2));
    }

    public List<User> findAll(){
        return getUserList();
    }

    public List<User> findByName(String name){
        return getUserList().stream().filter(userList -> userList.getFirstName().equalsIgnoreCase(name)).toList();
    }

    public Optional<User> findById(Long id){
        return getUserList().stream().filter(userList -> userList.getId().equals(id)).findFirst();
    }

    public User save(User user){
        userList.add(user);
        return user;
    }

    public void delete(User user){
        userList.remove(user);
    }

    public void update(User user){
        delete(user);
        save(user);
    }


}
