package Island;

import AnimalClass.*;
import AnimalClass.Herbivores.KangarooClass;
import AnimalClass.Predators.*;
import Plants.Plant;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс острова - основная логика симуляции
 * Согласно требованиям JavaRush
 */
public class IslandClass {
    
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private final ExecutorService executorService;
    private final Random random = new Random();
    private volatile boolean isRunning = false;
    private int currentTick = 0;
    
    // Статистика
    private final Map<String, Integer> animalCounts = new ConcurrentHashMap<>();
    private int totalPlants = 0;
    
    public IslandClass(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        
        // Инициализация клеток
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new Cell(x, y);
            }
        }
        
        initializeIsland();
    }
    
    /**
     * Инициализация острова - размещение животных и растений
     */
    private void initializeIsland() {
        // Размещение растений
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = cells[y][x];
                for (int i = 0; i < SimulationParameters.INITIAL_PLANT_COUNT_PER_CELL; i++) {
                    cell.addPlant(new Plant());
                }
            }
        }
        
        // Размещение животных
        placeAnimals(WolfClass.class, SimulationParameters.INITIAL_WOLF_COUNT);
        placeAnimals(BearClass.class, SimulationParameters.INITIAL_BEAR_COUNT);
        placeAnimals(FoxClass.class, SimulationParameters.INITIAL_FOX_COUNT);
        placeAnimals(SnakeClass.class, SimulationParameters.INITIAL_SNAKE_COUNT);
        placeAnimals(EagleClass.class, SimulationParameters.INITIAL_EAGLE_COUNT);
        placeAnimals(HorseClass.class, SimulationParameters.INITIAL_HORSE_COUNT);
        placeAnimals(DeerClass.class, SimulationParameters.INITIAL_DEER_COUNT);
        placeAnimals(RabbitClass.class, SimulationParameters.INITIAL_RABBIT_COUNT);
        placeAnimals(MouseClass.class, SimulationParameters.INITIAL_MOUSE_COUNT);
        placeAnimals(GoatClass.class, SimulationParameters.INITIAL_GOAT_COUNT);
        placeAnimals(SheepClass.class, SimulationParameters.INITIAL_SHEEP_COUNT);
        placeAnimals(BoarClass.class, SimulationParameters.INITIAL_BOAR_COUNT);
        placeAnimals(BuffaloClass.class, SimulationParameters.INITIAL_BUFFALO_COUNT);
        placeAnimals(DuckClass.class, SimulationParameters.INITIAL_DUCK_COUNT);
        placeAnimals(KangarooClass.class, SimulationParameters.INITIAL_KANGAROO_COUNT);
        
        updateStatistics();
    }
    
    /**
     * Размещение животных случайным образом по острову
     */
    private void placeAnimals(Class<? extends Animal> animalClass, int count) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            
            try {
                Animal animal = animalClass.getDeclaredConstructor().newInstance();
                animal.setPosition(x, y);
                cells[y][x].addAnimal(animal);
            } catch (Exception e) {
                System.err.println("Ошибка создания животного " + animalClass.getSimpleName() + ": " + e.getMessage());
            }
        }
    }
    
    /**
     * Запуск симуляции
     */
    public void startSimulation() {
        isRunning = true;
        System.out.println("=== НАЧАЛО СИМУЛЯЦИИ ОСТРОВА ===");
        System.out.println("Размер острова: " + width + "x" + height);
        printStatistics();
        
        long startTime = System.currentTimeMillis();
        
        while (isRunning && (System.currentTimeMillis() - startTime) < SimulationParameters.SIMULATION_DURATION_SECONDS * 1000) {
            currentTick++;
            System.out.println("\n--- ТАКТ " + currentTick + " ---");
            
            try {
                // Выполнение одного такта симуляции
                executeTick();
                
                // Пауза между тактами
                Thread.sleep(SimulationParameters.TICK_DURATION_MS);
                
                // Проверка условий остановки
                if (SimulationParameters.STOP_WHEN_ALL_ANIMALS_DIE && getTotalAnimalCount() == 0) {
                    System.out.println("Все животные умерли. Симуляция завершена.");
                    break;
                }
                
            } catch (InterruptedException e) {
                System.out.println("Симуляция прервана.");
                break;
            }
        }
        
        stopSimulation();
    }
    
    /**
     * Выполнение одного такта симуляции
     */
    private void executeTick() {
        List<Future<?>> futures = new ArrayList<>();
        
        // Параллельное выполнение действий для всех животных
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                final int finalX = x;
                final int finalY = y;
                
                Future<?> future = executorService.submit(() -> {
                    Cell cell = cells[finalY][finalX];
                    processCell(cell);
                });
                futures.add(future);
            }
        }
        
        // Ожидание завершения всех задач
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                System.err.println("Ошибка выполнения задачи: " + e.getMessage());
            }
        }
        
        updateStatistics();
        printStatistics();
    }
    
    /**
     * Обработка одной клетки
     */
    private void processCell(Cell cell) {
        // Создаем копии списков для безопасной итерации
        List<Animal> animals = new ArrayList<>(cell.getAnimals());
        List<Plant> plants = new ArrayList<>(cell.getPlants());
        
        // Обработка животных
        for (Animal animal : animals) {
            if (!animal.isAlive()) {
                cell.removeAnimal(animal);
                continue;
            }
            
            // Старение
            animal.age();
            
            if (!animal.isAlive()) {
                cell.removeAnimal(animal);
                continue;
            }
            
            // Питание
            if (random.nextInt(100) < SimulationParameters.MOVE_PROBABILITY) {
                animal.eat();
            }
            
            // Движение
            if (random.nextInt(100) < SimulationParameters.MOVE_PROBABILITY) {
                moveAnimal(animal, cell);
            }
            
            // Размножение
            if (random.nextInt(100) < SimulationParameters.REPRODUCTION_PROBABILITY) {
                reproduceAnimal(animal, cell);
            }
        }
        
        // Размножение растений
        if (plants.size() < Plant.MAX_COUNT_PER_CELL && random.nextInt(100) < 50) {
            cell.addPlant(new Plant());
        }
    }
    
    /**
     * Перемещение животного
     */
    private void moveAnimal(Animal animal, Cell currentCell) {
        int currentX = animal.getX();
        int currentY = animal.getY();
        
        // Случайное направление движения
        int newX = currentX + random.nextInt(animal.getSpeed() * 2 + 1) - animal.getSpeed();
        int newY = currentY + random.nextInt(animal.getSpeed() * 2 + 1) - animal.getSpeed();
        
        // Проверка границ острова
        newX = Math.max(0, Math.min(width - 1, newX));
        newY = Math.max(0, Math.min(height - 1, newY));
        
        // Перемещение если координаты изменились
        if (newX != currentX || newY != currentY) {
            Cell newCell = cells[newY][newX];
            
            // Проверка лимита животных в новой клетке
            if (newCell.getAnimalCount() < animal.getMaxCountPerCell()) {
                currentCell.removeAnimal(animal);
                newCell.addAnimal(animal);
                animal.setPosition(newX, newY);
            }
        }
    }
    
    /**
     * Размножение животного
     */
    private void reproduceAnimal(Animal animal, Cell cell) {
        if (!animal.canReproduce()) return;
        
        // Поиск совместимого партнера
        for (Animal other : cell.getAnimals()) {
            if (animal.isCompatibleForReproduction(other)) {
                // Создание детенышей
                int cubsCount = SimulationParameters.getCubsCount(animal.getClass());
                
                for (int i = 0; i < cubsCount; i++) {
                    if (cell.getAnimalCount() < animal.getMaxCountPerCell()) {
                        try {
                            Animal cub = animal.getClass().getDeclaredConstructor().newInstance();
                            cub.setPosition(animal.getX(), animal.getY());
                            cell.addAnimal(cub);
                        } catch (Exception e) {
                            System.err.println("Ошибка создания детеныша: " + e.getMessage());
                        }
                    }
                }
                break; // Размножение только с одним партнером за такт
            }
        }
    }
    
    /**
     * Обновление статистики
     */
    private void updateStatistics() {
        animalCounts.clear();
        totalPlants = 0;
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = cells[y][x];
                
                // Подсчет животных
                for (Animal animal : cell.getAnimals()) {
                    String className = animal.getClass().getSimpleName();
                    animalCounts.put(className, animalCounts.getOrDefault(className, 0) + 1);
                }
                
                // Подсчет растений
                totalPlants += cell.getPlantCount();
            }
        }
    }
    
    /**
     * Печать статистики
     */
    private void printStatistics() {
        System.out.println("Статистика острова:");
        System.out.println("Растения: " + totalPlants);
        System.out.println("Животные:");
        
        for (Map.Entry<String, Integer> entry : animalCounts.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("Всего животных: " + getTotalAnimalCount());
    }
    
    /**
     * Получение общего количества животных
     */
    private int getTotalAnimalCount() {
        return animalCounts.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    /**
     * Остановка симуляции
     */
    public void stopSimulation() {
        isRunning = false;
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        
        System.out.println("\n=== СИМУЛЯЦИЯ ЗАВЕРШЕНА ===");
        System.out.println("Общее количество тактов: " + currentTick);
        printStatistics();
    }
    
    /**
     * Класс клетки острова
     */
    private static class Cell {
        private final int x, y;
        private final List<Animal> animals = new ArrayList<>();
        private final List<Plant> plants = new ArrayList<>();
        private final ReentrantLock lock = new ReentrantLock();
        
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public void addAnimal(Animal animal) {
            lock.lock();
            try {
                animals.add(animal);
            } finally {
                lock.unlock();
            }
        }
        
        public void removeAnimal(Animal animal) {
            lock.lock();
            try {
                animals.remove(animal);
            } finally {
                lock.unlock();
            }
        }
        
        public void addPlant(Plant plant) {
            lock.lock();
            try {
                plants.add(plant);
            } finally {
                lock.unlock();
            }
        }
        
        public List<Animal> getAnimals() {
            lock.lock();
            try {
                return new ArrayList<>(animals);
            } finally {
                lock.unlock();
            }
        }
        
        public List<Plant> getPlants() {
            lock.lock();
            try {
                return new ArrayList<>(plants);
            } finally {
                lock.unlock();
            }
        }
        
        public int getAnimalCount() {
            lock.lock();
            try {
                return animals.size();
            } finally {
                lock.unlock();
            }
        }
        
        public int getPlantCount() {
            lock.lock();
            try {
                return plants.size();
            } finally {
                lock.unlock();
            }
        }
    }
}
