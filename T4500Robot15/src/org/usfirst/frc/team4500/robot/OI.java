package org.usfirst.frc.team4500.robot;


//import org.usfirst.frc.team4500.robot.commands.ElevatorMoveUp;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.usfirst.frc.team4500.robot.commands.DriveUntilSonar;
import org.usfirst.frc.team4500.robot.commands.FullBackward;
import org.usfirst.frc.team4500.robot.commands.FullForward;
import org.usfirst.frc.team4500.robot.commands.Lift;
import org.usfirst.frc.team4500.robot.commands.Lower;
import org.usfirst.frc.team4500.robot.commands.LowerBackClaw;
import org.usfirst.frc.team4500.robot.commands.LowerNewBackClaw;
import org.usfirst.frc.team4500.robot.commands.OpenClaws;
import org.usfirst.frc.team4500.robot.commands.RaiseBackClaw;
import org.usfirst.frc.team4500.robot.commands.RaiseNewBackClaw;
import org.usfirst.frc.team4500.robot.commands.ResetGyro;
import org.usfirst.frc.team4500.robot.commands.ToggleBottomClaw;
import org.usfirst.frc.team4500.robot.commands.ToggleTopClaw;
import org.usfirst.frc.team4500.robot.commands.Turn90Degrees;


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
	Joystick drivestick = new Joystick(0);	//Drivestick / Rob's Stick
	Joystick functionstick = new Joystick(1); //Functionstick / Cindy's Stick
	Trigger mainTrigger = new JoystickButton(functionstick, 1); 
	Button backwardButton = new JoystickButton(drivestick, 8);
	Button forwardButton = new JoystickButton(drivestick, 7);
	public Button liftButton = new JoystickButton(functionstick, 3);
	public Button lowerButton = new JoystickButton(functionstick, 2);
	/*public Button outButton = new JoystickButton(functionstick, 5);
	public Button inButton = new JoystickButton(functionstick, 4);*/
	Button gyroReset = new JoystickButton(drivestick, 3);
	Button SonarTest = new JoystickButton(drivestick, 9);
	Button topClaw = new JoystickButton(functionstick, 4);
	//Button openClaws = new JoystickButton(functionstick,6); //Functionstick Auto Trials
	//Button autoLift = new JoystickButton(functionstick, 7);
	//Button autoLower = new JoystickButton(functionstick, 8);
	Button turn90 = new JoystickButton(functionstick, 9);
	Button raiseBack = new JoystickButton(functionstick, 11); //Functionstick Auto Trials
	Button lowerBack = new JoystickButton(functionstick, 10);
	Button lowerNewBack = new JoystickButton(drivestick, 12);
	Button raiseNewBack = new JoystickButton(drivestick, 11);
	
	
	Socket imageProcessingComputer;
	InputStream imageProcessingInput;
	OutputStream imageProcessingOutput;
	
	public OI() {
		SonarTest.whenPressed(new DriveUntilSonar(14, .25));
		gyroReset.whenPressed(new ResetGyro());
		backwardButton.whileHeld(new FullBackward());
		forwardButton.whileHeld(new FullForward());
		mainTrigger.whenActive(new ToggleTopClaw());
		topClaw.whenPressed(new ToggleBottomClaw());
		//outButton.whenReleased(new ScrewDriveAtRest());
		//inButton.whenReleased(new ScrewDriveAtRest());
		//liftButton.whileHeld(new ElevatorMoveUp());
		//encoderReset.whenPressed(new ResetShaftEncoder());
		//pidSetOpen.whenPressed(new OpenBottomClaw());
		//pidSetClosed.whenPressed(new CloseBottomClaw());
		//openClaws.whenPressed(new OpenClaws()); //Functionstick Auto Trials
		//autoLift.whenPressed(new Lift());
		//autoLower.whenPressed(new Lower());
		turn90.whenPressed(new Turn90Degrees());
		raiseBack.whileHeld(new RaiseBackClaw());
		lowerBack.whileHeld(new LowerBackClaw());
		//raiseBack.whenReleased(new StopBackClaw());
		//lowerBack.whenReleased(new StopBackClaw());
		lowerNewBack.whenPressed(new LowerNewBackClaw());
		raiseNewBack.whenPressed(new RaiseNewBackClaw());
		
		
		try {
			imageProcessingComputer = new Socket(RobotMap.imageProcessingIP, 1234);
			imageProcessingInput = imageProcessingComputer.getInputStream();
			imageProcessingOutput = imageProcessingComputer.getOutputStream();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SmartDashboard.putString("Error", "Cannot connect to computer");
		}
		
		
	}
	
	//Made the joystick always return 0 for now so we can test the pneumatics
	public double getX() {
		double x = Math.abs(drivestick.getX()) > RobotMap.joyDead ? drivestick.getX() : 0;
		SmartDashboard.putNumber("x", x);
		return RobotMap.motorPower*x;
	}
	
	public double getElevator() {
		return drivestick.getThrottle();
	}
	
	public double getCenter(){
		try {
			imageProcessingOutput.write("1".getBytes());
			byte[] b = new byte[111];
			int read = imageProcessingInput.read(b, 0, 100);
			@SuppressWarnings("deprecation")
			double d = Double.parseDouble(new String(b, read));
			
			SmartDashboard.putNumber("Center", d);
			return d;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block`
			e.printStackTrace();
			
		}
		return -1;
	}
	
	public double getY() {
		double x = Math.abs(drivestick.getY()) > RobotMap.joyDead ? drivestick.getY() : 0;		
		return RobotMap.motorPower*x;
	}
	
	public double getTwist() {
		double x = Math.abs(drivestick.getTwist()) > RobotMap.twistDead ? drivestick.getTwist() : 0;
		return RobotMap.motorPower*x;
	}
	
	public boolean getTrigger() {
		return drivestick.getRawButton(1);
	}
	
}
    
