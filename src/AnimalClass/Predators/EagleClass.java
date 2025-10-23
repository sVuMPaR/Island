package AnimalClass.Predators;

import AnimalClass.Predator;
import AnimalClass.FeedingMatrix;
import AnimalClass.Animal;

/**
 * Класс Орел - хищник
 * Характеристики согласно заданию:
 * - Вес: 6 кг
 * - Максимум на клетке: 20
 * - Скорость: 3 клетки за ход
 * - Пища для насыщения: 1 кг
 */
public class EagleClass extends Predator {
    
    public EagleClass() {
        super(6, 20, 3, 1);
    }
    
    @Override
    public void eat() {
        // Логика поедания: Лиса(10%), Кролик(90%), Мышь(90%), Утка(80%)
    }
    
    @Override
    public void move() {
        // Орел может перемещаться на 3 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения орлов
    }
    
    @Override
    public boolean canEatPlants() {
        return false; // Орлы не едят растения
    }
    
    @Override
    public int getEatingProbability(Animal prey) {
        return FeedingMatrix.getEatingProbability(
            FeedingMatrix.getAnimalIndex(this.getClass()),
            FeedingMatrix.getAnimalIndex(prey.getClass())
        );
    }
}