package applyFuncsToCollectionsAndMonads;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * This generic class represents a monadic-like calculator
 */
class Calculator<T extends Number> {
    /**
     * It represents a calculator in which an error has occurred
     */
    private static final Calculator<?> BROKEN_CALCULATOR = new Calculator<>(true);
    /**
     * The value stored inside the calculator
     */
    private final T value;
    /**
     * It determines if the calculator has an error
     */
    private final boolean hasError;

    private Calculator(T value) {
        this.value = value;
        this.hasError = false;
    }

    private Calculator(boolean hasError) {
        this.value = null;
        this.hasError = hasError;
    }

    /**
     * It returns a broken calculator with an explicit type casting.
     * We recommend you to use this method instead of accessing BROKEN_CALCULATOR directly.
     */
    @SuppressWarnings("unchecked")
    private static <T extends Number> Calculator<T> getBrokenCalculator() {
        return (Calculator<T>) BROKEN_CALCULATOR;
    }

    /**
     * The method creates a new instance of the calculator with a specified initial value.
     */
    public static <T extends Number> Calculator<T> of(T value) {
        try {
            if (value == null) throw new NullPointerException();
            return new Calculator<>(value);
        } catch (ArithmeticException | NullPointerException e) {
            return getBrokenCalculator();
        }
    }

    /**
     * The method applies a given function to the value stored in the calculator.
     * It never throws ArithmeticException or NullPointerException
     */
    public <U extends Number> Calculator<U> eval(Function<? super T, ? extends U> mapper) {
        try {
            U newValue = mapper.apply(value);
            return of(newValue);
        } catch (ArithmeticException | NullPointerException e) {
            return getBrokenCalculator();
        }
    }

    /**
     * The method passes the stored value to a given consumer only if no errors have occurred in the calculator.
     */
    public Calculator<T> consume(Consumer<T> consumer) {
        if (hasError) return getBrokenCalculator();
        consumer.accept(value);
        return this;
    }

    public static void main(String[] args) {
        Calculator.of(10) // inits calculator with the default value 10
                .consume(System.out::println)  // shows the current value 10
                .eval(value -> value * 10)     // evaluates a new expression: 100
                .eval(value -> value + 5)      // evaluates a new expression: 105
                .consume(System.out::println)  // shows the current value 105
                .eval(value -> value / 0)      // provokes an error
                .consume(System.out::println); // doesn't print anything

        Calculator.of((Integer) null) // inits calculator with null as the default value
                .eval(value -> value * 10)     // doesn't evaluate anything
                .eval(value -> value + 5)      // doesn't evaluate anything
                .consume(System.out::println); // doesn't print anything

        Calculator.of(10) // init calculator with the default value 10
                .eval(value -> value + 5)      // evaluates a new expression: 15
                .consume(System.out::println)  // shows the current value 15
                .eval(value -> null) // makes the value null
                .consume(System.out::println); // doesn't print anything
    }

//    As a result, all these lines print only three numbers:
//            10
//            105
//            15
}