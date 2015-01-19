package org.usfirst.frc.team4500.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickUpBoxCommand extends CommandGroup {
    
    public  PickUpBoxCommand() {
    	
    	addSequential(new OpenBottomClaw());
    	addSequential(new ElevaorSetBottom());
        addSequential(new CloseBottomClaw());
        addSequential(new ElevatorSetPickUp());
    }
}
