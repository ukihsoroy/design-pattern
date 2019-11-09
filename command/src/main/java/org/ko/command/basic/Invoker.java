package org.ko.command.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令执行人
 */
public class Invoker {

    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executorCommands() {
        commands.forEach(Command::executor);
        commands.clear();
    }
}
