package org.mort11.library.Hardware.Brands.LimeLight;

import org.mort11.library.Hardware.Camera.TagCameraIntf;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLightTagCamera implements TagCameraIntf {

    public NetworkTable cameraTable;

    public String cameraName;

    public LimeLightTagCamera (String cameraName) {
        this.cameraName = cameraName;

        cameraTable = NetworkTableInstance.getDefault().getTable("limelight-" + cameraName);
    }

    public boolean hasTag () {
        return cameraTable.getEntry("").getBoolean(false);
    }

    public int getId() {
		if(hasTag()){
			return (int) cameraTable.getEntry("tid").getInteger(-1);
		}
		return -1;
		
	}

    public Pose2d getRobotPosition() {
		double[] poseNums = new double[6];
		
		poseNums = cameraTable.getEntry("botpose_wpiblue").getDoubleArray(new double[6]);

		return new Pose2d(poseNums[0], poseNums[1], new Rotation2d(Math.toRadians(poseNums[5])));
	}

    public Pose3d get3dRobotPosition() {
        double[] poseNums = new double[6];

        poseNums = cameraTable.getEntry("botpose_wpiblue").getDoubleArray(new double[6]);

        return new Pose3d(
            new Translation3d(poseNums[0], poseNums[1], poseNums[2]), 
            new Rotation3d(Math.toRadians(poseNums[3]), Math.toRadians(poseNums[4]), Math.toRadians(poseNums[5]))
        );
    }

    public void setRobotOrientation (double yaw, double yawRate) {
        double[] positionArray = {yaw, yawRate, 0, 0, 0, 0};
        cameraTable.getEntry("robot_orientation_set").setDoubleArray(positionArray);
    }

    public String getCameraName () {
        return cameraName;
    }
    
}