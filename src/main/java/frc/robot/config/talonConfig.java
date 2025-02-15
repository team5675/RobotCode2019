package frc.robot.config;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

public class talonConfig {

public static void configElevator (WPI_TalonSRX _talon) {

_talon.configFactoryDefault();

_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                            Constants.kPIDLoopIdx, 
                                            Constants.kTimeoutMs);

_talon.setSensorPhase(Constants.kSensorPhase);
_talon.setInverted(Constants.kMotorInvert);

//set max and min outputs
_talon.configNominalOutputForward(0, Constants.kTimeoutMs);
_talon.configNominalOutputReverse(0, Constants.kTimeoutMs);
_talon.configPeakOutputForward(1, Constants.kTimeoutMs);
_talon.configPeakOutputReverse(-1, Constants.kTimeoutMs);

_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 13, Constants.kTimeoutMs);

//configure the loops
_talon.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
_talon.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
_talon.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
_talon.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
_talon.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);
_talon.config_IntegralZone(Constants.kSlotIdx, Constants.kGains.kIzone, Constants.kTimeoutMs);

//set accel and velocity
_talon.configMotionCruiseVelocity(1500, Constants.kTimeoutMs);
_talon.configMotionAcceleration(600, Constants.kTimeoutMs);

int absolutePosition = _talon.getSensorCollection().getPulseWidthPosition();

		/* Mask out overflows, keep bottom 12 bits */
		absolutePosition &= 0xFFF;
		if (Constants.kSensorPhase) { absolutePosition *= -1; }
		if (Constants.kMotorInvert) { absolutePosition *= -1; }
		
		/* Set the quadrature (relative) sensor to match absolute */
		_talon.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

// set sensor to 0
//_talon.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
} 
}