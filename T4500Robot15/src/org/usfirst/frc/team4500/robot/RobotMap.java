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
	flmotorPort = 1,
	frmotorPort = 2,
	blmotorPort = 3,
	brmotorPort = 4;
	
	//Joystick deadzone values
	public static double joyDead = 1; //<-- Dummy value
	
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
