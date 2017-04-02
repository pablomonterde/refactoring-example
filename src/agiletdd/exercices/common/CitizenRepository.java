package agiletdd.exercices.common;

import java.util.List;

import static java.util.Arrays.asList;

public class CitizenRepository {

    public List<Citizen> allCitizens() {
        return asList(
                new Citizen("Marta", "Valencia", 100),
                new Citizen("Juan", "Madrid", 80),
                new Citizen("Pedro", "Barcelona", 90),
                new Citizen("Maria", "Sevilla", 95),
                new Citizen("Fernando", "Valencia", 95),
                new Citizen("Paco", "Madrid", 80),
                new Citizen("Nacho", "Barcelona", 90),
                new Citizen("Alba", "Sevilla", 95),
                new Citizen("Irene", "Valencia", 95)
        );

    }
}
