package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class InflationProblem {

    public static long calculateTotalPriceInFuture(int numberOfYears, List<Grocery> groceries) {
//        priceInNYears = initialPrice * pow(times, numberOfYears)
        Map<Category, Double> times = new HashMap<>();
        times.put(Category.VEGETABLES, 3.0);
        times.put(Category.FRUITS, 4.0);
        times.put(Category.DAIRY, 2.0);

        return groceries
                .stream()
                .map(x -> x.getCost() * Math.pow(
                                times.get(x.getCategory()),
                                (numberOfYears)
                        )
                )
                .reduce(Double::sum).get().longValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
Sample Input 1:
1
15 VEGETABLES
30 VEGETABLES
10 FRUITS
20 DAIRY
Sample Output 1: 215
 */
        int numberOfYears = 1;
//        int numberOfYears = Integer.parseInt(scanner.nextLine());

        List<Grocery> groceries;
//        groceries = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
//                .map(i -> scanner.nextLine())
//                .map(inputLine -> {
//                    String[] parts = inputLine.split("\\s+");
//                    return new Grocery(Long.parseLong(parts[0]), Category.valueOf(parts[1]));
//                })
//                .collect(Collectors.toList());

        groceries = new ArrayList<>();
        groceries.add(0, new Grocery(15L, Category.VEGETABLES));
        groceries.add(0, new Grocery(30L, Category.VEGETABLES));
        groceries.add(0, new Grocery(10L, Category.FRUITS));
        groceries.add(0, new Grocery(20L, Category.DAIRY));

        long totalPriceInFuture = calculateTotalPriceInFuture(numberOfYears, groceries);

        System.out.println(totalPriceInFuture);
    }


}

enum Category {
    VEGETABLES,
    FRUITS,
    DAIRY
}

class Grocery {
    private final long cost;
    private final Category category;

    // Imagine that this class has some other fields but they are skipped for simplicity

    public Grocery(long cost, Category category) {
        this.cost = cost;
        this.category = category;
    }

    public long getCost() {
        return cost;
    }

    public Category getCategory() {
        return category;
    }
}