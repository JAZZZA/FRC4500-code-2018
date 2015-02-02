package org.usfirst.frc.team4500.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Motor Ports
	public static double motorPower = .75;

	public static int flmotorPort = 0, frmotorPort = 1, blmotorPort = 2,
			brmotorPort = 3;
	
	public static int bottomClawClosed = 1495, bottomClawOpen = 0;

	// Joystick deadzone values
	public static double breakSpeed = 0.1; // How much to move the motor to keep
											// the elevator from moving down for
											// now
	public static double goDownResistance = 0;
	
	public static double joyDead = .15;

	public static int screwdriveMotor = 5;

	public static int screwDriveEncoder1 = 0;

	public static int screwDriveEncoder2 = 1;

	public static double screwSpeed = 0.5;

	public static double timeToMoveScrew = 0.5;

	public static int elevatorMotor = 6;

	public static int limitTop = 2;

	//public static int limitBottom = 4;

	public static final int openDemo = 0;

	//public static int limitBottomClawO = 0;

	//public static int limitBottomClawC = 6;

	//public static int arduinoOutput = 0;

	public static final int closeDemo = 1;

	public static final int pneumaticsModule = 0;

	public static final int TopClaw1 = 0, TopClaw2 = 1;
	
	
}
