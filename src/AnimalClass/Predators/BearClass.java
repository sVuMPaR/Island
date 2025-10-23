package AnimalClass.Predators;

import AnimalClass.Predator;
import AnimalClass.FeedingMatrix;
import AnimalClass.Animal;

/**
 * Класс Медведь - хищник
 * Характеристики согласно заданию:
 * - Вес: 500 кг
 * - Максимум на клетке: 5
 * - Скорость: 2 клетки за ход
 * - Пища для насыщения: 80 кг
 */
public class BearClass extends Predator {
    
    public BearClass() {
        super(500, 5, 2, 80);
    }
    
    @Override
    public void eat() {
        // Логика поедания: Удав(80%), Лошадь(40%), Кролик(80%), Мышь(80%), Коза(90%), Овца(70%), Кабан(70%), Буйвол(50%), Утка(20%), Гусеница(10%)
    }
    
    @Override
    public void move() {
        // Медведь может перемещаться на 2 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения медведей
    }
    
    @Override
    public boolean canEatPlants() {
        return false; // Медведи не едят растения (согласно матрице)
    }
    
    @Override
    public int getEatingProbability(Animal prey) {
        return FeedingMatrix.getEatingProbability(
            FeedingMatrix.getAnimalIndex(this.getClass()),
            FeedingMatrix.getAnimalIndex(prey.getClass())
        );
    }
}