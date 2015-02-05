package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arduino extends Subsystem {
    private boolean mode = false;
    AnalogOutput arduino = new AnalogOutput(/*RobotMap.arduinoOutput*/4);
    //Serial.printLn (val)
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void switchMode(int mode) {
    	switch (mode) {
    		case 1:
    			arduino.setVoltage(1.0);
    			break;
    		case 2:
    			arduino.setVoltage(2.0);
    			break;
    		case 3:
    			arduino.setVoltage(3.0);
    			break;
    		default:
    			arduino.setVoltage(0.0);
    	}
    
    public void sendSignal() {
    	
    }
    
}
