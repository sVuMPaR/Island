package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Корова - травоядное
 * Характеристики согласно заданию:
 * - Вес: 350 кг
 * - Максимум на клетке: 10
 * - Скорость: 2 клетки за ход
 * - Пища для насыщения: 53 кг
 */
public class CowClass extends Herbivore {
    
    public CowClass() {
        super(350, 10, 2, 53);
    }
    
    @Override
    public void eat() {
        // Коровы едят только растения (100% вероятность)
    }
    
    @Override
    public void move() {
        // Корова может перемещаться на 2 клетки за ход
    }
    
    @Override
    public void reproduce() {
        // Логика размножения коров
    }
}
