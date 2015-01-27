package org.usfirst.frc.team4500.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static double
	gyroFactor = 1.04;
	
	//Motor Ports
	public static int
	flmotorPort = 0,
	frmotorPort = 1,
	blmotorPort = 2,
	brmotorPort = 3,
	elevatorMotor = 4,
	screwdriveMotor = 5; 
	
	//Analog ports
	public static int 
	gyroPort = 0,
	sonarPort1 = 1,
	sonarPort2 = 2;
	
	
	public static int 
	arduinoOutput = 0;
	

	
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
	
	//Encoder For elevator winch
	public static int
	winchDriveEncoder1 = 0,
	winchDriveEncoder2 = 1;
	
	//Elevator Winch Encoder set down and pick up values
	public static int
	winchBottom = 0,//Dummy
	winchPickup = 50; //Dummy
	
	//Joystick deadzone values
	public static double joyDead = .1; //Dummy value
	
	//Autonomous values
	public static double
	sonarForwardSpeed = 0.1, //Dummy - Speed to move the robot forward during autonomous
	sonar1 = 12, //Dummy - Distance to vision align with the box
	sonar2 = 6, //Dummy - Distance to pickup box
	strafeSpeed = 0.75,//Dummy - Speed to strafe into the auto zone, probably will ultimately be '1' for full speed
	strafeTime = 5; //Dummy - Time to strafe left into the auto zone

	
    public static final int pneumaticsModule = 0;
    
	public static final int openDemo = 0;
	public static final int closeDemo = 1;
	
	//Winch PID stuffz
	public static final double winchTolerance = 1; //Dummy value
	public static double winchSetpoint = 1; //Dummy value

	public static double motorPower = 1;
	
	public static double gyroMarginOfError = 0.05;//Dummy
	public static double robotRotSpeed = 411;//The rotational rate of the robot at full twist in degrees per second

	// OLD: public static double autonomousDriveBack = 0.1; //Dummy

	// OLD: public static boolean autonomousStrafeDirection = true; //Strafe Right

	// OLD: public static double autonomousStrafeSpeed = 0.1;//Dummy

	// OLD: public static double autonomousDriveForward = 1; //Seconds Forward Dummy
	
}
