package com.patterns.command.remote;

import com.patterns.command.simpleremote.*;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light("Kitchen");
        LightOnCommand kitchenLightOn  = new LightOnCommand(light);
        LightOffCommand kitchenLightOff  = new LightOffCommand(light);

        Light light1 = new Light("living room");
        LightOnCommand livingLightOn  = new LightOnCommand(light1);
        LightOffCommand livingLightOff  = new LightOffCommand(light1);

        Light light3 = new Light("Bedroom");
        LightOnCommand bedroomLightOn  = new LightOnCommand(light3);
        LightOffCommand bedroomLightOff  = new LightOffCommand(light3);

        GarageDoor garageDoor = new GarageDoor("Home");
        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);


        remoteControl.setCommand(0,kitchenLightOn,kitchenLightOff);
        remoteControl.setCommand(1,livingLightOn,livingLightOff);
        remoteControl.setCommand(2,bedroomLightOn,bedroomLightOff);
        remoteControl.setCommand(3,garageDoorUpCommand,garageDoorDownCommand);


        remoteControl.onButtonPushed(0);
        remoteControl.offButtonPushed(0);

        remoteControl.onButtonPushed(1);
        remoteControl.offButtonPushed(1);

        remoteControl.onButtonPushed(2);
        remoteControl.offButtonPushed(2);

        remoteControl.onButtonPushed(3);
        remoteControl.offButtonPushed(3);

    }
}
