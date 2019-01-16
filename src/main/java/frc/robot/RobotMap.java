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
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

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
  }
}
