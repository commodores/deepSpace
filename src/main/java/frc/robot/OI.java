/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
  

  Joystick joy1 = new Joystick(0);
  Joystick joy2 = new Joystick(1);

  
  
  public OI() {
    joy1 = new Joystick(0);
    joy2 = new Joystick(1);
  }

  public Joystick getJoystick1() {
    return joy1;
  }

  public Joystick getJoystick2() {
    return joy2;
  }
}


