package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;
import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullAuto extends CommandGroup {
	private double initialAngle;
	private double angleToMaintain = initialAngle - 23;
	private double finalAngle = angleToMaintain - 90;
	private static final double INITIAL_LIFT = .5;
	private static final double INITIAL_STRAFE = .2;
	private static final double STRAFE = .70;
	private static final double STRAFE_SPEED = .8;
	private static final double INITIAL_FORWARD = .7;

	public FullAuto() {
		initialAngle = Robot.drivetrain.getAngle();
		
		addSequential(new OpenClaws()); // Safety precaution
		/*addSequential(new Lift(INITIAL_LIFT)); // Lift bottom claw above level
												// of top of tote
		addSequential(new DriveUntilSonar(10, .25)); // Move to trashcan
		addSequential(new Wait(.5));
		addSequential(new GrabTote());
		addSequential(new PickupTrashCan()); // Trash can picked up
		addSequential(new StrafeForSeconds(INITIAL_STRAFE,
				StrafeForSeconds.RIGHT, STRAFE));
		addSequential(new Wait(.5));
		addSequential(new DriveForSeconds(RobotMap.sonarForwardSpeed, INITIAL_FORWARD));
		addSequential(new TurnToFace(angleToMaintain));// Turned to face
															// proper
		// direction
		//addSequential(new Wait(.7));
		//addSequential(new StrafeForSeconds(STRAFE, StrafeForSeconds.RIGHT,
				//STRAFE_SPEED)); // Moved inline with boxes
		addSequential(new DriveUntilSonar(9, .25, angleToMaintain)); */
		// Moved to
																		// our
																		// (first)
																		// tote
		addSequential(new PickupTrashCan());
		addSequential(new DriveUntilSonar(15, RobotMap.sonarForwardSpeed));
		addSequential(new TurnToFace(-15));
		addSequential(new PickupTote()); // First tote grabbed and lifted
		addSequential(new Wait(.4));
		addSequential(new DriveUntilSonar(RobotMap.sonar1,
				RobotMap.sonarForwardSpeed, angleToMaintain)); // Moved to
																// second tote
		addSequential(new PickupTote()); // Second tote grabbed and lifted
		addSequential(new Lift(.5));
		addSequential(new DriveUntilSonar(RobotMap.sonar1,
				RobotMap.sonarForwardSpeed, angleToMaintain)); // Moved to third
																// tote
		addSequential(new PickupTote()); // Third tote grabbed
		addSequential(new TurnToFace(finalAngle)); // Turned towards auto zone
		// addSequential(new Wait(.1));
		addSequential(new DriveUntilSonar(RobotMap.sonar1,
				RobotMap.sonarForwardSpeed, finalAngle)); // Drive to auto zone
															// CHANGE FOR
															// COMPETITION!!!!!!!!!!!!!
															// <<<<<<<!!!!<<<<!!!!<<<!
	}
}
