package agiletdd.exercices;

import agiletdd.exercices.common.Citizen;
import agiletdd.exercices.common.CitizenRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefactorNaming {

    public Map refactor() {
        CitizenRepository rep = new CitizenRepository();
        Map<String, Integer> map = create(); // Inicializa la felicidad de las ciudades
        List<Citizen> aux = rep.allCitizens(); // Recupera todos los ciudadanos


        for (int i = 0; i < aux.size(); i++) {
            Citizen aux2 = aux.get(i); // Recuperamos un ciudadano
            updateMap(aux2, map); // Actualiza la felicidad de una ciudad
        }

        // Devuelve un mapa con las ciudades y la felicidad de sus ciudadanos
        return map;
    }

    private void updateMap(Citizen u, Map<String, Integer> m) {
        // Valor inicial de la felicidad de la ciudad del usuario
        int value = m.get(u.getCity());
        // Valor final de la felicidad de la ciudad del usuario
        value = value + u.getHappiness();
        // Actuliza la felicidad de la ciudad del usuario
        m.put(u.getCity(), value);
        // Si un usario tiene una felicidad mayor que 100 se lanza una excepcion
        if(value > 10000)
        	throw new RuntimeException("City citizens are extremely happy.");
    }

    private Map<String, Integer> create() {
        Map<String, Integer> map = new HashMap<>();

        map.put("Valencia", 0);
        map.put("Madrid", 0);
        map.put("Barcelona", 0);
        map.put("Sevilla", 0);

        return map;
    }


}
