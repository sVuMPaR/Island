package AnimalClass.Herbivores;

import AnimalClass.Herbivore;

/**
 * Класс Кенгуру - травоядное
 * Характеристики согласно заданию:
 * - Вес: 70 кг
 * - Максимум на клетке: 2
 * - Скорость: 2 клетки за ход
 * - Пища для насыщения: 15 кг
 */
public class KangarooClass extends Herbivore {

    public KangarooClass() {
        super(70, 2, 2, 15);
    }

    @Override
    public void eat() {
        // Кенгуру едят только растения (100% вероятность)
    }

    @Override
    public void move() {
        // Кенгуру может перемещаться на 2 клетки за ход
    }

    @Override
    public void reproduce() {
        // Логика размножения кенгуру
    }
}
