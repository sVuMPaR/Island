package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Коза - травоядное
 * Характеристики согласно заданию:
 * - Вес: 60 кг
 * - Максимум на клетке: 140
 * - Скорость: 3 клетки за ход
 * - Пища для насыщения: 10 кг
 */
public class GoatClass extends Herbivore {
    
    public GoatClass() {
        super(60, 140, 3, 10);
    }
    
    @Override
    public void eat() {
        // Козы едят только растения (100% вероятность)
    }
    
    @Override
    public void move() {
        // Коза может перемещаться на 3 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения коз
    }
}