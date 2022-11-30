package streams;

import java.util.Arrays;
import java.util.Scanner;

class SumOfNumbers {

    public static long sum(long[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.println(sum(numbers));
    }
}