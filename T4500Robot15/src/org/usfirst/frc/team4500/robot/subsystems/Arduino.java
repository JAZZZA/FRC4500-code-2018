package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arduino extends Subsystem {
    private boolean mode = false;
    AnalogOutput arduino = new AnalogOutput(RobotMap.arduinoOutput);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean switchMode() {
    	if (mode) {
    		mode = false;
    		arduino.equals(mode);
    		return mode;
    	}
		else {
			mode = true;
			arduino.equals(mode);
			return mode;
		}
    }
    
    public void sendSignal() {
    	
    }
    
}

