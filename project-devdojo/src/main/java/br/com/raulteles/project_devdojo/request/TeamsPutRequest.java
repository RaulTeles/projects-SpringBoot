package br.com.raulteles.project_devdojo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamsPutRequest {
    private Long id;
    private String name;
}
