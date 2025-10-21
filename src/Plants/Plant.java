package Plants;

/**
 * Класс Растение
 * Растения являются основой пищевой цепи на острове
 */
public class Plant {
    private int weight; // вес растения в кг
    private int maxCountPerCell; // максимальное количество растений на одной клетке
    private boolean isAlive; // живое ли растение
    
    public Plant() {
        this.weight = 1; // 1 кг
        this.maxCountPerCell = 200; // максимум 200 растений на клетке
        this.isAlive = true;
    }
    
    public Plant(int weight, int maxCountPerCell) {
        this.weight = weight;
        this.maxCountPerCell = maxCountPerCell;
        this.isAlive = true;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getMaxCountPerCell() {
        return maxCountPerCell;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public void die() {
        isAlive = false;
    }
    
    /**
     * Растения могут быть съедены животными
     */
    public boolean canBeEaten() {
        return isAlive;
    }
}
