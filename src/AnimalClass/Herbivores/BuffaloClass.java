package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Буйвол - травоядное
 * Характеристики согласно заданию:
 * - Вес: 700 кг
 * - Максимум на клетке: 10
 * - Скорость: 3 клетки за ход
 * - Пища для насыщения: 100 кг
 */
public class BuffaloClass extends Herbivore {
    
    public BuffaloClass() {
        super(700, 10, 3, 100);
    }
    
    @Override
    public void eat() {
        // Буйволы едят только растения (100% вероятность)
    }
    
    @Override
    public void move() {
        // Буйвол может перемещаться на 3 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения буйволов
    }
}
