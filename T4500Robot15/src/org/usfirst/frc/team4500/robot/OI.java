package org.usfirst.frc.team4500.robot;


import org.usfirst.frc.team4500.robot.commands.ControlActuator;
import org.usfirst.frc.team4500.robot.commands.FullBackward;
import org.usfirst.frc.team4500.robot.commands.FullForward;
import org.usfirst.frc.team4500.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    
   
	Joystick drivestick = new Joystick(0);
	Trigger mainTrigger = new JoystickButton(drivestick, 1);
	Button backwardButton = new JoystickButton(drivestick, 3);
	Button forwardButton = new JoystickButton(drivestick, 4);
	
	public OI() {
		mainTrigger.whenActive(new ResetGyro());
		backwardButton.whileHeld(new FullBackward());
		forwardButton.whileHeld(new FullForward());
	}
	
	//Made the joystick always return 0 for now so we can test the pneumatics
	public double getX() {
		double x = Math.abs(drivestick.getX()) > RobotMap.joyDead ? drivestick.getX() : 0;
		SmartDashboard.putNumber("x", x);
		return RobotMap.motorPower*x;
	}
	
	public double getY() {
		double x = Math.abs(drivestick.getY()) > RobotMap.joyDead ? drivestick.getY() : 0;		
		return RobotMap.motorPower*x;
	}
	
	public double getTwist() {
		double x = Math.abs(drivestick.getTwist()) > RobotMap.joyDead ? drivestick.getTwist() : 0;
		return RobotMap.motorPower*x;
	}
	
	public boolean getTrigger() {
		return drivestick.getRawButton(1);
	}
	
}
    
