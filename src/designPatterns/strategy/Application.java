package designPatterns.strategy;

public class Application {
    private EmailService emailService;
    private SMSService smsService;


    public Application(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    /**
     * send an email and after that change the strategy and send SMS
     *
     * @param user
     */
    public void run(User user) {
        Notifier notifier= new Notifier(emailService::sendEmail);
        notifier.notifyCustomer(user);
        notifier.setNotificationStrategy(smsService::sendSMS);
        notifier.notifyCustomer(user);
    }
}
