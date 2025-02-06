package br.com.raulteles.project_devdojo.controller.mapper;

import br.com.raulteles.project_devdojo.controller.domain.CountryTeams;
import br.com.raulteles.project_devdojo.controller.request.CountryTeamsPostRequest;
import br.com.raulteles.project_devdojo.controller.request.CountryTeamsPutRequest;
import br.com.raulteles.project_devdojo.controller.response.CountryTeamsGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "dateTime", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1,1000))")
    CountryTeams toCountryTeams(CountryTeamsPostRequest postRequest);
//    Passando o Local, para ser mantido ao atualizar o objeto
    CountryTeams toCountryTeams(CountryTeamsPutRequest putRequest);

    CountryTeamsGetResponse toCountryTeamsGetResponse(CountryTeams countryTeams);
    List<CountryTeamsGetResponse> toResonseList(List<CountryTeams> countryTeamsGetResponseList);

}
