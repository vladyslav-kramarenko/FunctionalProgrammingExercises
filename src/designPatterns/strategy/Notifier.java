package designPatterns.strategy;

public class Notifier {
    private NotificationStrategy notificationStrategy;

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public Notifier(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }
    public void notifyCustomer(User user){
        notificationStrategy.notifyCustomer(user);
    }
}
