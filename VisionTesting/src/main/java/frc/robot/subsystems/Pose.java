/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import frc.robot.Robot;

/**
 * Pose will log at what current values robot has
 */
public class Pose {

    public final double time;
    public final double tv;
    public final double tx;
    public final double ty;
    public final double ta;

    public static final ArrayList<Pose> poses = new ArrayList<Pose>();
    private int lengthLimit = 20;

    public Pose(double time) {
        Robot.robotContainer.visionCamera.update();
        this.time = time;
        this.tv = Robot.robotContainer.visionCamera.getTv();
        this.tx = Robot.robotContainer.visionCamera.getTx();
        this.ty = Robot.robotContainer.visionCamera.getTy();
        this.ta = Robot.robotContainer.visionCamera.getTa();

        if (poses.size() >= lengthLimit) {
            poses.remove(0);
        }
        poses.add(this);
    }

    public static Pose getCurrentPose() {
        return poses.get(poses.size() - 1);
    }
}