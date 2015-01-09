package org.usfirst.frc.team4500.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team4500.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
   
	Joystick drivestick = new Joystick(1);
	
	public double getX() {
		return Math.abs(drivestick.getX()) > RobotMap.joyDead ? drivestick.getX() : 0;
	}
	
	public double getY() {
		return Math.abs(drivestick.getY()) > RobotMap.joyDead ? drivestick.getY() : 0;		
	}
	
	public double getTwist() {
		return Math.abs(drivestick.getTwist()) > RobotMap.joyDead ? drivestick.getTwist() : 0;
	}
}

