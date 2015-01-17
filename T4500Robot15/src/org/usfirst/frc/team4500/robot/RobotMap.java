package org.usfirst.frc.team4500.robot;
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
	
	//Joystick deadzone values
	public static double joyDead = .1; //Dummy value
	
    public static final int pneumaticsModule = 0;
    
	public static final int openDemo = 0;
	public static final int closeDemo = 1;
	
	public static final double winchTolerance = 1; //Dummy value
	public static double winchSetpoint = 1; //Dummy value

	public static double motorPower = 0.5;
	
}
