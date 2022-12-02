package returnFunction;

import java.util.function.Function;
import java.util.function.Predicate;

public class ExtensionService {

    /**
     * Accepts two string predicates and returns a function
     *
     * @param isXML
     * @param isJson
     * @return The returning function should accept one argument and return:
     * - the argument with .xml suffix if the argument matches the first predicate,
     * - .json suffix if the argument matches the second predicate,
     * - and the argument itself otherwise.
     */
    public static Function<String, String> addExtension(Predicate<String> isXML, Predicate<String> isJson) {
        // write your code here
        return (arg) -> {
            if (isXML.test(arg)) {
                return arg + ".xml";
            } else if (isJson.test(arg)) {
                return arg + ".json";
            } else {
                return arg;
            }
        };
    }

    /**
     * Accepts two string predicates and returns a function
     *
     * @param isXML
     * @param isJson
     * @return The returning function should accept one argument and return:
     * - the argument with .xml suffix if the argument matches the first predicate,
     * - .json suffix if the argument matches the second predicate,
     * - and the argument itself otherwise.
     */
    public static Function<String, String> addExtensionV2(Predicate<String> isXML, Predicate<String> isJson) {
        return (arg) -> arg
                + (isXML.test(arg) ? ".xml"
                : isJson.test(arg) ? ".json"
                : ""
        );
    }

    public static void main(String[] args) {
        Function<String, String> func = addExtension(y -> y.equals("First"), y -> y.equals("Second"));
        Function<String, String> func2 = addExtensionV2(y -> y.equals("First"), y -> y.equals("Second"));
        System.out.println(func.apply("First"));//should print First.xml
        System.out.println(func.apply("Second"));//should print Second.json
        System.out.println(func.apply("Otherwise"));//should print Otherwise

        System.out.println(func2.apply("First"));//should print First.xml
        System.out.println(func2.apply("Second"));//should print Second.json
        System.out.println(func2.apply("Otherwise"));//should print Otherwise
    }
}
