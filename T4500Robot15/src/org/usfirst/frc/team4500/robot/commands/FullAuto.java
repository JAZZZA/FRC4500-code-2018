package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;
import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullAuto extends CommandGroup {
	private double initialAngle;
	private double angleToMaintain = initialAngle + 90;
	private double finalAngle = angleToMaintain + 90;
	private static final double STRAFE = 1;
	private static final boolean STRAFE_DIRECTION = true;

	public FullAuto() {
		initialAngle = Robot.drivetrain.getAngle();
		addSequential(new OpenClaws()); // Safety precaution
		addSequential(new PickupTrashCan()); // Trash can picked up
		addSequential(new TurnToFace(angleToMaintain));// Turned to face proper
														// direction
		addSequential(new StrafeForSeconds(STRAFE, STRAFE_DIRECTION,
				RobotMap.sonarForwardSpeed)); //Moved inline with boxes
		addSequential(new DriveUntilSonar(RobotMap.sonar2,
				RobotMap.sonarForwardSpeed, angleToMaintain)); // Moved to our
																// (first) tote
		addSequential(new PickupTote()); // First tote grabbed and lifted
		addSequential(new Wait(.4));
		addSequential(new DriveUntilSonar(RobotMap.sonar1,
				RobotMap.sonarForwardSpeed, angleToMaintain)); // Moved to
																// second tote
		addSequential(new PickupTote()); // Second tote grabbed and lifted
		addSequential(new ExtraLift());
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
