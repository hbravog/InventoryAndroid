package dto;

/**
 * Created by Hernan on 21-09-16.
 */
public class WorldPopulationDTO {
    private String rank;
    private String country;
    private String population;

    public WorldPopulationDTO(String rank, String country, String population) {
        this.rank = rank;
        this.country = country;
        this.population = population;
    }

    public String getRank() {
        return this.rank;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPopulation() {
        return this.population;
    }
}
