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
    public void eat() {
        // Хищники могут есть других животных
        // Базовая реализация - попытка найти и съесть жертву
        if (currentFoodWeight < maxFoodWeight) {
            // Симуляция поедания жертвы
            currentFoodWeight = Math.min(maxFoodWeight, currentFoodWeight + 15);
        }
    }
    
    /**
     * Хищники могут есть растения (некоторые виды)
     */
    public abstract boolean canEatPlants();
    
    /**
     * Получить вероятность поедания конкретного животного
     */
    public abstract int getEatingProbability(Animal prey);
}
