import java.util.Scanner;

public class transform_number {
    public static void main(String[] args) {
        int a = 2;
        int b = getNumberByUser("Введите число b: ");

        int t = transformNumAinB(a, b);
        System.out.printf("Количество вариантов перехода числа %d в число %d -> %d", a, b, t);
    }

    // transformNumAinB - кол-во вариантов преобразования числа а в число b.
    // Через рекурсию
    public static int transformNumAinB(int a, int b) {
        if (a == b) {
            return 1;
        }
        if (a > b) {
            return 0;
        }
        return transformNumAinB(a + 1, b) + transformNumAinB(a * 2, b);
    }

    public static int getNumberByUser(String text) {
        int i;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(text);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                if (i <= 0) {
                    System.out.println("Работаем только с положительными числами");
                } else {
                    break;
                }
            } else {
                System.out.println("Вы ввели не целое число");
            }
        }
        return i;
    }
}
