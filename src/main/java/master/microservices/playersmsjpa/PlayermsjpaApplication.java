package master.microservices.playersmsjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@SpringBootApplication()
public class PlayermsjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayermsjpaApplication.class, args);
    }

    @Bean
    public InitBD schedulerRunner() {
        return new InitBD();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
