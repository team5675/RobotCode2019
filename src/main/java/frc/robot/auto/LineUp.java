package frc.robot.auto;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.Vision;
import frc.robot.DriverController;
import frc.robot.config.Constants;


public class LineUp {
    Drive drive = new Drive();
    Vision vision = new Vision();
    Gyro gyro = new Gyro();
    DriverController driverController = new DriverController();

    double[] angles = {0, 45, 90};

    public void config() {

    }

    public void run() {
        double smallestError = 0;
        double bestAngle = 0;

        for (double angle : angles) {
            double error = Math.abs(angle - gyro.getAngle());

            if (error < smallestError) {
                smallestError = error;
                bestAngle = angle;
            }
        }

        double rotatePower = (gyro.getAngle() - bestAngle) * Constants.ROTATE_P_GAIN;
        double strafePower = (vision.getCenterXData() - 160) * Constants.STRAFE_P_GAIN;

        drive.move(strafePower, driverController.getForward(), rotatePower);
    }
}