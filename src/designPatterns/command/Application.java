package designPatterns.command;

import designPatterns.strategy.EmailService;
import designPatterns.strategy.Notifier;
import designPatterns.strategy.SMSService;
import designPatterns.strategy.User;

public class Application {
    private Executor executor;
    private Editor editor;

    public Application(Executor executor, Editor editor) {
        this.executor = executor;
        this.editor = editor;
    }

    void run() {
        Command selectAll = editor::selectAll;
        Command save = () -> editor.saveToClipboard(editor.getSelection());
        Command paste = () -> editor.replaceSelection(editor.getClipboard());
        // write your code here
        executor.executeCommand(selectAll);
        executor.executeCommand(save);
        executor.executeCommand(paste);
    }
}
