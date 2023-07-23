package Model;
import java.util.ArrayList;

public interface ToyOperation {
    // Получение списка всех игрушек
    ArrayList<Toy> getAllToys(String fileName);

    // Добавление новой игрушки
    int addToy(Toy toy);

    // Изменение частоты выпадения игрушки (вес в % от 100)
    boolean changeDrop(int id, int drop);

    // Розыгрыш одной игрушки
    Toy lotOneToy();

    // Уменьшение количества игрушек после розыгрыша
    ArrayList<Toy> toysAfterDraw(ArrayList<Toy> toys, Toy lotToy);

    // Выдача призовой игрушки
    void giveToy(Toy toy);

    // Запись всех игрушек в файл
    void writeToys(String fileName, ArrayList<Toy> toys);

    // Запись выданной игрушки в файл
    void writePresentToy(String fileName, Toy toy);

    // Очистка файла выданных игрушек после окончания работы программы
    void clearFile();

    // Получение списка всех выданных игрушек
    ArrayList<String> getAllPresentToys(String fileName);
}