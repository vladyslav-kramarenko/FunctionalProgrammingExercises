package streams.parallelStreams;

import java.util.stream.LongStream;

public class NumberUtils {
    public static boolean isPrime(long n) {
        return n > 1 && LongStream
                .rangeClosed(2, n - 1)
                .noneMatch(divisor -> n % divisor == 0);
    }
}
