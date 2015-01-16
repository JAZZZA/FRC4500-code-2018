package org.usfirst.frc.team4500.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Motor Ports
	public static double
	motorPower = .5;
	
	public static int
	flmotorPort = 0,
	frmotorPort = 1,
	blmotorPort = 2,
	brmotorPort = 3;
	
	
	//Joystick deadzone values
	public static double joyDead = .01; //<-- Dummy value


	public static final int openDemo = 0;


	public static final int closeDemo = 1;
	
    public static final int pneumaticsModule = 0;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
