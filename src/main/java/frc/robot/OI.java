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

  Joystick leftArcade = new  Joystick(1);

  Joystick rightArcade = new Joystick(2);
  JoystickButton arcadeBtn1 = new JoystickButton(rightArcade, 1);
  JoystickButton arcadeBtn2 = new JoystickButton(rightArcade, 2);
  JoystickButton arcadeBtn3 = new JoystickButton(rightArcade, 3);
  JoystickButton arcadeBtn4 = new JoystickButton(rightArcade, 4);
  JoystickButton arcadeBtn5 = new JoystickButton(rightArcade, 5);
  JoystickButton arcadeBtn6 = new JoystickButton(rightArcade, 6);
  JoystickButton arcadeBtn7 = new JoystickButton(rightArcade, 7);
  JoystickButton arcadeBtn8 = new JoystickButton(rightArcade, 8);
  JoystickButton arcadeBtn9 = new JoystickButton(rightArcade, 9);
  
  
  public OI() {
    joy1 = new Joystick(0);
    leftArcade = new Joystick(1);
    rightArcade = new Joystick(2);

    btn1.whenPressed(new ExtendHatcher());
    btn2.whenPressed(new RetractHatcher());
    btn3.whenPressed(new LowGear());
    btn4.whenPressed(new HighGear());
    btn5.whenPressed(new ExtendGripper());
    btn6.whenPressed(new RetractGripper());
    btn7.whenPressed(new ExtendLock());
    btn8.whenPressed(new RetractLock()); 
    btn9.whileHeld(new AllWheelsFwd());
    btn10.whileHeld(new AllWheelsRev());

    
    arcadeBtn1.whenPressed(new ExtendFrontLeg());
    arcadeBtn2.whenPressed(new ExtendBothLegs());
    arcadeBtn3.whenPressed(new ExtendRearLeg());
    arcadeBtn4.whenPressed(new RetractFrontLeg());
    arcadeBtn5.whenPressed(new RetractBothLegs());
    arcadeBtn6.whenPressed(new RetractRearLeg());
    //arcadeBtn7.whenPressed(new ExtendFlipper());
    //arcadeBtn8.whenPressed(new RetractFlipper());
    

  }

  public Joystick getJoystick1() {
    return joy1;
  }

  public Joystick getJoystick2() {
    return leftArcade;
  }

  public Joystick getJoystick3() {
    return rightArcade;
  }
}


