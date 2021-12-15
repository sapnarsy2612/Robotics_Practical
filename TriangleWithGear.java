import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.NxtRobot;

public class TriangleWithGear {
	public TriangleWithGear() {
		NxtRobot a = new NxtRobot();
		Gear g = new Gear();
		a.addPart(g);
		g.setSpeed(40);
		for (int i = 0; i < 3; i++) {
			g.forward(3000);
			g.left(1000);
		}
		a.exit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TriangleWithGear();

	}

}
