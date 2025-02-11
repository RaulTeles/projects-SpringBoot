package br.com.raulteles.project_devdojo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class TeamsPostResponse {
    private Long id;
    private String name;
}
