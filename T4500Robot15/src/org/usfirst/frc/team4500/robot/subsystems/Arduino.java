package org.usfirst.frc.team4500.robot.subsystems;


/**
 *
 */
public class Arduino extends Subsystem {
    SerialPort arduino = new SerialPort(9600, 0);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.  
	

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void switchMode(int Mode) {
    	switch(Mode) {
    	case 1:
    		arduino.writeString("Best Code Evaa");
    		
    	}
    }
    
    public void sendSignal() {
    	
    }
    
}

