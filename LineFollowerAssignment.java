import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;

public class LineFollowerAssignment {

	public LineFollowerAssignment() {
		LegoRobot legoRobot = new LegoRobot();
		LightSensor lightSensor1 = new LightSensor(SensorPort.S1);
		LightSensor lightSensor2 = new LightSensor(SensorPort.S2);
		Gear gear = new Gear();
		gear.setSpeed(60);
		legoRobot.addPart(gear);
		legoRobot.addPart(lightSensor1);
		legoRobot.addPart(lightSensor2);
		gear.forward();

		while (true) 
		{
			int rightValue = lightSensor1.getValue();
			int leftValues = lightSensor2.getValue();
			int d = rightValue - leftValues;

			if (d > 100) {
				gear.rightArc(0.1);
			}
			if (d < -100) {
				gear.leftArc(0.1);
			}
			if (d > -100 && d < 100 && rightValue > 500) {
				gear.forward();
			}
		}
	}

	public static void main(String[] args) {
		new LineFollowerAssignment();
	}

	static {
		RobotContext.setStartPosition(250, 490);
		RobotContext.setStartDirection(-90);
		RobotContext.useBackground("sprites/path.gif");
	}
}
