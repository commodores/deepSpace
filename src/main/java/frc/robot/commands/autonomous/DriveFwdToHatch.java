/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class DriveFwdToHatch extends Command {
  public DriveFwdToHatch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_driveTrain);
    requires(Robot.m_gyro);
    requires(Robot.m_lidar);

    setTimeout(5.0);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_driveTrain.resetEncoders();
    Robot.m_gyro.zero();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double pTerm = Robot.m_driveTrain.driveTrainGain * (0.0 - Robot.m_gyro.getYaw());
    Robot.m_driveTrain.driveTank(-.4 - pTerm, -.4 + pTerm);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_lidar.getDistance() < 12 || isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}