package br.com.raulteles.project_devdojo.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CountryTeamsGetResponse {
    private Long id;
    private String name;
    private LocalDateTime dateTime;

}
