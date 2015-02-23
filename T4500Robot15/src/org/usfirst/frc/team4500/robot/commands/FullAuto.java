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

		if (AUTOMODE == 1 || AUTOMODE == 2) {// pick up 3 totes
			addSequential(new PickupTrashCan());
			addSequential(new DriveUntilSonar(15, RobotMap.sonarForwardSpeed));
			addSequential(new TurnToFace(-15));
			addSequential(new PickupTote()); // First tote grabbed and lifted
			addSequential(new Wait(.4));
			if (AUTOMODE != 2) {

				addSequential(new DriveUntilSonar(RobotMap.sonar1,
						RobotMap.sonarForwardSpeed, angleToMaintain)); // Moved
																		// to
																		// second
																		// tote
				addSequential(new PickupTote()); // Second tote grabbed and
													// lifted
				addSequential(new Lift(.5));
				addSequential(new DriveUntilSonar(RobotMap.sonar1,
						RobotMap.sonarForwardSpeed, angleToMaintain)); // Moved
																		// to
																		// third
																		// tote
				addSequential(new PickupTote()); // Third tote grabbed
			}
			addSequential(new TurnToFace(finalAngle)); // Turned towards
														// auto
														// zone
			// addSequential(new Wait(.1));
			addSequential(new DriveUntilSonar(RobotMap.sonar1,
					RobotMap.sonarForwardSpeed, finalAngle));
			// Drive to auto
			// zone
			// CHANGE FOR
		} // COMPETITION!!!!!!!!!!!!!
			// <<<<<<<!!!!<<<<!!!!<<<!
		if (AUTOMODE == 3) {// pick up trash can from center then move to Auto
							// zone
			addSequential(new LowerBackClaw(RobotMap.BackClawLowerTime));
			addSequential(new DriveForSeconds(-.25, .5));
			addSequential(new RaiseBackClaw(1.5));
			addSequential(new DriveForSeconds(.25, 1));

		}
	}
}
