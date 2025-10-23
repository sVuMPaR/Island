package AnimalClass.Predators;

import AnimalClass.Animal;
import AnimalClass.Predator;
import AnimalClass.FeedingMatrix;

/**
 * Класс Лиса - хищник
 * Характеристики согласно заданию:
 * - Вес: 8 кг
 * - Максимум на клетке: 30
 * - Скорость: 2 клетки за ход
 * - Пища для насыщения: 2 кг
 */
public class FoxClass extends Predator {
    
    public FoxClass() {
        super(8, 30, 2, 2);
    }
    
    @Override
    public void eat() {
        // Логика поедания: Кролик(70%), Мышь(90%), Утка(60%), Гусеница(40%), Растения(40%)
    }
    
    @Override
    public void move() {
        // Лиса может перемещаться на 2 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения лис
    }
    
    @Override
    public boolean canEatPlants() {
        return true; // Лисы могут есть растения
    }
    
    @Override
    public int getEatingProbability(Animal prey) {
        return FeedingMatrix.getEatingProbability(
            FeedingMatrix.getAnimalIndex(this.getClass()),
            FeedingMatrix.getAnimalIndex(prey.getClass())
        );
    }
}