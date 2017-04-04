package agiletdd.exercices;

import agiletdd.exercices.common.Citizen;
import agiletdd.exercices.common.CitizenRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefactorAnnotations {

    private static final int MAX_CITY_HAPPINESS = 100000;

	public Map refactor() {
        CitizenRepository citizenRepository = new CitizenRepository();
        Map<String, Integer> happinessByCity = InitializeCityHappiness(); // Inicializa la felicidad de las ciudades
        List<Citizen> allCitizens = citizenRepository.allCitizens(); // Recupera todos los ciudadanos

        /**
         * Este bloque recorre todas los usuarios y actualiza la felicidad
         * de las ciudades en función de usus ciudadanos
         */
        updateCitiesWithCitizenHappiness(happinessByCity, allCitizens);

        // Devuelve un mapa con las ciudades y la felicidad de sus ciudadanos
        return happinessByCity;
    }

	private void updateCitiesWithCitizenHappiness(Map<String, Integer> happinessByCity, List<Citizen> allCitizens) {
		for (int index = 0; index < allCitizens.size(); index++) {
            Citizen citizen = allCitizens.get(index); // Recuperamos un ciudadano
            updateCityHappiness(citizen, happinessByCity); // Actualiza la felicidad de una ciudad
        }
	}

    private void updateCityHappiness(Citizen citizen, Map<String, Integer> happinessByCity) {
        // Valor inicial de la felicidad de la ciudad del usuario
        int initialHappiness = happinessByCity.get(citizen.getCity());
        // Valor final de la felicidad de la ciudad del usuario
        int newHappiness = initialHappiness + citizen.getHappiness();
        // Actuliza la felicidad de la ciudad del usuario
        happinessByCity.put(citizen.getCity(), newHappiness);
        // Si un usario tiene una felicidad mayor que 100 se lanza una excepcion
        if(newHappiness > MAX_CITY_HAPPINESS)
        	throw new RuntimeException("City citizens are extremely happy.");
    }

    private Map<String, Integer> InitializeCityHappiness() {
        Map<String, Integer> happinessByCity = new HashMap<>();

        happinessByCity.put("Valencia", 0);
        happinessByCity.put("Madrid", 0);
        happinessByCity.put("Barcelona", 0);
        happinessByCity.put("Sevilla", 0);

        return happinessByCity;
    }


}
