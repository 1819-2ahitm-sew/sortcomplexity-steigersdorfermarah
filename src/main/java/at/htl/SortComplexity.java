package at.htl;

import java.util.Scanner;

public class SortComplexity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anzahlArrays = 0;
        int groesseArrays = 0;
        long summe = 0;

        System.out.print("Anzahl der zu sortierenden Arrays:");
        anzahlArrays = scanner.nextInt();
        System.out.print("Größe der Arrays: ");
        groesseArrays = scanner.nextInt();
        System.out.println("");

        for (int i = 0; i < anzahlArrays; i++) {
            long time = sortRandomArray(groesseArrays);
            System.out.println("Laufzeit zur Sortierung des " + (i+1) + ". Arrays: " + time + "ms");
            summe += time;
        }

        long averageTime = summe/anzahlArrays;

        System.out.println("\nDurchschnittliche Laufzeit: " + averageTime + "ms");

    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {

        int[] array = generateRandomArray(length);
        long timeBeforeSort = System.currentTimeMillis();
        sort(array);
        long timeAfterSort = System.currentTimeMillis();
        long diff = timeAfterSort - timeBeforeSort;

        return diff;
    }


    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {

        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }

        return array;
    }




    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                swap(array, i, j);
            }
        }

    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {

        if (array[i] < array[j]){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }
}
