package AnimalClass.Predators;

import AnimalClass.Animal;
import AnimalClass.Predator;
import AnimalClass.FeedingMatrix;
import java.util.Random;

/**
 * Класс Волк - хищник
 * Характеристики согласно заданию:
 * - Вес: 50 кг
 * - Максимум на клетке: 30
 * - Скорость: 3 клетки за ход
 * - Пища для насыщения: 8 кг
 */
public class WolfClass extends Predator {
    
    public WolfClass() {
        super(50, 30, 3, 8);
    }
    
    @Override
    public void eat() {
        // Логика поедания других животных
    }
    
    @Override
    public void move() {
        // Волк может перемещаться на 3 клетки за ход
        Random random = new Random();
        int moveDistance = random.nextInt(speed + 1);
        // Логика перемещения
    }
    
    @Override
    public void reproduce() {
        // Логика размножения волков
    }
    
    @Override
    public boolean canEatPlants() {
        return false; // Волки не едят растения
    }

    @Override
    public int getEatingProbability(Animal prey) {
        return FeedingMatrix.getEatingProbability(
            FeedingMatrix.getAnimalIndex(this.getClass()),
            FeedingMatrix.getAnimalIndex(prey.getClass())
        );
    }
}