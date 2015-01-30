package org.usfirst.frc.team4500.robot;


import org.usfirst.frc.team4500.robot.commands.CloseBottomClaw;
//import org.usfirst.frc.team4500.robot.commands.ElevatorMoveUp;
import org.usfirst.frc.team4500.robot.commands.FullBackward;
import org.usfirst.frc.team4500.robot.commands.FullForward;
import org.usfirst.frc.team4500.robot.commands.OpenBottomClaw;
import org.usfirst.frc.team4500.robot.commands.ResetGyro;
import org.usfirst.frc.team4500.robot.commands.ScrewDriveAtRest;
import org.usfirst.frc.team4500.robot.commands.ToggleTopClaw;
//import org.usfirst.frc.team4500.robot.subsystems.BottomClaw;

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
   
	Joystick drivestick = new Joystick(1);
	Joystick elevatorStick = new Joystick(0);
	Trigger mainTrigger = new JoystickButton(drivestick, 1);
	Button backwardButton = new JoystickButton(drivestick, 3);
	Button forwardButton = new JoystickButton(drivestick, 5);
	Button topClawButton = new JoystickButton(drivestick, 2);
	//Button liftButton = new JoystickButton(drivestick, 6);
	//Button lowerButton = new JoystickButton(drivestick, 4);
	Button outButton = new JoystickButton(drivestick, 11);
	Button inButton = new JoystickButton(drivestick, 12);
	
	public OI() {
		mainTrigger.whenActive(new ResetGyro());
		backwardButton.whileHeld(new FullBackward());
		forwardButton.whileHeld(new FullForward());
		topClawButton.whenPressed(new ToggleTopClaw());
		outButton.whileHeld(new OpenBottomClaw());
		outButton.whenReleased(new ScrewDriveAtRest());
		inButton.whileHeld(new CloseBottomClaw());
		inButton.whenReleased(new ScrewDriveAtRest());
		//liftButton.whileHeld(new ElevatorMoveUp());
	}
	
	//Made the joystick always return 0 for now so we can test the pneumatics
	public double getX() {
		double x = Math.abs(drivestick.getX()) > RobotMap.joyDead ? drivestick.getX() : 0;
		SmartDashboard.putNumber("x", x);
		return RobotMap.motorPower*x;
	}
	
	public double getElevator() {
		return elevatorStick.getY();
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
    
