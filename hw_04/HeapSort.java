import java.util.stream.IntStream;

public class HeapSort {
    public static void main(String args[]) {
        int[] arr = fillArray(10, 100);
        System.out.println("Изначальный массив: ");
        printArray(arr); // 11 60 20 -72 -79 18 -81 43 54 -96

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Отсортированный массив: ");
        printArray(arr); // -96 -81 -79 -72 11 18 20 43 54 60
    }

    public static int[] fillArray(int size, int range) {
        int[] array = new int[size];
        IntStream.range(0, size)
                .forEach(index -> array[index] = (int) (Math.random() * 2 * range) - range);
        return array;
    }

    public void sort(int arr[]) {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
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
    void heapify(int arr[], int n, int i) {
        int maxElement = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[maxElement])
            maxElement = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный
        // момент
        if (r < n && arr[r] > arr[maxElement])
            maxElement = r;
        // Если самый большой элемент не корень
        if (maxElement != i) {
            int swap = arr[i];
            arr[i] = arr[maxElement];
            arr[maxElement] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, maxElement);
        }
    }

    // вывод на экран массива
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}