package br.com.raulteles.project_devdojo.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class TeamsGetResponse  {
    private Long id;
    private String name;
}
