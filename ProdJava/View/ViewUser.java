
package View;
import Controllers.Controller;
import Model.Toy;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewUser {
    private Controller controller;

    // Список разыгранных игрушек
    private ArrayList<Toy> presentToy = new ArrayList<>();

    public ViewUser(Controller controller) {
        this.controller = controller;
    }

    public int userMenu() {
        System.out.println("\nВведите номер команды:\n");
        System.out.println("1 - добавить игрушку в список разыгрываемых игрушек");
        System.out.println("2 - вывести список всех разыгрываемых игрушек");
        System.out.println("3 - изменить вес (частоту выпадения) игрушки");
        System.out.println("4 - провести розыгрыш одной игрушки");
        System.out.println("5 - провести серию розыгрышей");
        System.out.println("6 - вывести список всех разыгранных и не выданных игрушек");
        System.out.println("7 - выдать призовую игрушку");
        System.out.println("8 - вывести список всех выданных игрушек");
        System.out.println("9 - выход");
        try {
            int choise = Integer.parseInt(prompt("Ваш выбор: "));
            return choise;
        } catch (Exception e) {
            System.out.println("Введено некорректное значение! Программа прекращает свою работу!");
        }
        return 9;
    }

    public void run() {
        while (true) {
            int command = userMenu();

            if (command <= 0 || command > 9) {
                System.out.println("Такой команды нет! Попробуйте еще раз!");
            }

            if (command == 1) { // Добавить игрушку в список разыгрываемых игрушек
                System.out.println("\nДобавляем новую игрушку:");
                String name = prompt("Название: ");
                int count;
                try {
                    count = Integer.parseInt(prompt("Количество: "));
                } catch (Exception e) {
                    System.out.println("Введено некорректное значение!");
                    break;
                }
                int drop;
                try {
                    drop = Integer.parseInt(prompt("Частота выпадения (вес в % от 0 до 100): "));
                } catch (Exception e) {
                    System.out.println("Введено некорректное значение!");
                    break;
                }
                if (drop < 0 || drop > 100) {
                    System.out.println("Частота выпадения должна быть в диапазоне от 0 до 100%!");
                    break;
                }
                controller.saveToy(new Toy(name, count, drop));
                System.out.println("Игрушка добавлена!");
            }

            if (command == 2) { // Вывести список всех разыгрываемых игрушек
                ArrayList<Toy> toys = controller.readToyList();
                if (toys.size() > 0) {
                    System.out.println("\nНа данный момент для розыгрыша доступны следующие игрушки:\n");
                    toys.forEach(i -> System.out.println(i));
                } else {
                    System.out.println("Файл с розыгрываемыми игрушками пустой!");
                }
            }

            if (command == 3) { // Изменить вес (частоту выпадения) игрушки
                int idToy;
                try {
                    idToy = Integer.parseInt(prompt("\nВведите id игрушки: "));
                } catch (Exception e) {
                    System.out.println("Введено некорректное значение!");
                    break;
                }
                int dropToy;
                try {
                    dropToy = Integer.parseInt(prompt("Введите новый вес игрушки (в % от 100): "));
                } catch (Exception e) {
                    System.out.println("Введено некорректное значение!");
                    break;
                }
                boolean flag = controller.changeToyDrop(idToy, dropToy);
                if (!flag) {
                    System.out.println("Нет игрушки с таким id!");
                } else {
                    System.out.println("Вес (частота выпадения) игрушки обновлена!");
                }
            }

            if (command == 4) { // Провести розыгрыш одной игрушки
                Toy lot = controller.lotToy();
                presentToy.add(lot);
                System.out.println("\nРозыгрыш проведен! Разыграна игрушка:");
                System.out.println("id=" + lot.getId() + ", name='" + lot.getName() + "'");
            }

            if (command == 5) { // Провести серию розыгрышей
                int countDraw;
                try {
                    countDraw = Integer.parseInt(prompt("\nВведите количество розыгрышей: "));
                } catch (Exception e) {
                    System.out.println("Введено некорректное значение!");
                    break;
                }
                System.out.println("\nСерия из " + countDraw + " розыгрышей проведена! Разыграны игрушки:");
                for (int i = 1; i <= countDraw; i++) {
                    Toy lot = controller.lotToy();
                    presentToy.add(lot);
                    System.out.println(i + ". '" + lot.getName() + "'");
                }
            }

            if (command == 6) { // Вывести список всех разыгранных и не выданных игрушек
                if (presentToy.size() == 0) {
                    System.out.println("\nПока еще ни одна игрушка не участвовала в розыгрыше!");
                } else {
                    System.out.println("\nРазыгранные и не выданные игрушки:");
                    for (int i = 0; i < presentToy.size(); i++) {
                        System.out.println(i + 1 + ". '" + presentToy.get(i).getName() + "'");
                    }
                }
            }

            if (command == 7) { // Выдать призовую игрушку
                if (presentToy.size() == 0) {
                    System.out.println("\nСписок разыгранных и не выданных игрушек пуст!");
                } else {
                    System.out.println("\nВыдана призовая игрушка:");
                    System.out.println(presentToy.get(0).getName());
                    controller.giveAwayToy(presentToy.get(0));
                    presentToy.remove(0);
                }
            }

            if (command == 8) { // Вывести список всех выданных игрушек
                ArrayList<String> toys = controller.readPresentToyList();
                if (toys.size() > 0) {
                    System.out.println("\nБыли выданы следующие игрушки:");
                    toys.forEach(i -> System.out.println(i));
                } else {
                    System.out.println("\nФайл с выданными игрушками пустой!");
                }
            }

            if (command == 9) {
                System.out.println("\nДо следующего розыгрыша!\n");
                controller.clearPresentFile();
                return;
            }
        }
    }

    private String prompt(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.print(message);
        return scan.nextLine();
    }
}