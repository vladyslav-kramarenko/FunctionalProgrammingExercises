package streams.generatingUsers;

import java.util.stream.Stream;

final class Utils {

    private Utils() {
    }

    public static Stream<User> generateUsers(int numberOfUsers) {
        return Stream
                .iterate(1, i -> i <= numberOfUsers, i -> i + 1)
                .map(i -> new User(i, "user" + i + "@gmail.com"));
    }

    public static void main(String[] args) {
        Utils.generateUsers(3).forEach(user -> System.out.println(user.getId() + " " + user.getEmail()));
    }
}
