package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BottomClawPID extends PIDSubsystem {
	
	public Talon screwDrive;
	Encoder screwEncoder;

    // Initialize your subsystem here
	private static double Kp = SmartDashboard.getNumber("Kp: ", 1), Ki = SmartDashboard.getNumber("Ki: ", 0), Kd = SmartDashboard.getNumber("Kd: ", 0);
    public BottomClawPID() {
    	super(Kp, Ki, Kd);
    	screwEncoder = new Encoder(RobotMap.screwDriveEncoder1, RobotMap.screwDriveEncoder2);
    	screwDrive = new Talon(RobotMap.screwdriveMotor);
    }
    
    public void initDefaultCommand() {}
    
    public void moveIn() {
    	screwDrive.set(1);
    }
    
    public void moveOut() {
    	screwDrive.set(-1);
    }
    
    protected double returnPIDInput() {
    	return screwEncoder.get();
    }
    
    protected void usePIDOutput(double output) {
    	screwDrive.pidWrite(output);
    }
    
    public void resetEncoder(){
    	screwEncoder.reset();
    }
    
    

}