package Model;
import java.util.ArrayList;

public interface FileOperation {
    // Получение из файла списка всех игрушек
    ArrayList<String> readAllToys(String fileName);

    // Запись в файл списка всех игрушек
    void saveAllToys(String fileName, ArrayList<String> toys);

    // Запись в файл выданной игрушки
    void savePresentToy(String fileName, String presentToy);

    // Очистка файла выданных игрушек после окончания работы программы
    void clearPresentToysFile(String filename);

    // Получение списка всех выданных игрушек
    ArrayList<String> readAllPresentToys(String fileName);
}