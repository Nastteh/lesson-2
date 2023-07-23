package Model;
import java.io.*;
import java.util.ArrayList;

public class FileOperationImpl implements FileOperation {
    // Получение из файла списка всех игрушек
    @Override
    public ArrayList<String> readAllToys(String fileName) {
        ArrayList<String> toyLines = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            if (line != null && line.equals("") == false) {
                toyLines.add(line);
            }
            while (line != null) {
                line = bufferedReader.readLine();
                if (line != null && line.equals("") == false) {
                    toyLines.add(line);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл с разыгрываемыми игрушками " + fileName + " отсутствует!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toyLines;
    }

    // Запись в файл списка всех игрушек
    @Override
    public void saveAllToys(String fileName, ArrayList<String> toys) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (String line : toys) {
                fileWriter.write(line);
                fileWriter.append('\n');
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Добавление выданной игрушки в файл выданных игрушек
    @Override
    public void savePresentToy(String fileName, String presentToy) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(presentToy);
            fileWriter.append('\n');
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Очистка файла выданных игрушек после окончания работы программы
    @Override
    public void clearPresentToysFile(String fileName) {
        File file = new File(fileName);
        if (file.isFile()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("");
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Получение списка всех выданных игрушек
    @Override
    public ArrayList<String> readAllPresentToys(String fileName) {
        ArrayList<String> toyLines = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            if (line != null && line.equals("") == false) {
                toyLines.add(line);
            }
            while (line != null) {
                line = bufferedReader.readLine();
                if (line != null && line.equals("") == false) {
                    toyLines.add(line);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл с выданными игрушками " + fileName + " отсутствует!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toyLines;
    }
}