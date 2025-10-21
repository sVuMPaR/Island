package AnimalClass;

/**
 * Матрица питания - определяет вероятность поедания одного животного другим
 * Согласно заданию JavaRush
 */
public class FeedingMatrix {
    
    // Матрица вероятностей поедания (в процентах)
    // [хищник][жертва] = вероятность поедания
    private static final int[][] FEEDING_PROBABILITIES = {
        // Индексы: 0-Волк, 1-Удав, 2-Лиса, 3-Медведь, 4-Орел, 5-Лошадь, 6-Олень, 7-Кролик, 8-Мышь, 9-Коза, 10-Овца, 11-Кабан, 12-Буйвол, 13-Утка, 14-Гусеница, 15-Растения
        // Волк
        {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
        // Удав  
        {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
        // Лиса
        {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
        // Медведь
        {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
        // Орел
        {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
        // Лошадь (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
        // Олень (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
        // Кролик (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
        // Мышь (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
        // Коза (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
        // Овца (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
        // Кабан (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},
        // Буйвол (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
        // Утка (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
        // Гусеница (травоядное)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
        // Растения (не едят никого)
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    
    // Названия животных для индексации
    public static final String[] ANIMAL_NAMES = {
        "Волк", "Удав", "Лиса", "Медведь", "Орел", 
        "Лошадь", "Олень", "Кролик", "Мышь", "Коза", 
        "Овца", "Кабан", "Буйвол", "Утка", "Гусеница", "Растения"
    };
    
    /**
     * Получить вероятность поедания жертвы хищником
     * @param predatorIndex индекс хищника в матрице
     * @param preyIndex индекс жертвы в матрице
     * @return вероятность поедания в процентах (0-100)
     */
    public static int getEatingProbability(int predatorIndex, int preyIndex) {
        if (predatorIndex < 0 || predatorIndex >= FEEDING_PROBABILITIES.length ||
            preyIndex < 0 || preyIndex >= FEEDING_PROBABILITIES[0].length) {
            return 0;
        }
        return FEEDING_PROBABILITIES[predatorIndex][preyIndex];
    }
    
    /**
     * Получить индекс животного по его классу
     */
    public static int getAnimalIndex(Class<? extends Animal> animalClass) {
        String className = animalClass.getSimpleName().toLowerCase();
        
        if (className.contains("wolf")) return 0;
        if (className.contains("snake") || className.contains("boa")) return 1;
        if (className.contains("fox")) return 2;
        if (className.contains("bear")) return 3;
        if (className.contains("eagle")) return 4;
        if (className.contains("horse")) return 5;
        if (className.contains("deer")) return 6;
        if (className.contains("rabbit")) return 7;
        if (className.contains("mouse")) return 8;
        if (className.contains("goat")) return 9;
        if (className.contains("sheep")) return 10;
        if (className.contains("boar")) return 11;
        if (className.contains("buffalo")) return 12;
        if (className.contains("duck")) return 13;
        if (className.contains("caterpillar")) return 14;
        
        return -1; // Неизвестное животное
    }
    
    /**
     * Получить индекс растения
     */
    public static int getPlantIndex() {
        return 15;
    }
    
    /**
     * Проверить, может ли хищник съесть жертву
     */
    public static boolean canEat(Class<? extends Animal> predatorClass, Class<? extends Animal> preyClass) {
        int predatorIndex = getAnimalIndex(predatorClass);
        int preyIndex = getAnimalIndex(preyClass);
        
        if (predatorIndex == -1 || preyIndex == -1) {
            return false;
        }
        
        return getEatingProbability(predatorIndex, preyIndex) > 0;
    }
    
    /**
     * Проверить, может ли животное съесть растение
     */
    public static boolean canEatPlant(Class<? extends Animal> animalClass) {
        int animalIndex = getAnimalIndex(animalClass);
        if (animalIndex == -1) return false;
        
        return getEatingProbability(animalIndex, getPlantIndex()) > 0;
    }
}
