package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;
import org.usfirst.frc.team4500.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import extension.CorrectedGyro;

/**
 *
 */
public class Drivetrain extends Subsystem {

	// Drive Motors
	Talon flMotor = new Talon(RobotMap.flmotorPort);
	Talon frMotor = new Talon(RobotMap.frmotorPort);
	Talon blMotor = new Talon(RobotMap.blmotorPort);
	Talon brMotor = new Talon(RobotMap.brmotorPort);
	Gyro gyroscope = new CorrectedGyro(0, RobotMap.gyroFactor);
	RobotDrive drive = new RobotDrive(flMotor, blMotor, frMotor, brMotor);
	Ultrasonic sonar = new Ultrasonic(RobotMap.sonarPort1, RobotMap.sonarPort2);

	public Drivetrain() {
		gyroscope.setSensitivity(7.850195562631942);
		gyroscope.initGyro();
		gyroscope.reset();
	}

	public void resetGyro() {

		gyroscope.reset();
	}

	public double getAngle() {
		return 1.04 * gyroscope.getAngle();
	}

	public void driveWithJoystick(double x, double y, double rotation) {
		SmartDashboard.putNumber("Gyro Angle", getAngle());
		// Gyroscopic correction code -
		// Detects if the robot is rotating when it isn't supposed to be:
		if (rotation == 0
				&& Math.abs(gyroscope.getRate()) > RobotMap.gyroMarginOfError) {
			// Finds the rate of unwanted rotation in deg/sec from the gyro, and
			// then converts
			// that to a motor rotation speed using a rotation speed constant
			// that was gathered from
			// the robot experimentally in deg/sec:
			double correctionRate = gyroscope.getRate()
					/ RobotMap.robotRotSpeed;
			// Applies twist in the opposite direction of the unwanted rotation
			// in order to undo it.
			rotation -= correctionRate;

		}
		// The code ultimately sends out a corrected version of the rotation
		// value
		// in order to undo unwanted rotation, resulting in straight driving!
		drive.mecanumDrive_Cartesian(x, y, rotation, getAngle());
	}

	public void invertDriveMotors() {
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}

	public void driveBack(double speed) {
		drive.mecanumDrive_Cartesian(0, -speed, 0, 0);
	}

	public void stop() {
		drive.mecanumDrive_Cartesian(0, 0, 0, 0);
	}

	/**
	 * Drives robot forward at a specified speed
	 * @param speed (0 to 1)
	 */
	public void driveForward(double speed) {
		drive.mecanumDrive_Cartesian(0, speed, 0, 0);
	}
	
	public void intializeSonar(){
		sonar.setAutomaticMode(true);
		sonar.setEnabled(true);	
	}
	/**
	 * 
	 * @param range (in inches)
	 * @return
	 */
	public boolean isInRange(double range) {
		if (sonar.getRangeInches() < range) {
			return true;
		} else
			return false;
	}

	/**
	

 * Makes the robot strafe at a given speed and direction
	 * 
	 * @param speed
	 * @param direction
	 *            : true = right, false = left.
	 */
	public void strafe(double speed, boolean direction) {
		double dir;
		if (direction)
			dir = 1;
		else
			dir = -1;
		drive.mecanumDrive_Cartesian(dir * speed, 0, 0, 0);
	}
}
