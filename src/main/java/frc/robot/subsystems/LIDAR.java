/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.lib.LIDARLite;
import java.util.LinkedList;

/**
 * Add your docs here.
 */
public class LIDAR extends Subsystem {
  	LIDARLite lidar;
	
	public LIDAR() {
		lidar = new LIDARLite(0);
	}
	
	public double getDistance() {
		return lidar.getDistanceIn(true);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	
	}
}
