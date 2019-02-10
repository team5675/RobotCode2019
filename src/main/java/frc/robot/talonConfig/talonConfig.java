package frc.robot.talonConfig;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class talonConfig {

public static void configElevator (WPI_TalonSRX masterElevator) {

masterElevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute,
                                            Constants.kPIDLoopIdx, 
                                            Constants.kTimeoutMs);

masterElevator.setSensorPhase(Constants.kSensorPhase);

masterElevator.setInverted(Constants.kMotorInvert);

//set max and min outputs
masterElevator.configNominalOutputForward(0, Constants.kTimeoutMs);
masterElevator.configNominalOutputReverse(0, Constants.kTimeoutMs);
masterElevator.configPeakOutputForward(1, Constants.kTimeoutMs);
masterElevator.configPeakOutputReverse(-1, Constants.kTimeoutMs);

masterElevator.configAllowableClosedloopError(Constants.kPIDLoopIdx, 0, Constants.kTimeoutMs);

//configure the loops
masterElevator.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
masterElevator.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
masterElevator.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
masterElevator.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);
masterElevator.config_IntegralZone(Constants.kSlotIdx, Constants.kGains.kIzone, Constants.kTimeoutMs);


int absolutePosition = masterElevator.getSensorCollection().getPulseWidthPosition();

//keeps loop from overflowing
absolutePosition &= 0xFF;
if (Constants.kSensorPhase) { absolutePosition *= -1; }
if (Constants.kMotorInvert) { absolutePosition *= -1; }

// set sensor to 0
masterElevator.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
} 
}