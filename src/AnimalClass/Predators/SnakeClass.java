package AnimalClass.Predators;

import AnimalClass.Predator;
import AnimalClass.FeedingMatrix;

/**
 * Класс Удав - хищник
 * Характеристики согласно заданию:
 * - Вес: 15 кг
 * - Максимум на клетке: 30
 * - Скорость: 1 клетка за ход
 * - Пища для насыщения: 3 кг
 */
public class SnakeClass extends Predator {
    
    public SnakeClass() {
        super(15, 30, 1, 3);
    }
    
    @Override
    public void eat() {
        // Логика поедания: Лиса(15%), Кролик(20%), Мышь(40%), Утка(10%)
    }
    
    @Override
    public void move() {
        // Удав может перемещаться на 1 клетку за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения удавов
    }
    
    @Override
    public boolean canEatPlants() {
        return false; // Удавы не едят растения
    }
    
    @Override
    public int getEatingProbability(Animal prey) {
        return FeedingMatrix.getEatingProbability(
            FeedingMatrix.getAnimalIndex(this.getClass()),
            FeedingMatrix.getAnimalIndex(prey.getClass())
        );
    }
}