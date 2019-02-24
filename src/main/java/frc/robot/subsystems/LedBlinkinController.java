/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class LedBlinkinController extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final SpeedController revBlinkin = RobotMap.ledControllerRevBlinkin;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setBlue() {
    revBlinkin.set(.61);
  }
  
  public void setGreen() {
    revBlinkin.set(.77);
  }
  
  public void setRainbow() {
    revBlinkin.set(-0.97);
  }
  
  public void set4C() {
    revBlinkin.set(.53);
  }

  public void setColorWaves(){
    revBlinkin.set(-.39);
  } 
  
  public void setRed(){
    revBlinkin.set(-.17);
  }

  public void setGold(){
    revBlinkin.set(-.07);
  }
}
