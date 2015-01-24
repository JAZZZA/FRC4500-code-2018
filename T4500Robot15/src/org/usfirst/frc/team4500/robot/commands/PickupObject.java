package org.usfirst.frc.team4500.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command group that 
 */
public class PickupObject extends CommandGroup {
    
    public  PickupObject() {
    	addSequential(new OpenBottomClaw());
    	addSequential(new ElevatorSetBottom());
        addSequential(new CloseBottomClaw());
        addSequential(new ElevatorSetPickup());
    }
}
