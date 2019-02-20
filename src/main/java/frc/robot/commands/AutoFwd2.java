/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.sql.Time;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoFwd2 extends Command {
  
  public AutoFwd2() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    setTimeout(2.0);
    requires(Robot.m_driveTrain);
    requires(Robot.m_climber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_gyro.zero();
    Robot.m_driveTrain.resetEncoders();
    Robot.m_ledBlinkinController.set4C();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double pTerm = Robot.m_driveTrain.driveTrainGain * (0.0 - Robot.m_gyro.getYaw());
    Robot.m_driveTrain.setSpeed(-.5 + pTerm, -.5 -pTerm);
    Robot.m_climber.driveFwd();
    System.out.println("Gyro: " + Robot.m_gyro.getYaw());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.stop();
    Robot.m_climber.stopDrive();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
