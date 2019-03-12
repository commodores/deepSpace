/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;


public class RightHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RightHatch() {
    //Extend Hatcher and Gripper
    addSequential(new ExtendHatcher(), .1);
    addSequential(new ExtendGripper(), .1);
    
    //Drive forward veering right
    addSequential(new AutoForward(25,25));
    addSequential(new AutoTurn(-90, 13));
    addSequential(new AutoForward(20,15));

    //Turn left ~ 90 degrees
    addSequential(new AutoTurn(45,13));
    
    //Turn to hatch

    //Forward to score

    //Retract Gripper

    //Reverse

    //Turn left 90

    //Drive forward veering left

    //Turn to hatch

    //Forward to retrieve Hatch
  }
}
