package agiletdd.refactor;

import java.util.List;

public class RentalTicket {

    private Customer customer;

    private int total;

    private List<String> movies;

    public RentalTicket() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<String> setMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }








}
