package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Олень - травоядное
 * Характеристики согласно заданию:
 * - Вес: 300 кг
 * - Максимум на клетке: 20
 * - Скорость: 4 клетки за ход
 * - Пища для насыщения: 50 кг
 */
public class DeerClass extends Herbivore {
    
    public DeerClass() {
        super(300, 20, 4, 50);
    }
    
    @Override
    public void eat() {
        // Олени едят только растения (100% вероятность)
    }
    
    @Override
    public void move() {
        // Олень может перемещаться на 4 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения оленей
    }
}