package org.usfirst.frc.team4500.robot;

import edu.wpi.first.wpilibj.DigitalSource;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Motor Ports
	public static int
	flmotorPort = 0,
	frmotorPort = 1,
	blmotorPort = 2,
	brmotorPort = 3;
	
	//Gyroscope port
	public static int gyroPort = 0;
	
	//Front Claw Ports
	public static int 
	clawWinch = 4,
	clawBMotor = 5; 
	
	//Solenoids
	public static int
	topClawOne1 = 0,//Dummy
	topClawOne2 = 1,//Dummy
	topClawTwo1 = 2,//Dummy
	topClawTwo2 = 3;//Dummy
	
	//Encoder, not sure if digital or analog slots
	public static int
	screwDriveEncoder1 = 0,//Dummy
	screwDriveEncoder2 = 1;//Dummy
	//Bottom Claw Encoder Values
	public static int 
	bottomClawClosed = 100,//Dummy
	bottomClawOpen = 0; //Dummy
	
	//EncoderForWinch
	public static int
	winchDriveEncoder1 = 0,
	winchDriveEncoder2 = 1;
	
	//Winch Encoder
	public static int
	winchBottom = 0,//Dummy
	winchPickup = 50; //Dummy
	
	//Joystick deadzone values
	public static double joyDead = .1; //Dummy value
	
    public static final int pneumaticsModule = 0;
    
	public static final int openDemo = 0;
	public static final int closeDemo = 1;
	
	public static final double winchTolerance = 1; //Dummy value
	public static double winchSetpoint = 1; //Dummy value

	public static double motorPower = 1;
	
	public static double gyroMarginOfError = 0.05;//Dummy
	public static double robotRotSpeed = 411;//The rotational rate of the robot at full twist in degrees per second

	
}
