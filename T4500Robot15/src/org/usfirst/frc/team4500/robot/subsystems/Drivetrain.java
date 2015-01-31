package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.Robot;
import org.usfirst.frc.team4500.robot.RobotMap;
import org.usfirst.frc.team4500.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	//Drive Motors
	Talon flMotor = new Talon(RobotMap.flmotorPort);
	Talon frMotor = new Talon(RobotMap.frmotorPort);
	Talon blMotor = new Talon(RobotMap.blmotorPort);
	Talon brMotor = new Talon(RobotMap.brmotorPort);
	Gyro gyroscope = new Gyro(0);
	RobotDrive drive = new RobotDrive(flMotor,blMotor,frMotor,brMotor);
	
	public Drivetrain(){
		gyroscope.setSensitivity(7.850195562631942);
		gyroscope.initGyro();
		gyroscope.reset();
	}
	
	public void resetGyro() {
		
		gyroscope.reset();
	}
	
	public double getAngle(){
		return 1.04 * gyroscope.getAngle();
	}
	
	public void driveWithJoystick(double x, double y, double rotation) {
		SmartDashboard.putNumber("Encoder", Robot.bottomClaw.screwEncoder.get());
		SmartDashboard.putNumber("Gyro Angle", getAngle());
		drive.mecanumDrive_Cartesian(x, y, rotation, getAngle());
	}
	
	public void invertDriveMotors(){
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand (new DriveWithJoystick());
    }
}

