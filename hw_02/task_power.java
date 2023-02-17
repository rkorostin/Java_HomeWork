import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task_power {
    public static void main(String[] args) throws Exception {
        Integer a = getNumberByUser("Введите число а: ");
        Integer b = getNumberByUser("Введите число b: ");

        System.out.println("Число " + a + " в степени " + b + " -> " + power(a, b));

        String strA = a.toString(a);
        String strB = b.toString(b);

        try (FileWriter wfile = new FileWriter("input.txt", false)) {
            wfile.write("a " + strA);
            wfile.append('\n');
            wfile.write("b " + strB);
            wfile.flush();
            System.out.println("\nДанные записаны в файл input.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        FileReader rfile = new FileReader("input.txt");
        int c;
        while ((c = rfile.read()) != -1) {
            char ch = (char) c;
            if (ch == '\n') {
                System.out.print(ch);
            } else {
                System.out.print(ch);
            }
        }

        int newA = readFile()[0];
        int newB = readFile()[1];
        Double intResult = power(newA, newB);
        String strResult = intResult.toString(intResult);

        try (FileWriter wfile = new FileWriter("output.txt", false)) {
            wfile.write(strResult);
            wfile.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int[] readFile() throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        int[] intArr = new int[2];
        String line = scanner.nextLine();
        String[] strArr = line.split(" ");
        int a = Integer.parseInt(strArr[1]);
        intArr[0] = a;
        line = scanner.nextLine();
        strArr = line.split(" ");
        a = Integer.parseInt(strArr[1]);
        intArr[1] = a;
        scanner.close();
        return intArr;
    }

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

    public static void writeFile(String string) throws FileNotFoundException {
        try (FileWriter wfile = new FileWriter("output.txt", false)) {
            wfile.write("line 1");
            wfile.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static double power(int value, int powValue) {
        double result = 1;
        if (powValue > 0) {
            for (int i = 1; i <= powValue; i++) {
                result *= value;
            }
            return result;
        } 
        else if (powValue < 0) {
            for (int i = -1; i > powValue; i--) {
                result *= value;    
            }
            result = 1 / (result * value);
            return result;
        } 
        else {
            return value;
        }
    }
}
