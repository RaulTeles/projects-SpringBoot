package br.com.raulteles.project_devdojo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
public class TeamsGetResponse  {
    private Long id;
    private String name;
}
