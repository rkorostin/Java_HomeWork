import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task_power {
    public static void main(String[] args) throws Exception {
        Integer a = getNumberByUser("Введите число а: ");
        Integer b = getNumberByUser("Введите число b: ");
        System.out.println("Число " + a + " в степени " + b + " -> " + power(a, b));
        String pathInput = "input.txt";
        String pathOutput = "output.txt";
        String saveStr = String.format("a %d\nb %d", a, b);
        writeInFile(saveStr, pathInput);

        outputTerminal(pathInput);
        int[] argAB = readFile(pathInput); //  получаем массив с переменными а и b
        int newA = argAB[0];
        int newB = argAB[1];

        Double intResult = power(newA, newB);

        String strResult = intResult.toString(intResult);
        try (FileWriter wfile = new FileWriter("output.txt", false)) {
            wfile.write(strResult);
            wfile.flush();
            System.out.println("\nРезультат записан в файл output.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        outputTerminal(pathOutput);
    }
    public static void writeInFile(String data, String path) {
        try (FileWriter wfile = new FileWriter(path, false)) {
            wfile.write(data);
            wfile.flush();
            System.out.println("\nВходные данные записаны в файл input.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Чтение цифр из файла
    public static int[] readFile(String fileName) throws Exception {
        Scanner scanner = new Scanner(new File(fileName));
        int[] intArr = new int[2];
        int index = 0;

        // цикл работает пока следующая строка не пустая.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] strArr = line.split(" ");
            intArr[index] = Integer.parseInt(strArr[1]);
            index++;
        }
        scanner.close();
        return intArr;
    }

    // Получение данных от пользователя
    public static int getNumberByUser(String text) {
        int i;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(text);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                break;
            } else {
                System.out.println("Вы ввели не целое число");
            }
        }
        return i;
    }

    // Возведение в степень
    public static double power(int value, int powValue) {
        double result = 1;
        if (powValue > 0) {
            for (int i = 1; i <= powValue; i++) {
                result *= value;
            }
            return result;
        } else if (powValue < 0) {
            for (int i = -1; i > powValue; i--) {
                result *= value;
            }
            result = 1 / (result * value);
            return result;
        } else {
            return 1;
        }
    }

    public static void outputTerminal(String text) throws Exception {
        FileReader rfile = new FileReader(text);
        File f = new File(text);
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            String msg = scan.nextLine();
            System.out.println(msg);
        }
    }
}
