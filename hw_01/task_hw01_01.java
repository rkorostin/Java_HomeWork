
// Написать программу вычисления n-ого треугольного числа.
// https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%BE%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE
import java.util.Scanner;

public class task_hw01_01 {

    public static void main(String[] args) {

        int n = getNumberByUser("Введите число n: ");
        int t = triangularNumberFind(n);
        System.out.printf("Последовательность треугольного числа %d -> %d", n, t);

    }

    public static int triangularNumberFind(int num) {
        int t = num * (num + 1) / 2;
        return t;
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
}