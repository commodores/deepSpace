package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.util.PIDOutputInterface;

public class AlignToTarget extends Command {
    static double kP = 0.03;
    static double kI = 0;
    static double kD = 0;
    static double outputMagnitude = 0.6;
    double setpoint = 0;

    public AlignToTarget() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.m_driveTrain);
        requires(Robot.m_limelight);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.m_driveTrain.resetAngle();

        Robot.m_driveTrain.limelightPIDController.setP(kP);
        Robot.m_driveTrain.limelightPIDController.setI(kI);
        Robot.m_driveTrain.limelightPIDController.setD(kD);
        Robot.m_driveTrain.limelightPIDController.setOutputRange(-outputMagnitude, outputMagnitude);

        if(Robot.m_limelight.targetExists())
            Robot.m_driveTrain.limelightPIDController.enable();
        else
            System.out.println("Error: No targets detected");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
            setpoint = Robot.m_limelight.getX();
            Robot.m_driveTrain.limelightPIDController.setSetpoint(setpoint);

            double output =  Robot.m_driveTrain.limelightPIDOutput.getPIDOutput();
            Robot.m_driveTrain.driveTank(output, -output);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.m_driveTrain.limelightPIDController.onTarget();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.m_driveTrain.limelightPIDController.disable();
        Robot.m_driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}