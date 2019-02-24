/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;

public class AutoFwdCrossLine extends Command {
  public AutoFwdCrossLine() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    setTimeout(10.0);
    requires(Robot.m_gyro);
    requires(Robot.m_ledBlinkinController);
    requires(Robot.m_limelight);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Reset Sensors
    Robot.m_gyro.zero();
    Robot.m_driveTrain.resetEncoders();
    Robot.m_ledBlinkinController.set4C();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double pTerm = Robot.m_driveTrain.driveTrainGain * (0.0 - Robot.m_gyro.getYaw());
    Robot.m_driveTrain.setSpeed(.8 + pTerm, .8 -pTerm);
    System.out.println("Gyro: " + Robot.m_gyro.getYaw());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_driveTrain.getLeftEncoderInches() > 98 || isTimedOut();
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