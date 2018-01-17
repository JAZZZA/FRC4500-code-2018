package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Solenoid scissorLift;
	private Talon climberMotor;
	
	public Climber(){
		scissorLift = new Solenoid(RobotMap.CLIMBER_LIFT_PORT);
		climberMotor = new Talon(RobotMap.CLIMBER_PORT);
	}
	public void Extend(){
		scissorLift.set(true);
	}
	public void Retract(){
		scissorLift.set(false);
	}
	public void ClimbUp(){
		climberMotor.set(RobotMap.CLIMBER_CLIMBING_SPEED);
	}
	public void ClimbDown(){
		climberMotor.set(-RobotMap.CLIMBER_CLIMBING_SPEED);
	}
	public void StopClimb(){
		climberMotor.set(0.0);
	}
	public void Climb(double speed){
		climberMotor.set(speed);	
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

