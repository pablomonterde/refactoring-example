package agiletdd.refactor;

import java.util.ArrayList;
import java.util.List;

public class MovieRentalStoreService {

    public RentalTicket rentMovies(Customer auxCus, List<String> mo, int d) {
        RentalTicket auxti = new RentalTicket();
        int t = 0;
        int b = 0;
        List<String> m = new ArrayList<>();

        int extra = 0;
        System.out.println("paso 1");
        for (int i = 0; i < auxCus.getMovies().size(); i++) {
            extra += 15;
        }

        System.out.println("paso 2");
        // Suma el precio de cada pelicula multiplicado por los dias
        // y lo suma al precio total
        if (auxCus.getPremium() == 0) {
            System.out.println("el usuario es No es premium");
            // Si el cliente no es premium no se aplica descuento
            for (int i = 0; i < mo.size(); i++) {
                System.out.println("paso 3.1: " + i);

                if (mo.get(i) == "Titanic") {
                    t += 10 * d;   // el precio de las peliculas normales es de 10 al dia.
                } else if (mo.get(i) == "Gladiator") {
                    t += 10 * d;
                } else if (mo.get(i) == "La La Land") {
                    t += 20 * d; // el precio de las peliculas nuevas es de 20 al dia.
                } else if (mo.get(i) == "Moonlight") {
                    t += 20 * d;
                } else if (mo.get(i) == "Frozen") {
                    t += 5 * d; // el precio de las peliculas para niños es de 5 al dia.
                } else if (mo.get(i) == "Toy Story") {
                    t += 5 * d;
                }
                System.out.println("paso 3.1: " + t + ", " + b);
            }
        } else {
            System.out.println("el usuario es si es premium");
            // Si el cliente SI es premium  se aplica descuento y se le da bonus
            for (int i = 0; i < mo.size(); i++) {

                if (mo.get(i) == "Titanic") {
                    t += 8 * d;   // 2€ de descuento si es premium en peliculas normales
                    b += 1;
                } else if (mo.get(i) == "Gladiator") {
                    t += 8 * d;
                    b += 1;
                } else if (mo.get(i) == "La La Land") {
                    t += 15 * d; // 5€ de descuento si es premium en peliculas nuevas
                    b += 5;
                } else if (mo.get(i) == "Moonlight") {
                    t += 15 * d;
                    b += 5;
                } else if (mo.get(i) == "Frozen") {
                    t += 4 * d; // 5€ de descuento si es premium en peliculas para niños
                    b += 2;
                } else if (mo.get(i) == "Toy Story") {
                    t += 4 * d;
                    b += 5;
                }
                System.out.println("paso 3.2: " + t + ", " + b);
            }
        }

        // Añado un extra si el cliente tenia peliculas sin devolver y le quito el bonus si es premium
        t += extra;
        if (auxCus.getPremium() == 1 && extra > 0) {
            System.out.println("le quito el bonus");
            b = 0;
        }

        // defino el cliente
        auxti.setCustomer(auxCus);
        // defino las peliculas
        auxti.setMovies(mo);
        // defino el precio total
        int auxTotal2 = b + auxCus.getTotal();
        auxti.setTotal(t);
        // defino el bonus total del cliente
        int auxBonus2 = b + auxCus.getBonus();
        auxCus.setBonus(b);
        // defino las peliculas del cliente
        for (int i = 0; i < mo.size(); i++) {
            auxCus.getMovies().add(mo.get(i));
        }

        return auxti;
    }

}
