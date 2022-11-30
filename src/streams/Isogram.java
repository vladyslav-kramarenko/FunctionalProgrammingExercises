package streams;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Isogram {

    public static boolean isIsogram(String word) {
        return word.length()==word.chars().distinct().count();
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);

        String word;
//        word = scanner.nextLine();
        word="test";

        System.out.println(isIsogram(word));
    }
}