package com.patterns.command.remote;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
         onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCmmand = new NoCommand();
        for(int i = 0 ; i < 7; i++) {
           onCommands[i] = noCmmand;
           offCommands[i] = noCmmand;
        }
    }

    public void  setCommand(int slot,Command onCommand,Command offCommand){
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonPushed(int slot) {
        if(onCommands[slot] != null)
            onCommands[slot].execute();
    }

    public void offButtonPushed(int slot) {
        if(offCommands[slot] != null)
            offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }

}
