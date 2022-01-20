//Поворот матрицы

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static int[][] ROTATEDCOLORS = new int[SIZE][SIZE];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int angleOfRotation;
        boolean end = true;

        // генерируем первичную матрицу
        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        // печать первичной матрицы
        printField(colors, SIZE);

        while (end) {
            System.out.println("Выбери номер пункта от 1 до 4:");
            System.out.println("1. Повернуть матрицу на 90 градусов вправо");
            System.out.println("2. Повернуть матрицу на 180 градусов");
            System.out.println("3. Повернуть матрицу на 270 градусов вправо");
            System.out.println("4. Осановить программу");
            angleOfRotation = scanner.nextInt();
            switch (angleOfRotation) {
                case 1:
                    rotated_90(colors, SIZE);
                    continue;
                case 2:
                    rotated_180(colors, SIZE);
                    continue;
                case 3:
                    rotated_270(colors, SIZE);
                    continue;
                case 4:
                    System.out.println("Пока");
                    end = false;
                default:
            }
        }
    }


    // МЕТОДЫ
    // печать матрицы
    public static void printField(int[][] colors, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // поворот на 90 градусов
    public static void rotated_90(int[][] colors, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ROTATEDCOLORS[i][j] = colors[size - j - 1][i];
            }
        }
        printField(ROTATEDCOLORS, size);
    }

    // поворот на 180 градусов
    public static void rotated_180(int[][] colors, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ROTATEDCOLORS[i][j] = colors[size - i - 1][size - j - 1];
            }
        }
        printField(ROTATEDCOLORS, size);
    }

    // поворот на 270 градусов
    public static void rotated_270(int[][] colors, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ROTATEDCOLORS[i][j] = colors[j][size - i - 1];
            }
        }
        printField(ROTATEDCOLORS, size);
    }
}
