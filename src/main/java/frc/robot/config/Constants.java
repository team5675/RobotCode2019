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

	//ELEVATOR CONFIG//
	public static int ELEVATOR_TOP_LIMIT = 980000;
	public static int ELEVATOR_BOTTOM_LIMIT = 75000;
	public static int FOURBAR_TOP_LIMIT = 4600;
	public static int FOURBAR_BOTTOM_LIMIT = 0;
	public static int ELEVATOR_SLOW_DOWN = 180000;
	public static int FOURBAR_SLOW_DOWN = 1000;
	public static double ELEVATOR_P_GAIN = 0.00001;
	public static double FOURBAR_P_GAIN = 0.0005;

	//AUTO LINE UP CONFIG//
	public static double STRAFE_P_GAIN = 0.015;
	public static double ROTATE_P_GAIN = 0.02;
}