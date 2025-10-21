package AnimalClass;

public abstract class Animal {
    private int weight; // вес животного
    private int maxCountPerCell; // максимальное количество животных в одной клетке
    private int speed; // максимальное количество клеток, которое может пройти животное
    private int maxFoodWeight; // максимальное количество съедаемой еды

    public abstract void eat();
    public abstract void move();
    public abstract void birth();

}
