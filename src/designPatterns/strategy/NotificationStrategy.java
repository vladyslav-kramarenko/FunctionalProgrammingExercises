package designPatterns.strategy;
@FunctionalInterface
public interface NotificationStrategy {
    void notifyCustomer(User user);
}
