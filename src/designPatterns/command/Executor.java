package designPatterns.command;

public class Executor {
    public void executeCommand(Command command) {
        command.execute();
    }
}
