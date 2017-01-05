package com.patterns.command.simpleremote;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        LightOnCommand lightOnCommand = new LightOnCommand(new Light());
        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonPressed();

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(new GarageDoor());
        simpleRemoteControl.setCommand(garageDoorOpenCommand);
        simpleRemoteControl.buttonPressed();
    }
}
