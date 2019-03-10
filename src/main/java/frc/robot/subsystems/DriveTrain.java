/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static final double ENCODER_TICKS_PER_REVOLUTION = 20500;
	private static final double WHEEL_CIRCUMFERENCE_INCHES = 6 * Math.PI;
  
  public final double driveTrainGain = .015;
  

  private final WPI_TalonSRX leftMaster = RobotMap.driveTrainLeftMaster;
  private final WPI_TalonSRX leftSlave1 = RobotMap.driveTrainLeftSlave1;
  private final WPI_TalonSRX leftSlave2 = RobotMap.driveTrainLeftSlave2;

  private final WPI_TalonSRX rightMaster = RobotMap.driveTrainRightMaster;
  private final WPI_TalonSRX rightSlave1 = RobotMap.driveTrainRightSlave1;
  private final WPI_TalonSRX rightSlave2 = RobotMap.driveTrainRightSlave2;

  private final DifferentialDrive m_drive;

    
  public DriveTrain() {

    leftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,  0);

    rightMaster.setInverted(false);
    rightSlave1.setInverted(false);
    rightSlave2.setInverted(false);
    leftMaster.setInverted(false);
    leftSlave1.setInverted(false);
    leftSlave2.setInverted(false);

    leftMaster.setSensorPhase(true);

    rightMaster.configOpenloopRamp(.5);
    leftMaster.configOpenloopRamp(.5);

    leftSlave1.follow(leftMaster);
    leftSlave2.follow(leftMaster);
    rightSlave1.follow(rightMaster);
    rightSlave2.follow(rightMaster);
    
    rightMaster.setNeutralMode(NeutralMode.Brake);
    rightSlave1.setNeutralMode(NeutralMode.Brake);
    rightSlave2.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftSlave1.setNeutralMode(NeutralMode.Brake);
    leftSlave2.setNeutralMode(NeutralMode.Brake);
    
    m_drive = new DifferentialDrive(leftMaster, rightMaster);
    m_drive.setSafetyEnabled(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManual());
  }

  public void driveTank(double left, double right){
    m_drive.tankDrive(left, right);
  }
  
    
  public void driveCurvature(double speed, double  rotation, boolean quickTurn){
    m_drive.curvatureDrive(speed, rotation, quickTurn);
  }

  public void stop() {
    m_drive.stopMotor();
  }

  public double getLeftEncoder() {
    return leftMaster.getSelectedSensorPosition();
  }

  public double getLeftEncoderInches() {
    return getLeftEncoder() / ENCODER_TICKS_PER_REVOLUTION * WHEEL_CIRCUMFERENCE_INCHES;
  }

  public void resetEncoders() {
		leftMaster.setSelectedSensorPosition(0, 0, 0);
  }

}
