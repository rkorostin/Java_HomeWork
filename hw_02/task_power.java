import java.util.Scanner;

public class task_power {
    public static void main(String[] args) {
        System.out.println(power(5, 4));
    }

    public static double power(double value, double powValue) {
        double result = 1;
        for (double i = 1; i <= powValue; i++) {
            result *= value;
        }
        return result;
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
