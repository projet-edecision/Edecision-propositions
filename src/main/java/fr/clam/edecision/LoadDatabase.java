package fr.clam.edecision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.UUID;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(propositionRepository repository) {

        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        UUID uuid3 = UUID.randomUUID();
        UUID uuid4 = UUID.randomUUID();

        propositionEntity proposition1 = new propositionEntity(uuid1, uuid2, "1" , "Test1", "ttt1", new Date(10/05/2023), new Date(12/05/2023));
        propositionEntity proposition2 = new propositionEntity(uuid3, uuid4, "2" , "Test2", "ttt2", new Date(8/05/2023), new Date(15/05/2023));

        return args -> {
            log.info("Preloading " + repository.save(proposition1));
            log.info("Preloading " + repository.save(proposition2));
        };
    }
}
