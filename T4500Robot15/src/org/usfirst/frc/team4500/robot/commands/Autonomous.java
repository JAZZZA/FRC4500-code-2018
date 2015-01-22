package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
   
    addSequential(new ToggleTopClaw());
    addParallel(new ElevatorSetPickup());
    //addParallel(new DriveBackTimer(RobotMap.autonomousDriveBack));
    //addSequential(new StrafeForSeconds(RobotMap.autonomousStrafeSpeed,RobotMap.autonomousStrafeDirection));
    addParallel(new DriveForwardTimer(RobotMap.autonomousDriveForward));
    //TODO: Vision Alignment Command
    addSequential(new PickupBox());

    }
}
