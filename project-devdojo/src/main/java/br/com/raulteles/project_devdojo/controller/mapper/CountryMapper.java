package br.com.raulteles.project_devdojo.controller.mapper;

import br.com.raulteles.project_devdojo.controller.domain.CountryTeams;
import br.com.raulteles.project_devdojo.controller.request.CountryTeamsPostRequest;
import br.com.raulteles.project_devdojo.controller.response.CountryTeamsGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "dateTime", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1,1000))")
    CountryTeams toCountryTeams(CountryTeamsPostRequest postRequest);

    CountryTeamsGetResponse toCountryTeamsGetResponse(CountryTeams countryTeams);


}
