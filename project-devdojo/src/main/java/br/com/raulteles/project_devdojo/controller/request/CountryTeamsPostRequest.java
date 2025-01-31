package br.com.raulteles.project_devdojo.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Classe criada para expor o contrato apenas dos atributos especificos (desacoplando)
public class CountryTeamsPostRequest {
    private String name;

}
