package org.firstinspires.ftc.teamcode.RoverRuckus;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import static com.qualcomm.robotcore.util.Range.clip;


@TeleOp(name="TeleopTest", group="RoverRuckus")
@Disabled
public class TeleopTest extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    TeleopConfig robot = new TeleopConfig();

    double angle = 0;
    double adjustment = 0.1;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        robot.InitServos();
        robot.KillMotors();
        robot.UpdateTelemetry();
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
        robot.UpdateTelemetry();
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        if(gamepad1.right_bumper)
        {
            angle = angle + adjustment;
        }
        else if(gamepad1.left_bumper)
        {
            angle = angle - adjustment;
        }
        else if(gamepad1.right_trigger > .25)
        {
            adjustment = adjustment + 0.01;
        }
        else if(gamepad1.left_trigger > 0.25)
        {
            adjustment = adjustment - 0.01;
        }
        else if(gamepad1.a)
        {
            adjustment = adjustment + 0.1;
        }
        else if(gamepad1.b)
        {
            adjustment = adjustment - 0.1;
        }

        angle = clip(angle, 0, 1);
        adjustment = clip(adjustment, -.25, .25);

        telemetry.addData("Angle: ", angle);
        telemetry.addData("Adjustment: ", adjustment);
        telemetry.update();
        robot.SetServoPositions(angle);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        robot.KillMotors();
    }

}
