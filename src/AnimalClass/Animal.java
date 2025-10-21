package AnimalClass;

import java.util.Random;

/**
 * Абстрактный базовый класс для всех животных на острове
 */
public abstract class Animal {
    // Основные характеристики животного
    protected int weight; // вес животного в кг
    protected int maxCountPerCell; // максимальное количество животных этого вида на одной клетке
    protected int speed; // максимальное количество клеток, которое может пройти животное за ход
    protected int maxFoodWeight; // количество килограммов пищи для полного насыщения
    
    // Состояние животного
    protected int currentFoodWeight; // текущий уровень насыщения
    protected int age; // возраст животного
    protected boolean isAlive; // жив ли животное
    protected boolean isMale; // пол животного (true - самец, false - самка)
    
    // Позиция на острове
    protected int x; // координата X
    protected int y; // координата Y
    
    protected Random random = new Random();
    
    public Animal(int weight, int maxCountPerCell, int speed, int maxFoodWeight) {
        this.weight = weight;
        this.maxCountPerCell = maxCountPerCell;
        this.speed = speed;
        this.maxFoodWeight = maxFoodWeight;
        this.currentFoodWeight = maxFoodWeight; // животное рождается сытым
        this.age = 0;
        this.isAlive = true;
        this.isMale = random.nextBoolean(); // случайный пол
    }
    
    // Абстрактные методы, которые должны реализовать наследники
    public abstract void eat();
    public abstract void move();
    public abstract void reproduce();
    
    // Общие методы для всех животных
    public void age() {
        if (isAlive) {
            age++;
            currentFoodWeight--; // животное теряет энергию с возрастом
            
            // Проверка на смерть от голода
            if (currentFoodWeight <= 0) {
                die();
            }
        }
    }
    
    public void die() {
        isAlive = false;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public boolean isMale() {
        return isMale;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getMaxCountPerCell() {
        return maxCountPerCell;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public int getCurrentFoodWeight() {
        return currentFoodWeight;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getAge() {
        return age;
    }
    
    /**
     * Проверяет, может ли животное размножаться
     */
    public boolean canReproduce() {
        return isAlive && currentFoodWeight >= maxFoodWeight / 2 && age >= 2;
    }
    
    /**
     * Проверяет совместимость для размножения
     */
    public boolean isCompatibleForReproduction(Animal other) {
        return this.getClass().equals(other.getClass()) && 
               this.isMale != other.isMale && 
               this.canReproduce() && 
               other.canReproduce();
    }
}
