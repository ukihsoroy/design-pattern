package org.ko.command.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行人
 */
public class Staff {

    private List<Command> commands = new ArrayList<>();

    public void addCommand (Command command) {
        commands.add(command);
    }

    public void executeCommands () {
        commands.forEach(Command::execute);
        commands.clear();
    }

}
