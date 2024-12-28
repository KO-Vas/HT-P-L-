import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1, m = -1;

        while (true) {
            System.out.print("Введите 2 целых положительных числа через пробел: ");
            String input = scanner.nextLine();
            String[] numbers = input.split(" ");
            try {
                if (numbers.length == 2) {
                    n = Integer.parseInt(numbers[0]);
                    m = Integer.parseInt(numbers[1]);
                    if (n > 0 && m > 0)
                        break;
                }
                System.out.println("Некорректный ввод");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }

        StringBuilder sequence = new StringBuilder("1");
        int currentIndex = 1;

        while (true) {
            int nextIndex = (currentIndex + (m - 1)) % n;
            nextIndex = (nextIndex == 0) ? n : nextIndex;

            if (nextIndex == 1)
                break;

            sequence.append(nextIndex);
            currentIndex = nextIndex;
        }

        System.out.println(sequence);
    }
}
