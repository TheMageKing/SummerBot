// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DrivetrainSubsystem extends SubsystemBase {
  private WPI_TalonFX frontRightFalconMotor = new WPI_TalonFX(-1);
  private WPI_TalonFX frontLeftFalconMotor = new WPI_TalonFX(-7);
  private WPI_TalonFX backRightFalconMotor = new WPI_TalonFX(-1);
  private WPI_TalonFX backLeftFalconMotor = new WPI_TalonFX(-1);

  private DifferentialDrive differentialDrive = 
      new DifferentialDrive(frontLeftFalconMotor, frontRightFalconMotor);  
  
  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    setupMotors();
  }

  /**
   * Configure all the motors to our ideal setup
   */
  private void setupMotors(){
    frontRightFalconMotor.configFactoryDefault();
    frontLeftFalconMotor.configFactoryDefault(); 
    backRightFalconMotor.configFactoryDefault();
    backLeftFalconMotor.configFactoryDefault();

    backRightFalconMotor.follow(frontRightFalconMotor);
    backLeftFalconMotor.follow(frontLeftFalconMotor);
  }
  
  /**
   * Drive the robot using arcade drive
   * Arcade drive does square the inputs. 
   * @param speed how fast the robot moves
   * @param rotation how the robot turns
   */
  public void arcadeDrive(double speed, double rotation){
    differentialDrive.arcadeDrive(speed, rotation, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
