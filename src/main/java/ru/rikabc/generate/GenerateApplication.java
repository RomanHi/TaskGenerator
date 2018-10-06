package ru.rikabc.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class GenerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class, args);
        System.out.println(ThreadLocalRandom.current().nextInt(13, 14+1));
    }

    @Bean
    @ConfigurationProperties("datasource")
    public DataSource dataSource() {
        SimpleDriverDataSource build = DataSourceBuilder.create().type(SimpleDriverDataSource.class).build();
        build.setDriverClass(org.postgresql.Driver.class);
        build.setUrl("jdbc:postgresql://localhost:5432/history");
        build.setUsername("postgres");
        build.setPassword("root");
        return build;
    }
}
