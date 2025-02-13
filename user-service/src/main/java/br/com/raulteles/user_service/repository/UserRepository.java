package br.com.raulteles.user_service.repository;

import br.com.raulteles.user_service.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Getter
@RequiredArgsConstructor
public class UserRepository {

    private final UserData userData;

    public List<User> findAll() {
        return userData.getUserList();
    }

    public List<User> findByName(String name) {
        return userData.getUserList().stream().filter(userList -> userList.getFirstName().equalsIgnoreCase(name)).toList();
    }

    public Optional<User> findById(Long id) {
        return userData.getUserList().stream().filter(userList -> userList.getId().equals(id)).findFirst();
    }

    public User save(User user) {
        userData.getUserList().add(user);
        return user;
    }

    public void delete(User user) {
        userData.getUserList().remove(user);
    }

    public void update(User user) {
        delete(user);
        save(user);
    }


}
