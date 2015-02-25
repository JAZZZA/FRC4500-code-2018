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
	private static int AUTOMODE = 1;

	public FullAuto() {
		initialAngle = Robot.drivetrain.getAngle();

		addSequential(new OpenClaws()); // Safety precaution

		if (AUTOMODE == 1 || AUTOMODE == 2) {// 1= pick up 3 totes 2=pick up 1
												// tote, turn to auto zone
			addSequential(new PickupTrashCan());
			addSequential(new DriveUntilSonar(15, .4));
			addSequential(new TurnToFace(-15));
			addParallel(new PickupTote()); // First tote grabbed and lifted
			addSequential(new Wait(.4));
			if (AUTOMODE != 2) {

				addSequential(new DriveUntilSonar(RobotMap.sonar1,
						RobotMap.sonarForwardSpeed, angleToMaintain));// Moved
				// addSequential(new Wait(.2)); //might need this wait to
				// prevent dropping early // to
				// second
				// tote
				addSequential(new PickupTote()); // Second tote grabbed and
													// lifted
				addSequential(new Lift(.5));
				addSequential(new DriveUntilSonar(RobotMap.sonar1,
						RobotMap.sonarForwardSpeed, angleToMaintain)); // Moved
																		// to
				// addSequential(new Wait(.2));//might need wait here to prevent
				// early drop// third
				// tote
				addSequential(new PickupTote()); // Third tote grabbed
			}
			addParallel(new TurnToFace(finalAngle)); // Turned towards
														// auto
														// zone
			// addSequential(new Wait(.1)); //might
			// addSequential(new DriveUntilSonar(RobotMap.sonar1,
			// RobotMap.sonarForwardSpeed, finalAngle));
			addSequential(new DriveForSeconds(RobotMap.sonarForwardSpeed, 1.5));
			addParallel(new Lower());
			addSequential(new OpenBottomClaw());
			addSequential(new Lift(1));
			addSequential (new DriveForSeconds(-RobotMap.sonarForwardSpeed,.5));
		}

		if (AUTOMODE == 3) {// pick up trash can from center then move to Auto
							// zone
			addSequential(new LowerBackClaw(RobotMap.BackClawLowerTime));
			addSequential(new DriveForSeconds(-.25, .5));
			addSequential(new RaiseBackClaw(1.5));
			addSequential(new DriveForSeconds(.25, 1));
			addParallel(new LowerBackClaw(RobotMap.BackClawLowerTime));
			addSequential(new RaiseBackClaw(2));

		}
	}
}
