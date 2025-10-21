package AnimalClass.Herbivores;

import AnimalClass.Herbivore;
import AnimalClass.FeedingMatrix;

/**
 * Класс Лошадь - травоядное
 * Характеристики согласно заданию:
 * - Вес: 400 кг
 * - Максимум на клетке: 20
 * - Скорость: 4 клетки за ход
 * - Пища для насыщения: 60 кг
 */
public class HorseClass extends Herbivore {
    
    public HorseClass() {
        super(400, 20, 4, 60);
    }
    
    @Override
    public void eat() {
        // Лошади едят только растения (100% вероятность)
    }
    
    @Override
    public void move() {
        // Лошадь может перемещаться на 4 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения лошадей
    }
}