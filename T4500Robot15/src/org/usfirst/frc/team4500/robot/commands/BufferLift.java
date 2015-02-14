package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BufferLift extends CommandGroup {
    
    public  BufferLift() {
        addSequential(new Wait(1));
        addSequential(new LiftAtRest());
    }
}
