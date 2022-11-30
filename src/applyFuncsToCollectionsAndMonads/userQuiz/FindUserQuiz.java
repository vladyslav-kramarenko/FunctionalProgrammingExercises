package applyFuncsToCollectionsAndMonads.userQuiz;

import java.util.*;

class FindUserQuiz {

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {



//        for(User u:users){
//            Account a=u.getAccount().get();
//            if(a.getId().equals(id)){
//                return Optional.ofNullable(u);
//            }
//        }
//        return Optional.empty();
        return users.stream()
                .filter(user -> user.getAccount()
                        .map(Account::getId)
                        .filter(id::equals)
                        .isPresent())
                .findAny();
    }

    public static void main(String[] args) {
        Account account1 = new Account("Account1");
        Account account2 = new Account("Account2");
        Account account3 = new Account("Account3");
        Set usersSet = new HashSet();
        usersSet.add(new User("User1", account1));
        usersSet.add(new User("User2", account2));
        usersSet.add(new User("User3", account3));
        System.out.println(FindUserQuiz.findUserByAccountId(usersSet, "Account1"));//return Optional user object
        System.out.println(FindUserQuiz.findUserByAccountId(usersSet, "Account22"));//return Optional.empty
    }
}

