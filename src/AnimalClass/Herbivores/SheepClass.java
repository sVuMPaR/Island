package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Овца - травоядное
 * Характеристики согласно заданию:
 * - Вес: 70 кг
 * - Максимум на клетке: 140
 * - Скорость: 3 клетки за ход
 * - Пища для насыщения: 15 кг
 */
public class SheepClass extends Herbivore {
    
    public SheepClass() {
        super(70, 140, 3, 15);
    }
    
    @Override
    public void eat() {
        // Овцы едят только растения (100% вероятность)
    }
    
    @Override
    public void move() {
        // Овца может перемещаться на 3 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения овец
    }
}