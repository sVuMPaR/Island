package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Мышь - травоядное
 * Характеристики согласно заданию:
 * - Вес: 0.05 кг
 * - Максимум на клетке: 500
 * - Скорость: 1 клетка за ход
 * - Пища для насыщения: 0.01 кг
 */
public class MouseClass extends Herbivore {
    
    public MouseClass() {
        super(1, 500, 1, 1); // Вес в граммах для удобства
    }
    
    @Override
    public void eat() {
        // Мыши едят растения (100%) и гусениц (90%)
    }
    
    @Override
    public void move() {
        // Мышь может перемещаться на 1 клетку за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения мышей
    }
}
