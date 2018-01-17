package org.usfirst.frc.team4500.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4500.robot.RobotMap;;
/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon forwardLeft, forwardRight, backLeft, backRight;
	private Solenoid shooterAngle;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public Shooter(){
    	forwardLeft = new Talon(RobotMap.SHOOTER_MOTOR_FORWARDLEFT_PORT);
    	forwardRight = new Talon(RobotMap.SHOOTER_MOTOR_FORWARDRIGHT_PORT);
    	backLeft = new Talon(RobotMap.SHOOTER_MOTOR_BACKLEFT_PORT);
    	backRight = new Talon(RobotMap.SHOOTER_MOTOR_BACKRIGHT_PORT);
    	shooterAngle = new Solenoid(RobotMap.SHOOTER_ANGLE_PISTON_PORT);
    }
    public void ShooterUp(){
    	shooterAngle.set(true);
    }
    public void ShooterDown(){
    	shooterAngle.set(false);
    }
	public void SetShooterAngle(boolean mode){
		shooterAngle.set(mode);	
	}
    public void Spinup(double speed){
    	forwardLeft.set(speed);
    	forwardRight.set(-speed);
    }
    public void StopSpinup(){
    	forwardLeft.set(0.0);
    	forwardRight.set(0.0);
    }
    public void FeedBlock(double speed){
    	backLeft.set(speed);
    	backRight.set(-speed);
    }
    public void StopFeed(){
    	backLeft.set(0.0);
    	backRight.set(0.0);
    }
}
