package org.usfirst.frc.team4500.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickupBox extends CommandGroup {
    
    public  PickupBox() {
    	
    	addSequential(new OpenBottomClaw());
    	addSequential(new ElevatorSetBottom());
        addSequential(new CloseBottomClaw());
        addSequential(new ElevatorSetPickup());
    }
}
