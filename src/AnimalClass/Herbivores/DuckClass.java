package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Утка - травоядное
 * Характеристики согласно заданию:
 * - Вес: 1 кг
 * - Максимум на клетке: 200
 * - Скорость: 4 клетки за ход
 * - Пища для насыщения: 0.15 кг
 */
public class DuckClass extends Herbivore {
    
    public DuckClass() {
        super(1, 200, 4, 1); // Вес в граммах для удобства
    }
    
    @Override
    public void eat() {
        // Утки едят растения (100%) и гусениц (90%)
    }
    
    @Override
    public void move() {
        // Утка может перемещаться на 4 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения уток
    }
}