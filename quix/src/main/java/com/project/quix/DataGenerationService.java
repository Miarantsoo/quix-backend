package com.project.quix;

import com.github.javafaker.Faker;
import com.project.quix.client.Client;
import com.project.quix.parrainage.Parrainage;
import com.project.quix.client.ClientRepository;
import com.project.quix.parrainage.ParrainageRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class DataGenerationService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ParrainageRepository parrainageRepository;

    private final Faker faker = new Faker(new Locale("fr", "MG"));
    private final Random random = new Random();

//    @PostConstruct
//    public void generateData() {
//        generateParrainages();
//        generateClients();
//    }

    private void generateParrainages() {
        String[] types = {"Type A", "Type B", "Type C"};
        for (String type : types) {
            Parrainage parrainage = new Parrainage(type);
            parrainageRepository.save(parrainage);
        }
    }

    private void generateClients() {
        for (int i = 0; i < 1000; i++) {
            Client parrain = generateSingleClient(null);
            clientRepository.save(parrain);
            // Optional: If you want each client to have some children (parrains), uncomment the below lines
            // for (int j = 0; j < 3; j++) {
            //     Client client = generateSingleClient(parrain);
            //     clientRepository.save(client);
            // }
        }
    }

    private Client generateSingleClient(Client parrain) {
        Parrainage parrainage = parrainageRepository.findAll().get(random.nextInt(3));
        Date date = faker.date().birthday();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date dateCin = faker.date().past(365 * 20, TimeUnit.DAYS);
        LocalDate localDateCin = dateCin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        return new Client(
                null,
                faker.name().lastName(),
                faker.name().firstName(),
                random.nextInt(2),
                faker.address().streetAddress(),
                localDate,
                faker.address().city(),
                faker.number().randomNumber(8, true),
                localDateCin,
                faker.address().city(),
                faker.internet().emailAddress(),
                faker.phoneNumber().cellPhone(),
                faker.job().title(),
                faker.company().name(),
                parrain,
                parrainage,
                random.nextInt(3)
        );
    }
}

