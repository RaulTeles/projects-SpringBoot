package br.com.raulteles.project_devdojo.mapper;

import br.com.raulteles.project_devdojo.domain.Teams;
import br.com.raulteles.project_devdojo.request.TeamsPostRequest;
import br.com.raulteles.project_devdojo.request.TeamsPutRequest;
import br.com.raulteles.project_devdojo.response.TeamsGetResponse;
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
    Teams toTeams(TeamsPutRequest putRequest);

    TeamsGetResponse toResponse(Teams teamsPosReponse);
    List<TeamsGetResponse> toResponseList(List<Teams> teamsGetResponseList);


}