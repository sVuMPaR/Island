package Island;
/**
 * Класс для управления параметрами симуляции острова
 * Согласно требованиям JavaRush
 */
public class SimulationParameters {
    
    // Размер острова
    public static final int ISLAND_WIDTH = 20;
    public static final int ISLAND_HEIGHT = 10;
    
    // Длительность симуляции
    public static final int SIMULATION_DURATION_SECONDS = 60;
    public static final int TICK_DURATION_MS = 1000; // 1 секунда на такт
    
    // Количество животных каждого вида на старте
    public static final int INITIAL_WOLF_COUNT = 30;
    public static final int INITIAL_SNAKE_COUNT = 30;
    public static final int INITIAL_FOX_COUNT = 30;
    public static final int INITIAL_BEAR_COUNT = 5;
    public static final int INITIAL_EAGLE_COUNT = 20;
    public static final int INITIAL_HORSE_COUNT = 20;
    public static final int INITIAL_DEER_COUNT = 20;
    public static final int INITIAL_RABBIT_COUNT = 150;
    public static final int INITIAL_MOUSE_COUNT = 500;
    public static final int INITIAL_GOAT_COUNT = 140;
    public static final int INITIAL_SHEEP_COUNT = 140;
    public static final int INITIAL_BOAR_COUNT = 50;
    public static final int INITIAL_BUFFALO_COUNT = 10;
    public static final int INITIAL_DUCK_COUNT = 200;
    public static final int INITIAL_KANGAROO_COUNT = 5;
    
    // Количество растений на старте
    public static final int INITIAL_PLANT_COUNT_PER_CELL = 200;
    
    // Вероятности действий (в процентах)
    public static final int MOVE_PROBABILITY = 100; // 100% вероятность попытки движения
    public static final int REPRODUCTION_PROBABILITY = 50; // 50% вероятность размножения при наличии пары
    
    // Условия остановки симуляции
    public static final boolean STOP_WHEN_ALL_ANIMALS_DIE = true;
    
    // Количество детенышей при размножении
    public static final int WOLF_CUBS = 3;
    public static final int SNAKE_CUBS = 2;
    public static final int FOX_CUBS = 3;
    public static final int BEAR_CUBS = 2;
    public static final int EAGLE_CUBS = 2;
    public static final int HORSE_CUBS = 1;
    public static final int DEER_CUBS = 1;
    public static final int RABBIT_CUBS = 5;
    public static final int MOUSE_CUBS = 10;
    public static final int GOAT_CUBS = 2;
    public static final int SHEEP_CUBS = 2;
    public static final int BOAR_CUBS = 3;
    public static final int BUFFALO_CUBS = 1;
    public static final int DUCK_CUBS = 4;
    public static final int KANGAROO_CUBS = 1;
    
    /**
     * Получить количество детенышей для конкретного класса животного
     */
    public static int getCubsCount(Class<?> animalClass) {
        String className = animalClass.getSimpleName().toLowerCase();
        
        if (className.contains("wolf")) return WOLF_CUBS;
        if (className.contains("snake")) return SNAKE_CUBS;
        if (className.contains("fox")) return FOX_CUBS;
        if (className.contains("bear")) return BEAR_CUBS;
        if (className.contains("eagle")) return EAGLE_CUBS;
        if (className.contains("horse")) return HORSE_CUBS;
        if (className.contains("deer")) return DEER_CUBS;
        if (className.contains("rabbit")) return RABBIT_CUBS;
        if (className.contains("mouse")) return MOUSE_CUBS;
        if (className.contains("goat")) return GOAT_CUBS;
        if (className.contains("sheep")) return SHEEP_CUBS;
        if (className.contains("boar")) return BOAR_CUBS;
        if (className.contains("buffalo")) return BUFFALO_CUBS;
        if (className.contains("duck")) return DUCK_CUBS;
        if (className.contains("kangaroo")) return KANGAROO_CUBS;
        
        return 1; // По умолчанию
    }
}
