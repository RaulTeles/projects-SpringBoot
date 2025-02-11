package br.com.raulteles.project_devdojo.config;

import external.dependecy.Connection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConnectionConfiguration {

    @Value("${database.host}")
    private String host;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

    @Bean
    @Primary
    public Connection connectionMySql(){
        return new Connection(host,username,password);
    }

}
