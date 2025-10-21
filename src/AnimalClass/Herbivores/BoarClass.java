package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Кабан - травоядное
 * Характеристики согласно заданию:
 * - Вес: 400 кг
 * - Максимум на клетке: 50
 * - Скорость: 2 клетки за ход
 * - Пища для насыщения: 50 кг
 */
public class BoarClass extends Herbivore {
    
    public BoarClass() {
        super(400, 50, 2, 50);
    }
    
    @Override
    public void eat() {
        // Кабаны едят растения (100%) и мышей (50%), гусениц (90%)
    }
    
    @Override
    public void move() {
        // Кабан может перемещаться на 2 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения кабанов
    }
}
