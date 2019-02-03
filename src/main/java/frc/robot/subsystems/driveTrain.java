/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManual;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final WPI_TalonSRX leftMotorA = RobotMap.driveTrainLeftMotorA;
  private final WPI_TalonSRX leftMotorB = RobotMap.driveTrainLeftMotorB;
  private final WPI_TalonSRX leftMotorC = RobotMap.driveTrainLeftMotorC;
  private final SpeedControllerGroup leftMotors = RobotMap.driveTrainLeftMotors;
  private final WPI_TalonSRX rightMotorA = RobotMap.driveTrainRightMotorA;
  private final WPI_TalonSRX rightMotorB = RobotMap.driveTrainRightMotorB;
  private final WPI_TalonSRX rightMotorC = RobotMap.driveTrainRightMotorC;
  private final SpeedControllerGroup rightMotors = RobotMap.driveTrainRightMotors;
  private final DifferentialDrive differentialDrive = RobotMap.driveTrainDifferentialDrive;

  private final DoubleSolenoid motorShifter = RobotMap.motorShifter;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManual());
  }

  public void drive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }
  
  public void stop() {
    differentialDrive.stopMotor();
  }
  public void highGear(){
    motorShifter.set(DoubleSolenoid.Value.kForward);
  }

  public void lowGear(){
    motorShifter.set(DoubleSolenoid.Value.kReverse);
  }

  public void turnOffSolenoids(){
    motorShifter.set(DoubleSolenoid.Value.kOff);
  }
}
