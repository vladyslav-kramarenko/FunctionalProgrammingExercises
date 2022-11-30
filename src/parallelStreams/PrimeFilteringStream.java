package parallelStreams;

import java.util.stream.LongStream;

/**
 * This code challenge is used on the Hyperskill / JetBrains Academy platform.
 * https://hyperskill.org/learn/step/8423
 */
public class PrimeFilteringStream {
    /**
     * You need to create a prepared parallel LongStream
     * for filtering prime numbers in the given range (inclusive both borders).
     * After calling the count() method it should return the count of prime numbers in the given range
     *
     * @param start range start (inclusive)
     * @param end   range end (inclusive)
     * @return count of prime numbers in the given range
     */
    public static LongStream createPrimesFilteringStream(long start, long end) {
        // write your code here
        return LongStream.rangeClosed(start, end)
                .parallel()
                .filter(NumberUtils::isPrime);
    }

    public static void main(String[] args) {
        System.out.println(createPrimesFilteringStream(0, 1000).count());
        //return 168
    }
}
