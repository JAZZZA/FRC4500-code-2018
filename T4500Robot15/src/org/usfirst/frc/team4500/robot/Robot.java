
package org.usfirst.frc.team4500.robot;


import org.usfirst.frc.team4500.robot.commands.Autonomous;
import org.usfirst.frc.team4500.robot.subsystems.BottomClaw;
import org.usfirst.frc.team4500.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4500.robot.subsystems.Elevator;
import org.usfirst.frc.team4500.robot.subsystems.PneumaticsMain;
import org.usfirst.frc.team4500.robot.subsystems.TopClaw;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

    Command autonomousCommand;
    public static Drivetrain drivetrain;
    public static PneumaticsMain pneumaticsDemo;
    public static TopClaw topClaw;
    public static BottomClaw bottomClaw;
    public static Elevator elevator;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		bottomClaw = new BottomClaw();
		topClaw = new TopClaw();
		drivetrain = new Drivetrain();
		drivetrain.invertDriveMotors();
		pneumaticsDemo = new PneumaticsMain();
		elevator = new Elevator();
		drivetrain.intializeSonar();
		
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = new Autonomous(); // Sets Autonomous.java as the autonomous command
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
