package HomeWork.hw_05;

import java.util.Random;
import java.util.Scanner;

public class PrintMap {
    public static void main(String[] args) {
        System.out.println("Задайте размеры поля");
        int col = getNumberByUser("Введите длину: ") + 2;
        int row = getNumberByUser("Введите ширину: ") + 2;

        int[][] battlefield = new int[row][col];
        fillingBatt(battlefield, col, row);
        printBatt(battlefield, col, row);

        System.out.println("Добавить препятствие (y/n)?: ");

        Scanner terminal = new Scanner(System.in);
        switch(terminal.next()) {
            case "y":
                System.out.println();
                addBattWall(battlefield, col, row);
                printBatt(battlefield, col, row);
                break;
            case "n":
                printBatt(battlefield, col, row);
                break;
            default:
                System.out.println("Начни заново");
        }
    }

    public static void fillingBatt(int[][] array, int col, int row) {
        System.out.println("\n     Поле " + (col - 2) + " на " + (row - 2) + "\n");

        int minRow = 0, maxRow = row - 1, minCol = 0, maxCol = col - 1;
        int count = 0;
        int max = (row - 2) * (col - 2);

        for (int i = minCol; i <= maxCol; i++) {
            array[minRow][i] = -1;
        }
        minRow = minRow + 1;
        for (int i = minRow; i <= maxRow; i++) {
            array[i][maxCol] = -1;
        }
        maxCol = maxCol - 1;
        for (int i = maxCol; i >= minCol; i--) {
            array[maxRow][i] = -1;
        }
        maxRow = maxRow - 1;
        for (int i = maxRow; i >= minRow; i--) {
            array[i][minCol] = -1;
        }
        minCol = minCol + 1;

        while (count < max) {
            for (int i = minCol; i <= maxCol; i++) {
                array[minRow][i] = 0;
                count++;
            }
            minRow = minRow + 1;
            for (int i = minRow; i <= maxRow; i++) {
                array[i][maxCol] = 0;
                count++;
            }
            maxCol = maxCol - 1;
            for (int i = maxCol; i >= minCol; i--) {
                array[maxRow][i] = 0;
                count++;
            }
            maxRow = maxRow - 1;
            for (int i = maxRow; i >= minRow; i--) {
                array[i][minCol] = 0;
                count++;
            }
            minCol = minCol + 1;
        }
    }

    public static void printBatt(int[][] array, int col, int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%4d ", array[i][j]);
            }
            System.out.println("");
        }
    }

    public static void addBattWall(int[][] array, int col, int row) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int randCol = r.nextInt(col);
            int randRow = r.nextInt(row);
            array[randCol][randRow] = -1;
        }
    }

    public static int getNumberByUser(String text) {
        int i;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(text);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                if (i > 2) {
                    break;
                } else {
                    System.out.println("Нужно число больше 2");
                }
            } else {
                System.out.println("Вы ввели не целое число");
            }
        }
        return i;
    }
}
