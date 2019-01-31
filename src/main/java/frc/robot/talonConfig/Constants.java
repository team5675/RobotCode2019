package frc.robot.talonConfig;

public class Constants{

    public static final int kSlotIdx = 0;
	public static final int kPIDLoopIdx = 0;
	public static final int kTimeoutMs = 30;
	public static boolean kSensorPhase = true;
	public static boolean kMotorInvert = false;

	                                //kp, ki, kd, kf, izone, peak output
    public static final Gains kGains = new Gains(0.2, 0.0, 0.0, 0.2, 0, 1.0);


}