package AnimalClass;

/**
 * Абстрактный класс для всех хищников
 * Хищники могут есть других животных и растения
 */
public abstract class Predator extends Animal {
    
    public Predator(int weight, int maxCountPerCell, int speed, int maxFoodWeight) {
        super(weight, maxCountPerCell, speed, maxFoodWeight);
    }
    
    /**
     * Хищники могут есть других животных
     */
    @Override
    public abstract void eat();
    
    /**
     * Хищники могут есть растения (некоторые виды)
     */
    public abstract boolean canEatPlants();
    
    /**
     * Получить вероятность поедания конкретного животного
     */
    public abstract int getEatingProbability(Animal prey);
}
