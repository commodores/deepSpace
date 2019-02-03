/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.lib.LIDARLite;
import edu.wpi.first.wpilibj.Compressor;

public class RobotMap {
  //driveTrain devices
  public static WPI_TalonSRX driveTrainLeftMotorA;
  public static WPI_TalonSRX driveTrainLeftMotorB;
  public static WPI_TalonSRX driveTrainLeftMotorC;
  public static SpeedControllerGroup driveTrainLeftMotors;
  public static WPI_TalonSRX driveTrainRightMotorA;
  public static WPI_TalonSRX driveTrainRightMotorB;
  public static WPI_TalonSRX driveTrainRightMotorC;
  public static SpeedControllerGroup driveTrainRightMotors;
  public static DifferentialDrive driveTrainDifferentialDrive;
  
  public static DoubleSolenoid motorShifter;
  
  //climber devices
  public static DoubleSolenoid frontLegSolenoid;
  public static DoubleSolenoid rearLegSolenoid;
  public static WPI_TalonSRX frontLegMotor;
  public static WPI_TalonSRX rearLegMotor;
  
  //gripper devices
  public static Solenoid solenoidHatcher;
  public static Solenoid solenoidExtender;

  //sensors and misc devices
  public static AHRS gyro;
  public static LIDARLite lidar;
  public static Compressor compressor;

  public static void init(){

    //driveTrain device initialization
    driveTrainLeftMotorA = new WPI_TalonSRX(0);
    driveTrainLeftMotorB = new WPI_TalonSRX(1);
    driveTrainLeftMotorC = new WPI_TalonSRX(2);
    driveTrainLeftMotors = new SpeedControllerGroup(driveTrainLeftMotorA, driveTrainLeftMotorB, driveTrainLeftMotorC);

    driveTrainRightMotorA = new WPI_TalonSRX(3);
    driveTrainRightMotorB = new WPI_TalonSRX(4);
    driveTrainRightMotorC = new WPI_TalonSRX(5);
    driveTrainRightMotors = new SpeedControllerGroup(driveTrainRightMotorA, driveTrainRightMotorB, driveTrainRightMotorC);

    driveTrainDifferentialDrive = new DifferentialDrive(driveTrainLeftMotors, driveTrainRightMotors);
      driveTrainDifferentialDrive.setSafetyEnabled(false);
      driveTrainDifferentialDrive.setExpiration(0.1);
      driveTrainDifferentialDrive.setMaxOutput(1.0);

    motorShifter = new DoubleSolenoid(0, 1);

    //climber device initialization
    frontLegSolenoid = new DoubleSolenoid(2, 3);
    rearLegSolenoid = new DoubleSolenoid(4, 5);

    frontLegMotor = new WPI_TalonSRX(6);
    rearLegMotor = new WPI_TalonSRX(7);
    
    //gripper device initialization
    solenoidHatcher = new Solenoid(6);
    solenoidExtender = new Solenoid(7);
    
    //sensors and misc device initialization    
    gyro = new AHRS(SPI.Port.kMXP);
    lidar = new LIDARLite(0);
    compressor = new Compressor(0);
  }
}
