public class MatrixOperations {
    /**
     * Виконавчий метод, який демонструє роботу з матрицями.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            // Ініціалізація вхідних даних
            int[][] matrixB = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            int a = 2;

            // Виконання множення матриці на константу
            int[][] matrixC = multiplyMatrixByConstant(matrixB, a);

            // Виведення результату множення
            System.out.println("Результат множення матриці B на константу " + a + ":");
            printMatrix(matrixC);

            // Обчислення та виведення середнього значення
            double average = calculateMatrixAverage(matrixC);
            System.out.println("\nСереднє значення елементів матриці C: " + average);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка у вхідних даних: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Виникла непередбачена помилка: " + e.getMessage());
        }
    }

    /**
     * Множить матрицю на константу.
     *
     * @param matrix вхідна матриця
     * @param constant константа для множення
     * @return нова матриця, що є результатом множення
     * @throws IllegalArgumentException якщо матриця null або пуста
     */
    private static int[][] multiplyMatrixByConstant(int[][] matrix, int constant) {
        validateMatrix(matrix);

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        return result;
    }

    /**
     * Обчислює середнє значення елементів матриці.
     *
     * @param matrix вхідна матриця
     * @return середнє значення елементів
     * @throws IllegalArgumentException якщо матриця null або пуста
     */
    private static double calculateMatrixAverage(int[][] matrix) {
        validateMatrix(matrix);

        long sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }

        return (double) sum / count;
    }

    /**
     * Виводить матрицю на екран.
     *
     * @param matrix матриця для виведення
     * @throws IllegalArgumentException якщо матриця null або пуста
     */
    private static void printMatrix(int[][] matrix) {
        validateMatrix(matrix);

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    /**
     * Перевіряє коректність матриці.
     *
     * @param matrix матриця для перевірки
     * @throws IllegalArgumentException якщо матриця null або пуста
     */
    private static void validateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Матриця не може бути null або пустою");
        }

        int cols = matrix[0].length;
        for (int[] row : matrix) {
            if (row == null || row.length != cols) {
                throw new IllegalArgumentException("Всі рядки матриці повинні мати однакову довжину");
            }
        }
    }
}