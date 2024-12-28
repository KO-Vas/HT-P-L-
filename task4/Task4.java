package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task4 {

    private static List<Integer> readElementsFromFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Ошибка чтения файла: " + filePath, e);
        }
        return numbers;
    }

    public static void main(String[] args) {
        // if (args.length < 1) {
        // System.err.println("Укажите путь к файлу с числами.");
        // return;
        // }

        List<Integer> numbers = readElementsFromFile(
                "C:\\Users\\Redmi\\Documents\\projects\\tasks4kda-2\\task4\\file1.txt");// args[0]);
        numbers.sort(Integer::compareTo);
        int medianIndex = numbers.size() / 2;
        int totalMoves = 0;

        for (int number : numbers) {
            totalMoves += Math.abs(number - numbers.get(medianIndex));
        }

        System.out.println(totalMoves);
    }
}

