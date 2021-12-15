import java.util.Scanner;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.NxtRobot;
import ch.aplu.robotsim.Tools;

public class Square {
	
	Square(){
		String dir;
		NxtRobot r = new NxtRobot();
		Gear g = new Gear();
		r.addPart(g);
		g.setSpeed(100);
		while(true)
		{
			Scanner S = new Scanner(System.in);
			System.out.println("Enter the direction: ");
			dir = S.nextLine();
			if (dir.equals("left"))
			{
				g.forward(1000);
				g.left(270);
				g.forward(1000);
			}
			else if(dir.equals("right"))
			{
				g.forward(1000);
				g.right(270);
				g.forward(1000);
			}
			else {
				r.exit();
			}
		}
	}
	

	
	public static void main(String[] args) {
		new Square();
	}

}
