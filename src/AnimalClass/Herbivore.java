package AnimalClass;

/**
 * Абстрактный класс для всех травоядных животных
 * Травоядные едят только растения
 */
public abstract class Herbivore extends Animal {
    
    public Herbivore(int weight, int maxCountPerCell, int speed, int maxFoodWeight) {
        super(weight, maxCountPerCell, speed, maxFoodWeight);
    }
    
    /**
     * Травоядные едят только растения
     */
    @Override
    public abstract void eat();
    
    /**
     * Травоядные не могут есть других животных
     */
    public boolean canEatAnimals() {
        return false;
    }
    
    /**
     * Все травоядные могут есть растения
     */
    public boolean canEatPlants() {
        return true;
    }
}
