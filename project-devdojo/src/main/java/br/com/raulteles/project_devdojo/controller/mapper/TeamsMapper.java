package br.com.raulteles.project_devdojo.controller.mapper;

import br.com.raulteles.project_devdojo.controller.domain.Teams;
import br.com.raulteles.project_devdojo.controller.request.TeamsPostRequest;
import br.com.raulteles.project_devdojo.controller.response.TeamsGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeamsMapper {

    TeamsMapper INTANCE = Mappers.getMapper(TeamsMapper.class);

    @Mapping(target = "dateTime", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1,1000))")
    Teams toTeams(TeamsPostRequest postRequest);

    TeamsGetResponse toResponse(Teams teamsGetReponse);
    List<TeamsGetResponse> toResponseList(List<Teams> teamsGetResponseList);
}
