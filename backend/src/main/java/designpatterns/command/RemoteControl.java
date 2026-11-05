package designpatterns.command;

public class RemoteControl {
    private Command[] slots;

    public RemoteControl(int size) {
        slots = new Command[size];
    }

    public void setCommand(int slot, Command command) {
        slots[slot] = command;
    }

    public void pressButton(int slot) {
        if (slots[slot] != null) {
            slots[slot].execute();
        } else {
            System.out.println("No command in slot " + slot);
        }
    }
}

