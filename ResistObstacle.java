import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;
import ch.aplu.robotsim.Tools;
import ch.aplu.robotsim.TouchSensor;
import ch.aplu.util.QuitPane;

public class ResistObstacle {
	public ResistObstacle()

	{
		LegoRobot robot = new LegoRobot();
		Gear g = new Gear();
		TouchSensor ts1 = new TouchSensor(SensorPort.S1);
		TouchSensor ts2 = new TouchSensor(SensorPort.S2);
		robot.addPart(g);
		robot.addPart(ts1);
		robot.addPart(ts2);
		g.forward();

		while (!QuitPane.quit()) {
			Boolean t1 = ts1.isPressed();
			Boolean t2 = ts2.isPressed();
			if (t1 && t2) {
				g.backward(500);
				g.left(400);
				g.forward();
			} else {
				if (t1) {
					g.backward(500);
					g.left(400);
					g.forward();
				} else {
					if (t2) {
						g.backward(500);
						g.right(100);
						g.forward();
					}
				}
			}
			Tools.delay(20);
		}
		robot.exit();
	}

	public static void main(String[] args) {
		new ResistObstacle();
	}

	static {
		RobotContext.setLocation(10, 10);
		RobotContext.setStartDirection(5);
		RobotContext.setStartPosition(100, 240);
		RobotContext.useObstacle(RobotContext.channel);
	}
}
