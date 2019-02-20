/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Spark;

public class RobotMap {
  //driveTrain devices
  public static WPI_TalonSRX driveTrainLeftMaster;
  public static WPI_TalonSRX driveTrainLeftSlave1;
  public static WPI_TalonSRX driveTrainLeftSlave2;

  public static WPI_TalonSRX driveTrainRightMaster;
  public static WPI_TalonSRX driveTrainRightSlave1;
  public static WPI_TalonSRX driveTrainRightSlave2;

  public static SpeedController ledControllerRevBlinkin;
  
  public static Solenoid motorShifter;
  
  //climber devices
  public static Solenoid rearLegLock;
  public static DoubleSolenoid frontLegSolenoid;
  public static DoubleSolenoid rearLegSolenoid;
  public static WPI_TalonSRX frontLegMotor;
  public static WPI_TalonSRX rearLegMotor;
  
  //gripper devices
  public static Solenoid solenoidHatcher;
  public static Solenoid solenoidExtender;
  
  //sensors and misc devices
  public static Compressor compressor;

  public static void init(){

    //driveTrain device initialization
    driveTrainLeftMaster = new WPI_TalonSRX(0);
    driveTrainLeftSlave1 = new WPI_TalonSRX(1);
    driveTrainLeftSlave2 = new WPI_TalonSRX(2);

    driveTrainRightMaster = new WPI_TalonSRX(4);
    driveTrainRightSlave1 = new WPI_TalonSRX(5);
    driveTrainRightSlave2 = new WPI_TalonSRX(6);

    motorShifter = new Solenoid(0);
    
    //led device initialization
    ledControllerRevBlinkin = new Spark(6);
        ledControllerRevBlinkin.setInverted(false);

    //climber device initialization
    rearLegLock = new Solenoid(1);
    rearLegSolenoid = new DoubleSolenoid(2, 3);
    frontLegSolenoid = new DoubleSolenoid(4, 5);
    

    frontLegMotor = new WPI_TalonSRX(3);
    rearLegMotor = new WPI_TalonSRX(7);
    
    //gripper device initialization
    solenoidHatcher = new Solenoid(6);
    solenoidExtender = new Solenoid(7);
    
    
    //sensors and misc device initialization
    compressor = new Compressor(0);
  }
}
