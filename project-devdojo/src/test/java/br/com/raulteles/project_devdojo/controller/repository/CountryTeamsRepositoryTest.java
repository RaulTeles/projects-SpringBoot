package br.com.raulteles.project_devdojo.controller.repository;

import br.com.raulteles.project_devdojo.domain.CountryTeams;
import br.com.raulteles.project_devdojo.repository.CountryTeamsData;
import br.com.raulteles.project_devdojo.repository.CountryTeamsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CountryTeamsRepositoryTest {

//    Injeção de dependencia com o Mockito
    @InjectMocks
//    Passando a classe alvo de teste
    private CountryTeamsRepository repository;

    @Mock
    private CountryTeamsData countryTeamsData;


    private final List<CountryTeams> countryTeams = new ArrayList<>();

    @BeforeEach
    void init(){
            var bra = CountryTeams.builder().id(1L).name("Brazil").dateTime(LocalDateTime.now()).build();
            var arg = CountryTeams.builder().id(2L).name("Argentina").dateTime(LocalDateTime.now()).build();
            var usa = CountryTeams.builder().id(3L).name("United States").dateTime(LocalDateTime.now()).build();
            var bol = CountryTeams.builder().id(4L).name("Bolivia").dateTime(LocalDateTime.now()).build();
            countryTeams.addAll(List.of(bra,arg,usa,bol));
            BDDMockito.when(countryTeamsData.getCountryTeams()).thenReturn(countryTeams);

    }

    @Test
    @DisplayName("findAll return list with all Country")
    void findAllReturnAllCountry_WhenSucess(){
        var countryTeams = repository.findAll();
        Assertions.assertThat(countryTeams).isNotNull().hasSameElementsAs(countryTeams);
    }

    @Test
    @DisplayName("findByID return object with id")
    void findByIdReturnObject_WhenSucess(){
//        Garantindo que está pegando o primeiro ID
        var expectedCountryId = countryTeams.getFirst();
        var countryTeams = repository.findById(expectedCountryId.getId());
//        Anteção, esta retornando um Optional
        Assertions.assertThat(countryTeams).isPresent().contains(expectedCountryId);
    }

    @Test
    @DisplayName("FindName return list empty when the name is null")
    void findNameReturtListEmpty_WhenSucess(){
        var countryTeams = repository.findName(null);
        Assertions.assertThat(countryTeams).isNotNull().isEmpty();
    }

    @Test
    @DisplayName("FindName return name found")
    void findNameReturnNameFound_WhenSucess(){
        var expectedCountryId = countryTeams.getFirst();
        var countryTeams = repository.findName(expectedCountryId.getName());
        Assertions.assertThat(countryTeams).contains(expectedCountryId);
    }



}