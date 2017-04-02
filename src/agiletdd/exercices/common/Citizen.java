package agiletdd.exercices.common;

public class Citizen {

    private String username;
    private String city;
    private int happiness;

    public Citizen(String username, String city, int happiness) {
        this.username = username;
        this.city = city;
        this.happiness = happiness;
    }

    public String getUsername() {
        return username;
    }

    public String getCity() {
        return city;
    }

    public int getHappiness() {
        return happiness;
    }
}
