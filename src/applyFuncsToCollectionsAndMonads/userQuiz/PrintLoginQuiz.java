package applyFuncsToCollectionsAndMonads.userQuiz;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class PrintLoginQuiz {

    public static void printLoginIfPro(Set<User> users, String id) {
        if (users == null || id == null) {
            return;
        }

        users.forEach(u -> Optional.ofNullable(u.getAccount())
                .filter(Optional::isPresent)
                .filter(account ->
                        account
                                .get()
                                .getType()
                                .equals("pro")
                                &
                                account
                                        .get()
                                        .getId()
                                        .equals(id))
                .ifPresent(account ->
                        System.out.println(u.getLogin())));

//        FindUserQuiz
//                .findUserByAccountId(users, id)
//                .filter(v -> v
//                        .getAccount()
//                        .get()
//                        .getType()
//                        .equals("pro")
//                )
//                .map(n -> n.getLogin()).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Account account1 = new Account("Account1", "pro");
        Account account2 = new Account("Account2", "pro");
        Account account3 = new Account("Account3", "simple");
        Set usersSet = new HashSet();
        usersSet.add(new User("User1", account1));
        usersSet.add(new User("User2", account2));
        usersSet.add(new User("User3", account3));
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account1");//print User1
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account3");//doesn't print anything
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account22");//doesn't print anything
    }
}