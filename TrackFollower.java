import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;

public class TrackFollower {

	public TrackFollower() {
		LegoRobot legoRobot = new LegoRobot();
		Gear gear = new Gear();
		LightSensor lightSensor = new LightSensor(SensorPort.S3);
		legoRobot.addPart(lightSensor);
		legoRobot.addPart(gear);
		while (true) {
			int p = lightSensor.getValue();
			if (p == 1000) {
				gear.forward();
			}
			if (p > 50 && p < 1000) {
				gear.rightArc(0.08);
			}
			System.out.println("Sensor Val:" + p);
			if (p == 0) {
				gear.stop();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TrackFollower();
	}

	static {
		RobotContext.setStartPosition(80, 452);
		RobotContext.useBackground("sprites/track.PNG");
	}

}
