package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	public Autonomous() {

		addSequential(new ToggleTopClaw());
		addSequential(new PickupObject());
		addSequential(new DriveUntilSonar(RobotMap.sonar1,
				RobotMap.sonarForwardSpeed));
		// TODO: Vision Alignment Command (sequential)
		addSequential(new DriveUntilSonar(RobotMap.sonar2,
				RobotMap.sonarForwardSpeed));

		addParallel(new PickupObject());
		addParallel(new DriveUntilSonar(RobotMap.sonar1,
				RobotMap.sonarForwardSpeed));

		// Vision Alignment Command (sequential)
		addSequential(new DriveUntilSonar(RobotMap.sonar2,
				RobotMap.sonarForwardSpeed));

		addParallel(new PickupObject());
		addParallel(new DriveUntilSonar(RobotMap.sonar1,
				RobotMap.sonarForwardSpeed));

		// Vision Alignment Command (sequential)
		addSequential(new DriveUntilSonar(RobotMap.sonar2,
				RobotMap.sonarForwardSpeed));

		addParallel(new PickupObject());
		addParallel(new StrafeForSeconds(RobotMap.strafeTime, false,
				RobotMap.strafeSpeed));

	}
}
