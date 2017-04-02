package agiletdd.refactor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieRentalStoreServiceTest {


    MovieRentalStoreService movieRentalStoreService;
    Customer customer;

    @Before
    public void setUp() throws Exception {
        movieRentalStoreService = new MovieRentalStoreService();
        customer = new Customer();

        customer.setName("Mike");
        customer.setMovies(new ArrayList<>());
        customer.setBonus(0);
        customer.setPremium(0);
        customer.setTotal(0);
    }

    @Test
    public void should_rental_a_regular_movie_to_a_customer() throws Exception {
        List<String> movies = asList("Titanic");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 1);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(10, is(ticket.getTotal()));
        assertThat(movies, hasItems("Titanic"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Titanic"));
    }

    @Test
    public void should_rental_a_new_movie_to_a_customer() throws Exception {
        List<String> movies = asList("La La Land");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 1);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(20, is(ticket.getTotal()));
        assertThat(movies, hasItems("La La Land"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("La La Land"));
    }

    @Test
    public void should_rental_a_children_movie_to_a_customer() throws Exception {
        List<String> movies = asList("Frozen");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 1);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(5, is(ticket.getTotal()));
        assertThat(movies, hasItems("Frozen"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Frozen"));
    }

    @Test
    public void should_rental_more_than_one_regular_movies() throws Exception {
        List<String> movies = asList("Titanic", "Gladiator");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 1);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(20, is(ticket.getTotal()));
        assertThat(movies, hasItems("Titanic", "Gladiator"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Titanic", "Gladiator"));
    }

    @Test
    public void should_rental_more_than_one_new_movies() throws Exception {
        List<String> movies = asList("Moonlight", "La La Land");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 1);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(40, is(ticket.getTotal()));
        assertThat(movies, hasItems("Moonlight", "La La Land"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Moonlight", "La La Land"));
    }

    @Test
    public void should_rental_more_than_one_children_movies() throws Exception {
        List<String> movies = asList("Frozen", "Toy Story");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 1);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(10, is(ticket.getTotal()));
        assertThat(movies, hasItems("Frozen", "Toy Story"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Frozen", "Toy Story"));
    }

    @Test
    public void should_rental_more_than_one_new_movies_for_many_days() throws Exception {
        List<String> movies = asList("Moonlight", "La La Land");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 10);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(400, is(ticket.getTotal()));
        assertThat(movies, hasItems("Moonlight", "La La Land"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Moonlight", "La La Land"));
    }

    @Test
    public void should_rental_more_than_children_movies_for_many_days() throws Exception {
        List<String> movies = asList("Frozen", "Toy Story");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 10);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(100, is(ticket.getTotal()));
        assertThat(movies, hasItems("Frozen", "Toy Story"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Frozen", "Toy Story"));
    }

    @Test
    public void should_rental_more_mixed_movies_for_many_days() throws Exception {
        List<String> movies = asList("Frozen", "La La Land", "Titanic");

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 10);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(350, is(ticket.getTotal()));
        assertThat(movies, hasItems("Frozen", "La La Land", "Titanic"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Frozen", "La La Land", "Titanic"));
    }

    @Test
    public void should_get_discount_and_bonus_points_when_a_customer_is_premium() throws Exception {
        List<String> movies = asList("Frozen", "La La Land", "Titanic");

        customer.setPremium(1);

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 10);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(8, is(ticket.getCustomer().getBonus()));
        assertThat(270, is(ticket.getTotal()));
        assertThat(movies, hasItems("Frozen", "La La Land", "Titanic"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Frozen", "La La Land", "Titanic"));
    }

    @Test
    public void should_get_a_penalty_per_movie_when_already_has_a_not_returned_movie() throws Exception {
        List<String> movies = asList("Titanic");

        customer.getMovies().add("Gladiator");
        customer.getMovies().add("Frozen");
        customer.setBonus(1);

        RentalTicket ticket = movieRentalStoreService.rentMovies(customer, movies, 1);

        assertThat("Mike", is(ticket.getCustomer().getName()));
        assertThat(0, is(ticket.getCustomer().getBonus()));
        assertThat(40, is(ticket.getTotal()));
        assertThat(movies, hasItems("Titanic"));
        assertThat(ticket.getCustomer().getMovies(), hasItems("Titanic", "Gladiator","Frozen"));
    }

}
