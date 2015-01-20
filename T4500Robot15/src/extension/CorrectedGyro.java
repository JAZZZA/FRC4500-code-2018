package extension;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;

public class CorrectedGyro extends Gyro{
	double correctionFactor;
	public CorrectedGyro(AnalogInput channel, double correctionFactor) {
		super(channel);
		this.correctionFactor = correctionFactor;
		// TODO Auto-generated constructor stub
	}
	
	public CorrectedGyro(int channel, double correctionFactor){
		super(channel);
		this.correctionFactor = correctionFactor;
	}
	
	public double getAngle(){
		return super.getAngle() * correctionFactor;
	}
	
	public double getRate(){
		return super.getRate() * correctionFactor;
	}

}
