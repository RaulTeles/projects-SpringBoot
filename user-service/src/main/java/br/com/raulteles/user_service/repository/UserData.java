package br.com.raulteles.user_service.repository;

import br.com.raulteles.user_service.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserData {
    private final List<User> userList = new ArrayList<>();

    {
        var usr1 = User.builder().id(1L).firstName("Raul").lastName("Teles").email("email@email.com").build();
        var usr2 = User.builder().id(2L).firstName("Relampago").lastName("marquinhs").email("relampago@email.com").build();
        userList.addAll(List.of(usr1, usr2));
    }

    public List<User> getUserList() {
        return userList;
    }
}
