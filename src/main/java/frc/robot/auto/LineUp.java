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

    double[] angles = {0, 28.75, 90, 151.25, 208.75, 270, 331.25};

    public void config() {

    }

    public void run() {
        double smallestError = 360;
        double bestAngle = 0;

        for (double angle : angles) {
            double error = Math.abs(angle - gyro.getAngle());
            // /System.out.println("Error: " + error + " Angle: " + angle + " bestAngle: " + bestAngle + " smallestError: " + smallestError + "currentAngle " + gyro.getAngle());
            if (error < smallestError) {
                smallestError = error;
                bestAngle = angle;
            }
        }

        //System.out.println(bestAngle);

        double rotatePower = (Math.abs(gyro.getAngle()) - bestAngle) * Constants.ROTATE_P_GAIN;
        double strafePower = (vision.getCenterXData() - 160) * Constants.STRAFE_P_GAIN;
        //System.out.println("Target: " + bestAngle + " Speed: " + rotatePower);
       //System.out.println(strafePower);
       //System.out.println("Target: " + bestAngle + " Current: " + gyro.getAngle());

        //System.out.println("strafePower: " + strafePower);
        drive.move(strafePower, driverController.getForward(), rotatePower * 0);
    }
}