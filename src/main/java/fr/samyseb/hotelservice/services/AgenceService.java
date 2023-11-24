package fr.samyseb.hotelservice.services;

import fr.samyseb.hotelservice.AgenceApplication;
import fr.samyseb.hotelservice.entities.Agence;
import fr.samyseb.hotelservice.repositories.AgenceRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class AgenceService {

    private static final Logger logger = LoggerFactory.getLogger(AgenceApplication.class);

    private final Environment environment;
    private final AgenceRepository agenceRepository;

    @Getter
    private Agence identity;

    /**
     * Lors du démarrage de l'application, on récupère l'identité de l'hôtel dans l'environnement,
     * l'insère dans la base de donnée et l'assigne dans une variable.
     */
    @PostConstruct
    public void onStartup() throws MalformedURLException {
        identity = agenceRepository.save(Agence.builder()
                .nom(environment.getRequiredProperty("agence.nom"))
                .motDePasse(environment.getProperty("agence.motDePasse"))
                .url(new URL("http", environment.getProperty("server.address"),
                        environment.getRequiredProperty("server.port", Integer.class),
                        ""))
                .build());

        logger.info("L'identité de l'agence à été définie à: %s.".formatted(identity()));
    }

    /**
     * Supprime l'identité de la base de donnée
     */
    @PreDestroy
    public void onShutdown() {
        agenceRepository.delete(identity);
        logger.info("Suppression de l'agence dans la liste des hôtels effectuée.");
    }

}
