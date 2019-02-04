/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
  

  Joystick joy1 = new Joystick(0);
  JoystickButton btn1 = new JoystickButton(joy1, 1);
  JoystickButton btn2 = new JoystickButton(joy1, 2);
  JoystickButton btn3 = new JoystickButton(joy1, 3);
  JoystickButton btn4 = new JoystickButton(joy1, 4);
  JoystickButton btn5 = new JoystickButton(joy1, 5);
  JoystickButton btn6 = new JoystickButton(joy1, 6);
  JoystickButton btn7 = new JoystickButton(joy1, 7);
  JoystickButton btn8 = new JoystickButton(joy1, 8);
  JoystickButton btn9 = new JoystickButton(joy1, 9);
  JoystickButton btn10 = new JoystickButton(joy1, 10);
  JoystickButton btn11 = new JoystickButton(joy1, 11);
  JoystickButton btn12 = new JoystickButton(joy1, 12);

  Joystick arcade = new Joystick(1);
  JoystickButton arcadeBtn1 = new JoystickButton(arcade, 1);
  JoystickButton arcadeBtn2 = new JoystickButton(arcade, 2);
  JoystickButton arcadeBtn3 = new JoystickButton(arcade, 3);
  JoystickButton arcadeBtn4 = new JoystickButton(arcade, 4);
  JoystickButton arcadeBtn5 = new JoystickButton(arcade, 5);
  JoystickButton arcadeBtn6 = new JoystickButton(arcade, 6);
  JoystickButton arcadeBtn7 = new JoystickButton(arcade, 7);
  JoystickButton arcadeBtn8 = new JoystickButton(arcade, 8);
  JoystickButton arcadeBtn9 = new JoystickButton(arcade, 9);
  
  
  public OI() {
    joy1 = new Joystick(0);
    arcade = new Joystick(1);

    btn1.whenPressed(new ClimbHab3());
  }

  public Joystick getJoystick1() {
    return joy1;
  }

  public Joystick getJoystick2() {
    return arcade;
  }
}


