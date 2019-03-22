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
import frc.robot.Robot;

import frc.util.PIDOutputInterface;
import edu.wpi.first.wpilibj.PIDController;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public final double driveTrainGain = .015;
  

  private final WPI_TalonSRX leftMaster = RobotMap.driveTrainLeftMaster;
  private final WPI_TalonSRX rightMaster = RobotMap.driveTrainRightMaster;
  
  private final DifferentialDrive m_drive;

  //Test Limelight PID
  static double kP = 0.03;        // Start with P = 10% of your max output, double until you get a quarter-decay oscillation
	static double kI = 0;           // Start with I = P / 100
	static double kD = 0;           // Start with D = P * 10
  static double period = 0.01;

  public AHRS navX = new AHRS(SPI.Port.kMXP);
  
  public PIDOutputInterface limelightPIDOutput = new PIDOutputInterface();
  public PIDController limelightPIDController = new PIDController(kP, kI, kD, navX, limelightPIDOutput);

    
  public DriveTrain() {
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

  private double getNativeUnitsFromInches (double inches) {
    return inches*RobotMap.TICKS_PER_REVOLUTION/RobotMap.WHEEL_DIAMETER/Math.PI;
  }
  
  private double getInchesFromNativeUnits (double native_units) {
    return native_units/RobotMap.TICKS_PER_REVOLUTION*RobotMap.WHEEL_DIAMETER*Math.PI;
  }

  public double getLeftDistance() {
    return getInchesFromNativeUnits(leftMaster.getSelectedSensorPosition(0));
  }
  
  public double getRightDistance() {
    return getInchesFromNativeUnits(rightMaster.getSelectedSensorPosition(0));
  }

  public double getTotalDistance() {
    return (getLeftDistance()+getRightDistance()) / 2;
  }

  public double getAngle(){
		// Angle is negated due to that navX being upside-down on Susan
		return -navX.getAngle();
	}

	public double getYaw() {
		return navX.getYaw();
	}

	public double getRoll(){
		return navX.getRoll();
	}

	public double getPitch(){
		return navX.getPitch();
	}

	public void resetAngle(){
		navX.reset();
	}

  public synchronized void resetEncoders() {
    leftMaster.getSensorCollection().setQuadraturePosition(0, 10);
    leftMaster.setSelectedSensorPosition(0, 0, 10);
    rightMaster.getSensorCollection().setQuadraturePosition(0, 10);
    rightMaster.setSelectedSensorPosition(0, 0, 10);
    Robot.m_driveTrain.resetAngle();    
  }

}
