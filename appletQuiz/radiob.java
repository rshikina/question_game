import javax.swing.*;
import java.awt.*;

public class radiob extends JApplet
{
	public radiob()
	{
		JPanel panel = new JPanel();
		JRadioButton one = new JRadioButton("one", true);
		JRadioButton two = new JRadioButton("two");
		JRadioButton three = new JRadioButton("three");
		
		ButtonGroup group = new ButtonGroup();
		group.add(one);
		group.add(two);
		group.add(three);
		
		panel.add(one);
		panel.add(two);
		panel.add(three);
		add(panel);
	}
	public static void main(String[]args)
	{
		new radiob();
	}
}