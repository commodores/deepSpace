/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.MyLimeLight_get_Data;
import frc.robot.commands.myLimeLight_Toggle_CamMode;
import frc.robot.commands.myLimeLight_Toggle_LED;
import frc.robot.commands.myLimeLight_Toggle_Snapshot;
import frc.robot.commands.myLimeLight_Toggle_Stream;
import frc.robot.commands.myLimeLight_set_Pipeline;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
  

  Joystick joy1 = new Joystick(0);
  Joystick joy2 = new Joystick(1);

  a = new JoystickButton(myJoystick, 1);
        a.whileHeld(new MyLimeLight_get_Data());


        // SmartDashboard Buttonss
        SmartDashboard.putData("MyLimeLight_get_Data", new MyLimeLight_get_Data());
        SmartDashboard.putData("myLimeLight_set_Pipeline(0)", new myLimeLight_set_Pipeline(0));
        SmartDashboard.putData("myLimeLight_set_Pipeline(1)", new myLimeLight_set_Pipeline(1));
        SmartDashboard.putData("myLimeLight_Toggle_CamMode", new myLimeLight_Toggle_CamMode());
        SmartDashboard.putData("myLimeLight_Toggle_LED", new myLimeLight_Toggle_LED());
        SmartDashboard.putData("myLimeLight_Toggle_Snapshot", new myLimeLight_Toggle_Snapshot());
        SmartDashboard.putData("myLimeLight_Toggle_Stream", new myLimeLight_Toggle_Stream());
  
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
