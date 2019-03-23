package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.util.PIDOutputInterface;
import edu.wpi.first.networktables.*;

public class AlignToTarget extends Command {
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

        Robot.m_driveTrain.limelightPIDController.setP(RobotMap.kP);
        Robot.m_driveTrain.limelightPIDController.setI(RobotMap.kI);
        Robot.m_driveTrain.limelightPIDController.setD(RobotMap.kD);
        Robot.m_driveTrain.limelightPIDController.setOutputRange(-RobotMap.outputMagnitude, RobotMap.outputMagnitude);

        if(Robot.m_limelight.targetExists())
            Robot.m_driveTrain.limelightPIDController.enable();
        else
            System.out.println("Error: No targets detected");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
            if(Robot.m_lidar.getDistance()>75){
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
            } else if(Robot.m_lidar.getDistance()<=75 && Robot.m_lidar.getDistance()>40){
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
            } else {
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(2);
            }

            setpoint = Robot.m_limelight.getX();
            Robot.m_driveTrain.limelightPIDController.setSetpoint(setpoint);

            double output =  Robot.m_driveTrain.limelightPIDOutput.getPIDOutput();
            Robot.m_driveTrain.driveTank(-output, output);
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