import javax.swing.*;

public class Country {

    private  int lvl;

    JProgressBar progressBar;

   private int population;

   private int percentage;

   private int multiplier = 0;
   private String nazwa;
   private int healthyPeople;
    private  int sickPeople;

    private int cure = 0;

    Country[] borderCountries;

    private boolean closedBorders = false;

    public Country(String nazwa, int healthyPeople, int percentage) {
        this.nazwa = nazwa;
        this.healthyPeople = healthyPeople;
        this.percentage = percentage;
population = healthyPeople;
    }


    public String getNazwa() {
        return nazwa;
    }

    public int getHealthyPeople() {
        return healthyPeople;
    }

    public int getSickPeople() {
        return sickPeople;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setHealthyPeople(int healthyPeople) {
        this.healthyPeople = healthyPeople;
    }

    public void setSickPeople(int sickPeople) {
        this.sickPeople = sickPeople;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getPopulation() {
        return population;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getCure() {
        return cure;
    }

    public void setCure(int cure) {
        this.cure = cure;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public boolean isClosedBorders() {
        return closedBorders;
    }

    public void setClosedBorders(boolean closedBorders) {
        this.closedBorders = closedBorders;
    }

    boolean toBlock() {
        float percentageMet = (float) healthyPeople / population * 100;
        if (percentageMet <= percentage) {
            return true;
        }else{
            return false;
        }
    }

}
