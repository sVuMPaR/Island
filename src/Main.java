import Island.IslandClass;
import Island.SimulationParameters;


void main() {
    IO.println("=== СИМУЛЯЦИЯ ЭКОСИСТЕМЫ ОСТРОВА ===");
    IO.println("Проект JavaRush - Модуль 2");
    IO.println();

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

    IO.println("\nПрограмма завершена.");
}
