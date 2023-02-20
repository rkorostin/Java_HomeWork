import java.util.Arrays;
import java.util.stream.IntStream;

public class SortMerge {
    public static void main(String[] args) {
        int[] array = fillArray(10, 20);
        System.out.print("Первоначальный массив: " + Arrays.toString(array) + "\n");
        // Первоначальный массив: [-9, 7, 1, 6, -2, 6, -5, -1, -1, 16]

        int[] result = mergeSort(array);
        System.out.println("Сортированный массив:  " + Arrays.toString(result));
        // Сортированный массив: [-15, -15, -15, -14, -14, -12, -3, 7, 14, 16]
    }

    public static int[] fillArray(int size, int range) {
        int[] array = new int[size];
        IntStream.range(0, size)
                .forEach(index -> array[index] = (int) (Math.random() * 2 * range) - range);
        return array;
    }

    public static int[] mergeSort(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        int[] filledArray = new int[array.length];
        int[] result = mergeSortInternal(copyArray, filledArray, 0, array.length);
        return result;
    }

    public static int[] mergeSortInternal(int[] copyArray, int[] filledArray, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return copyArray;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInternal(copyArray, filledArray, startIndex, middle);
        int[] sorted2 = mergeSortInternal(copyArray, filledArray, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == copyArray ? filledArray : copyArray;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
