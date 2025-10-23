import Island.IslandClass;
import Island.SimulationParameters;
/**
 * Главный класс для запуска симуляции острова
 * Согласно требованиям JavaRush
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== СИМУЛЯЦИЯ ЭКОСИСТЕМЫ ОСТРОВА ===");
        System.out.println("Проект JavaRush - Модуль 2");
        System.out.println();
        
        try {
            // Создание острова
            IslandClass island = new IslandClass(
                SimulationParameters.ISLAND_WIDTH, 
                SimulationParameters.ISLAND_HEIGHT
            );
            
            // Запуск симуляции
            island.startSimulation();
            
        } catch (Exception e) {
            System.err.println("Ошибка при запуске симуляции: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\nПрограмма завершена.");
    }
}
