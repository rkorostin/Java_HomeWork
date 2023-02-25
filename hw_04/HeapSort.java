import java.util.Arrays;
import java.util.stream.IntStream;

// Реализация пирамидальной сортировки на Java
public class HeapSort {
    // Управляющая программа
    public static void main(String args[]) {
        int[] arr = fillArray(10, 100);
        System.out.println("Изначальный массив: ");
        printArray(arr);

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Отсортированный массив: ");
        printArray(arr);
    }

    public static int[] fillArray(int size, int range) {
        int[] array = new int[size];
        IntStream.range(0, size)
                .forEach(index -> array[index] = (int) (Math.random() * 2 * range) - range);
        return array;
    }

    public void sort(int arr[]) {
        // Построение кучи
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = arr.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Преобразование в двоичную кучу поддерева с корневым узлом i,
    // что является индексом в arr[]. n - размер кучи
    void heapify(int arr[], int length, int i) {
        
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < arr.length && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < arr.length && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, arr.length, largest);
        }
    }

    // вывод на экран массива
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}