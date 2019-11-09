package org.ko.command.basic;

/**
 * 命令1
 */
public class ConcreteCommand1 implements Command {

    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void executor() {
        receiver.action("concrete command 1.");
    }
}
