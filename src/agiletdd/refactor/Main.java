package agiletdd.refactor;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("Refactor example one.");
        System.out.println("=========================================");
        System.out.println("=========================================");

        Customer mike = new Customer();
        mike.setName("Mike");
        mike.setMovies(new ArrayList<>());
        mike.setPremium(1);
        mike.setBonus(100);
        mike.setTotal(500);

        MovieRentalStoreService movieRentalStoreService = new MovieRentalStoreService();
        List<String> movies = asList("Titanic", "Gladiator");

        RentalTicket ticket = movieRentalStoreService.rentMovies(mike, movies, 10);

        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println(mike.getName() + " has rented these movies: " + mike.getMovies() + " for " + ticket.getTotal() + "€");
        System.out.println("=========================================");
        System.out.println("=========================================");
    }

}
