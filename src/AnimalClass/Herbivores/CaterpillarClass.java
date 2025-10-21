package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Гусеница - травоядное
 * Характеристики согласно заданию:
 * - Вес: 0.01 кг
 * - Максимум на клетке: 1000
 * - Скорость: 0 клеток за ход (не перемещается)
 * - Пища для насыщения: 0 кг
 */
public class CaterpillarClass extends Herbivore {
    
    public CaterpillarClass() {
        super(1, 1000, 0, 1); // Вес в граммах для удобства
    }
    
    @Override
    public void eat() {
        // Гусеницы едят только растения (100% вероятность)
    }
    
    @Override
    public void move() {
        // Гусеницы не перемещаются (скорость = 0)
    }
    
    @Override
    public void reproduce() {
        // Логика размножения гусениц
    }
}