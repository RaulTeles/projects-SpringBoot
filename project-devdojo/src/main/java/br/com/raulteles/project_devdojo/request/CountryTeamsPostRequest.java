package br.com.raulteles.project_devdojo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//Classe criada para expor o contrato apenas dos atributos especificos (desacoplando)
public class CountryTeamsPostRequest {
    private String name;

}
