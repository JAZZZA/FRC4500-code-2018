package org.usfirst.frc.team4500.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Arduino extends Subsystem {
    SerialPort arduino = new SerialPort(9600, Port.kUSB); //or 1 idk ill make work soon! Serial.kUSB
    // Put methods for controlling this subsystem
    // here. Call these from Commands.  
	

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void switchMode(int Mode) {
    	switch(Mode) {
    	case 1:
    		arduino.writeString("Autonomous");
    	case 2:
    		arduino.writeString("Teleop");
    	case 3:
    		arduino.writeString("Disabled");
    	}
    }
    
    public void sendSignal() {
    	
    }
    
}

