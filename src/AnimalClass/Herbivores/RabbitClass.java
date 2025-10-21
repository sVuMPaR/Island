package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Кролик - травоядное
 * Характеристики согласно заданию:
 * - Вес: 2 кг
 * - Максимум на клетке: 150
 * - Скорость: 2 клетки за ход
 * - Пища для насыщения: 0.45 кг
 */
public class RabbitClass extends Herbivore {
    
    public RabbitClass() {
        super(2, 150, 2, 1); // Вес в граммах для удобства
    }
    
    @Override
    public void eat() {
        // Кролики едят только растения (100% вероятность)
    }
    
    @Override
    public void move() {
        // Кролик может перемещаться на 2 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения кроликов
    }
}
