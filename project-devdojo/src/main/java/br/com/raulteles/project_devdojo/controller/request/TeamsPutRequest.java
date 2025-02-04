package br.com.raulteles.project_devdojo.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamsPutRequest {
    private Long id;
    private String name;
}
