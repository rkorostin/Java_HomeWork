package HomeWork.hw_05;

import java.util.Stack;

public class WaveAlgorithm {

    // Двумерный массив, представляющий лабиринт
    private int[][] maze;

    // Конструктор
    public WaveAlgorithm(int[][] maze) {
        this.maze = maze;
    }

    // Короткий путь из лабиринта с помощью алгоритма волны
    public void findShortestPath() {
        // Создаем двумерный массив, который будет содержать информацию о расстоянии от
        // стартовой точки до каждой точки лабиринта
        int[][] distance = new int[maze.length][maze[0].length];

        // Инициализируем массив расстояний, устанавливая значение -1 для каждой ячейки
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                distance[i][j] = -1;
            }
        }

        // Создаем стек, который будет служить для хранения точек, которые нужно
        // проверять.
        Stack<Point> stack = new Stack<Point>();

        // Добавляем стартовую точку в стек.
        stack.push(new Point(0, 0));

        // Устанавливаем расстояние для стартовой ячейки 0.
        distance[0][0] = 0;

        // Пока стек не пуст:
        while (!stack.isEmpty()) {
            // Извлекаем точку из стека.
            Point p = stack.pop();

            // Проверяем, не достигли ли мы выхода.
            if (p.x == maze.length - 1 && p.y == maze[0].length - 1) {
                break;
            }

            // Проверяем, нет ли соседних ячеек, которые мы можем посетить.
            if (p.x + 1 < maze.length && maze[p.x + 1][p.y] == 0 && distance[p.x + 1][p.y] == -1) {
                // Добавляем ячейку в стек.
                stack.push(new Point(p.x + 1, p.y));
                // Устанавливаем расстояние.
                distance[p.x + 1][p.y] = distance[p.x][p.y] + 1;
            }
            if (p.y + 1 < maze[0].length && maze[p.x][p.y + 1] == 0 && distance[p.x][p.y + 1] == -1) {
                stack.push(new Point(p.x, p.y + 1));
                distance[p.x][p.y + 1] = distance[p.x][p.y] + 1;
            }
            if (p.x - 1 >= 0 && maze[p.x - 1][p.y] == 0 && distance[p.x - 1][p.y] == -1) {
                stack.push(new Point(p.x - 1, p.y));
                distance[p.x - 1][p.y] = distance[p.x][p.y] + 1;
            }
            if (p.y - 1 >= 0 && maze[p.x][p.y - 1] == 0 && distance[p.x][p.y - 1] == -1) {
                stack.push(new Point(p.x, p.y - 1));
                distance[p.x][p.y - 1] = distance[p.x][p.y] + 1;
            }
        }

        printMazz(distance);

        // Выводим короткий путь, начиная c (0,0).
        int i = maze.length - 1;
        int j = maze[0].length - 1;
        int endX = maze.length - 1;
        int endY = maze[0].length - 1;

        System.out.println("Кратчайший путь из " + distance[endX][endY] + " шагов: ");

        while (i != 0 || j != 0) {

            int tempDist = distance[i][j];

            if (j > 0 && tempDist == distance[i][j - 1] + 1) {
                System.out.printf("%2d Налево\n", distance[i][j]);

                j--;

            } else if (i > 0 && tempDist == distance[i - 1][j] + 1) {

                System.out.printf("%2d Ввехр\n", distance[i][j]);

                i--;

            } else if (j < maze[0].length - 1 && tempDist == distance[i][j + 1] + 1) {

                System.out.printf("%2d Направо\n", distance[i][j]);

                j++;

            } else if (i < maze.length - 1 && tempDist == distance[i + 1][j] + 1) {

                System.out.printf("%2d Вниз\n", distance[i][j]);

                i++;

            }

        }

        

    }

    class Point {

        int x, y;

        public Point(int x, int y) {

            this.x = x;

            this.y = y;

        }

    }

    public static void printMazz(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.printf("%4d ", maze[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        int maze[][] = {{ 0, 0, 1, 0, 0, 1, 0 },

                        { 0, 0, 0, 0, 0, 1, 0 },

                        { 1, 0, 0, 1, 0, 1, 0 },

                        { 0, 0, 1, 0, 0, 0, 0 },

                        { 1, 1, 1, 1, 1, 1, 0 },

                        { 0, 0, 0, 0, 0, 1, 0 },

                        { 1, 1, 1, 1, 0, 0, 0 },

                        { 0, 0, 0, 1, 1, 1, 1 },

                        { 1, 0, 0, 0, 0, 0, 0 } };


        WaveAlgorithm WaveAlgorithmNew = new WaveAlgorithm(maze);

        WaveAlgorithmNew.findShortestPath();

        


    }
}