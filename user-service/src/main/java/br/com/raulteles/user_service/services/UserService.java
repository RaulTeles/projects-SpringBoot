package br.com.raulteles.user_service.services;

import br.com.raulteles.project_devdojo.domain.User;
import br.com.raulteles.project_devdojo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll(String name) {
        return name == null ? repository.findAll() : repository.findByName(name);
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public User save(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.delete(findById(id));
    }

    public void update(User user){
        var userUpdate = findById(user.getId());
        userUpdate.setEmail(userUpdate.getEmail());
        repository.update(user);
    }


}
