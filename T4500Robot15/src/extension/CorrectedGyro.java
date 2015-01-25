package extension;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;

public class CorrectedGyro extends Gyro{
	double correctionFactor;
	Timer t;
	
	public CorrectedGyro(AnalogInput channel, double correctionFactor) {
		super(channel);
		this.correctionFactor = correctionFactor;
		t = new Timer();
		t.reset();
		t.start();
	}
	
	public CorrectedGyro(int channel, double correctionFactor){
		super(channel);
		this.correctionFactor = correctionFactor;
		t = new Timer();
		t.reset();
		t.start();
		
	}
	
	public void reset(){
		super.reset();
		t.reset();
		t.start();
	}
	
	//TODO: find out if the correction works at all
	
	public double getAngle(){
		double time = t.get();
		return super.getAngle() * correctionFactor - (0.0002024 * time * time + .1813 * time);	//subtract drift
	}
	
	public double getRate(){
		double time = t.get();
		return super.getRate() * correctionFactor - (2 * 0002024 * time + .1813);	//subtract rate of change of drift
	}

}
