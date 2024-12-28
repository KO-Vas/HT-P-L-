package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task2 {

    private static Map<String, Double> parseCircleFromFile(String filePath) {
        Map<String, Double> circleData = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String[] centerCoordinates = reader.readLine().split(" ");
            double radius = Double.parseDouble(reader.readLine());

            circleData.put("x", Double.parseDouble(centerCoordinates[0]));
            circleData.put("y", Double.parseDouble(centerCoordinates[1]));
            circleData.put("r2", radius * radius);

        } catch (IOException e) {
            throw new IllegalArgumentException("Ошибка чтения файла: " + filePath, e);
        }

        return circleData;
    }

    private static List<double[]> parsePointsFromFile(String filePath) {
        List<double[]> pointsList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] coords = line.split(" ");
                pointsList.add(new double[] {Double.parseDouble(coords[0]),
                        Double.parseDouble(coords[1])});
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("Ошибка чтения файла: " + filePath, e);
        }

        return pointsList;
    }

    private static List<Integer> calculatePointPositions(Map<String, Double> circle,
            List<double[]> points) {
        List<Integer> positions = new ArrayList<>();

        double circleX = circle.get("x");
        double circleY = circle.get("y");
        double radiusSquared = circle.get("r2");

        for (double[] point : points) {
            double dx = point[0] - circleX;
            double dy = point[1] - circleY;

            double distanceSquared = dx * dx + dy * dy;
            if (distanceSquared > radiusSquared) {
                positions.add(2);
            } else if (distanceSquared == radiusSquared) {
                positions.add(0);
            } else {
                positions.add(1);
            }
        }

        return positions;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Укажите пути к файлам");
            return;
        }

        Map<String, Double> circle = parseCircleFromFile(args[0]);
        List<double[]> points = parsePointsFromFile(args[1]);

        List<Integer> pointPositions = calculatePointPositions(circle, points);
        pointPositions.forEach(System.out::println);
    }
}

