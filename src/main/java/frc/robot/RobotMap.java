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
//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.lib.LIDARLite;
import edu.wpi.first.wpilibj.Compressor;

public class RobotMap {
  public static WPI_TalonSRX driveTrainLeftMotorA;
  public static WPI_TalonSRX driveTrainLeftMotorB;
  public static WPI_TalonSRX driveTrainLeftMotorC;
  public static SpeedControllerGroup driveTrainLeftMotors;
  public static WPI_TalonSRX driveTrainRightMotorA;
  public static WPI_TalonSRX driveTrainRightMotorB;
  public static WPI_TalonSRX driveTrainRightMotorC;
  public static SpeedControllerGroup driveTrainRightMotors;
  public static DifferentialDrive driveTrainDifferentialDrive;

  //public static ADXRS450_Gyro gyro;
  public static AHRS gyro;
  public static DigitalInput lidarPort;
  public static LIDARLite lidar;
  public static Compressor compressor;

  public static void init(){
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

    lidarPort = new DigitalInput(0);
    lidar = new LIDARLite(lidarPort);
    compressor = new Compressor(0);
    gyro = new AHRS(SPI.Port.kMXP);
  }
}
