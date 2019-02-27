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
import edu.wpi.first.wpilibj.DMC60;

public class RobotMap {
  //driveTrain devices
  public static WPI_TalonSRX driveTrainLeftMaster;
  public static WPI_TalonSRX driveTrainLeftSlave1;
  public static WPI_TalonSRX driveTrainLeftSlave2;

  public static WPI_TalonSRX driveTrainRightMaster;
  public static WPI_TalonSRX driveTrainRightSlave1;
  public static WPI_TalonSRX driveTrainRightSlave2;

  public static SpeedController ledControllerRevBlinkin;
  
  public static DoubleSolenoid motorShifter;
  
  //climber devices
  public static Solenoid rearLegLock;
  public static DoubleSolenoid frontLegSolenoid;
  public static DoubleSolenoid rearLegSolenoid;
  public static WPI_TalonSRX frontLegMotor;
  public static WPI_TalonSRX rearLegMotor;
  
  //gripper devices
  public static DoubleSolenoid solenoidHatcher;
  public static DoubleSolenoid solenoidExtender;
  
  //sensors and misc devices
  public static Compressor compressor;

  //Flipper device
  public static DMC60 flipperDmc60;

  public static void init(){

    //driveTrain device initialization
    driveTrainLeftMaster = new WPI_TalonSRX(0);
    driveTrainLeftSlave1 = new WPI_TalonSRX(1);
    driveTrainLeftSlave2 = new WPI_TalonSRX(2);

    driveTrainRightMaster = new WPI_TalonSRX(4);
    driveTrainRightSlave1 = new WPI_TalonSRX(5);
    driveTrainRightSlave2 = new WPI_TalonSRX(6);

    //motorShifter = new Solenoid(0);
    motorShifter = new DoubleSolenoid(2, 3);
    
    //led device initialization
    ledControllerRevBlinkin = new Spark(6);
        ledControllerRevBlinkin.setInverted(false);

    //climber device initialization
    //rearLegLock = new Solenoid(1);
    //rearLegSolenoid = new DoubleSolenoid(2, 3);
    //frontLegSolenoid = new DoubleSolenoid(4, 5);
    

    frontLegMotor = new WPI_TalonSRX(3);
    rearLegMotor = new WPI_TalonSRX(7);
    
    //gripper device initialization
    solenoidExtender = new DoubleSolenoid(4,5);
    solenoidHatcher = new DoubleSolenoid(6,7);
    
    
    //sensors and misc device initialization
    compressor = new Compressor(0);

    //FLipper device initialization
    flipperDmc60 = new DMC60(0);
  }
}
