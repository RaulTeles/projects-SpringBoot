package br.com.raulteles.user_service.mapper;

import br.com.raulteles.user_service.domain.User;
import br.com.raulteles.user_service.requests.UserPostRequest;
import br.com.raulteles.user_service.requests.UserPutRequest;
import br.com.raulteles.user_service.responses.UserGetResponse;
import br.com.raulteles.user_service.responses.UserPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    User toUser(UserPostRequest userPostRequest);

    User toUser(UserPutRequest userPutRequest);

    UserPostResponse toUserPostResponse(User user);

    UserGetResponse toUserGetResponse(User user);

    List<UserGetResponse> toUserGetResponseList(List<User> users);



}
