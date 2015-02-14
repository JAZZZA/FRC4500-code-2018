package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullAuto extends CommandGroup {
    
    public  FullAuto() {
        addSequential(new OpenClaws()); //Safety precaution
        addSequential(new PickupTrashCan()); //Trash can picked up
        addSequential(new DriveUntilSonar(RobotMap.sonar2, RobotMap.sonarForwardSpeed)); //Moved to our (first) tote
        addSequential(new PickupTote()); //First tote grabbed and lifted
        addSequential(new Wait(.4));
        addSequential(new DriveUntilSonar(RobotMap.sonar1, RobotMap.sonarForwardSpeed));  //Moved to second tote
        //addParallel(new BufferLift());
        addSequential(new PickupTote()); //Second tote grabbed and lifted
        addSequential(new ExtraLift());
        addSequential(new DriveUntilSonar(RobotMap.sonar1, RobotMap.sonarForwardSpeed)); //Moved to third tote
        //addParallel(new BufferLift());
        addSequential(new PickupTote()); //Third tote grabbed
        addSequential(new Turn90Degrees()); //Turned towards auto zone
        addSequential(new DriveUntilSonar(RobotMap.sonar1, RobotMap.sonarForwardSpeed)); //Drive to auto zone CHANGE FOR COMPETITION!!!!!!!!!!!!! <<<<<<<!!!!<<<<!!!!<<<!
    }
}
