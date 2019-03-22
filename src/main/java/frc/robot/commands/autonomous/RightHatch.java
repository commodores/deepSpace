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
    //Drive forward veering right
    addSequential(new VeerRight());
    addSequential(new AutoTurn(-90,3));

    //Turn to hatch
    addSequential(new AlignToTarget());

    //Extend Hatcher and Gripper
    addSequential(new ExtendHatcher(),.1);
    addSequential(new ExtendGripper(),.1);
  
    //Forward to score
    addSequential(new DriveFwdToHatch(3));
    //Retract Gripper
    addSequential(new RetractGripper(), .1);

    //Reverse
    addSequential(new AutoReverse(16,3));
  }
}
