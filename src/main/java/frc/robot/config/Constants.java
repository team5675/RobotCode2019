package frc.robot.config;

public class Constants {
	//TALON CONFIG//
	public static final int kSlotIdx = 0;
	public static final int kPIDLoopIdx = 0;
	public static final int kTimeoutMs = 30;
	public static boolean kSensorPhase = true;
	public static boolean kMotorInvert = true;
	public static final Gains kGains = new Gains(0.05, 0.0, 1.0, 0.0, 0, 1); //kp, ki, kd, kf, izone, peak output
	
	//DRIVE CONFIG//
	static double DRIVE_DEADBAND = 0.2;

	//ELEVATOR LIMITS//
	public static int ELEVATOR_TOP_LIMIT = 980000;
	public static int ELEVATOR_BOTTOM_LIMIT = 0;
	public static int FOURBAR_TOP_LIMIT = 5200;
	public static int FOURBAR_BOTTOM_LIMIT = 0;

	//AUTO LINE UP//
	public static double P_GAIN = 0;
}