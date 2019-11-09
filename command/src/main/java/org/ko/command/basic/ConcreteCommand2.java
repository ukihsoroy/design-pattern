package org.ko.command.basic;

/**
 * 命令2
 */
public class ConcreteCommand2 implements Command {

    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void executor() {
        receiver.action("concrete command 2.");
    }
}
