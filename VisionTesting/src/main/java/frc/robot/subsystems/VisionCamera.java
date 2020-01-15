/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionCamera extends SubsystemBase {
  /**
   * Creates a new VisionCamera.
   */

  NetworkTable table;

  public VisionCamera() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void update() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
  }

  public double getTv() { return table.getEntry("tv").getDouble(0); }

  public double getTx() { return table.getEntry("tx").getDouble(0); }

  public double getTy() { return table.getEntry("ty").getDouble(0); }

  public double getTa() { return table.getEntry("ta").getDouble(0); }
}
