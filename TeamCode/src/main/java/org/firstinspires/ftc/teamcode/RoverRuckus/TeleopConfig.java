package org.firstinspires.ftc.teamcode.RoverRuckus;

import com.qualcomm.robotcore.util.Range;

import static com.qualcomm.robotcore.util.Range.clip;


public class TeleopConfig extends RobotHardwareMap
{
    public void InitServos(){
        SetServoPositions(0);
    }

    public void KillMotors(){
        KillDriveMotors();
        KillLiftMotors();
    }

    private void KillDriveMotors() {
        SetDriveMotors(0);
    }

    private void KillLiftMotors() {
        SetLiftMotors(0);
    }

    public void UpdateTelemetry(){
//        telemetry.addData("TeamColor", Color);
//        telemetry.addData("Autonomous Selection", AutoSelect);
//        telemetry.addData("Field Position", Position);
//        telemetry.update();
    }

    public void SwerveDrive(double Power, double Strafe, double Steer){
        SetLeftDriveMotors(Power - Steer);
        SetRightDriveMotors(Power + Steer);
        SetServoPositions(Strafe);
    }

    public void SetServoPositions(double angle) {
        double FrontLeftOffset = 0;
        double FrontRightOffset = 0;
        double BackLeftOffset = 0;
        double BackRightOffset = 0;

        double FrontLeftMax = 1;
        double FrontRightMax = 1;
        double BackLeftMax = 1;
        double BackRightMax = 1;

        FrontLeftServo.setPosition(clip(angle, FrontLeftOffset, FrontLeftMax));
        FrontRightServo.setPosition(clip(angle, FrontRightOffset, FrontRightMax));
        BackLeftServo.setPosition(clip(angle, BackLeftOffset, BackLeftMax));
        BackRightServo.setPosition(clip(angle, BackRightOffset, BackRightMax));
    }

    public void SetLiftMotors(double liftPower) {
        //LiftMotorOne.setPower(liftPower);
        //LiftMotorTwo.setPower(liftPower);
    }

    public void SetDriveMotors(double drive) {
        SetLeftDriveMotors(drive);
        SetRightDriveMotors(drive);
    }

    public void SetLeftDriveMotors(double leftPower) {
        FrontLeftMotor.setPower(leftPower);
        BackLeftMotor.setPower(leftPower);
    }

    public void SetRightDriveMotors(double rightPower) {
        FrontRightMotor.setPower(rightPower);
        BackRightMotor.setPower(rightPower);
    }

    public void InfeedIn() {
        //InfeedMotor.setPower(-1);
    }

    public void InfeedOut() {
        //InfeedMotor.setPower(1);
    }

    public void InfeedStop() {
        //InfeedMotor.setPower(0);
    }


}