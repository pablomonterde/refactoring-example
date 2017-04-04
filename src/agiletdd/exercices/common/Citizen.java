package agiletdd.exercices.common;

public class Citizen {
    private String name;
    private String city;
    private int happiness;

    public Citizen(String username, String city, int happiness) {
        this.name = username;
        this.city = city;
        this.happiness = happiness;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getHappiness() {
        return happiness;
    }
}
