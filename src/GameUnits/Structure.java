package GameUnits;

public  abstract class Structure extends GameUnit {
    private int population = 0;

    public void setPopulation(int population){
        if(population < 0){
            population = 0;
        }
        this.population = population;
    }
    public int getPopulation(){
        return population;
    }

}
