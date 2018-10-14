package draft.test_lambda;

public class Apple {

    Integer weight;
    String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Apple(Integer weight, String country) {
        this.weight = weight;
        this.country = country;
    }
}
