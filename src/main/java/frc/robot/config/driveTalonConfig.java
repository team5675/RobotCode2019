package frc.robot.config;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class driveTalonConfig {

    public static double DRIVE_DEADBAND = 0.2;

    public static void configDrive( WPI_TalonSRX driveTalon){

        driveTalon.configNominalOutputForward(0, Constants.kTimeoutMs);
        driveTalon.configNominalOutputReverse(0, Constants.kTimeoutMs);
        driveTalon.configPeakOutputForward(1, Constants.kTimeoutMs);
        driveTalon.configPeakOutputReverse(-1, Constants.kTimeoutMs);

        driveTalon.configNeutralDeadband(DRIVE_DEADBAND);
    }
}