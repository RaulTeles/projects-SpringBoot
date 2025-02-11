package br.com.raulteles.project_devdojo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
//Classe criada para expor o contrato apenas dos atributos especificos (desacoplando)
public class CountryTeamsPutRequest {
    private Long id;
    private String name;

}
