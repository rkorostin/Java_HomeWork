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
}
