import javax.swing.*;
import java.awt.*;

public class answerClass extends JPanel
{
	private JRadioButton ans1;
	private JRadioButton ans2;
	private JRadioButton ans3;
	private JRadioButton ans4;
	private ButtonGroup mainGroup;
	
	public answerClass(String a, String b, String c, String d)
	{
			setLayout(new GridLayout(4,1));
			
			ans1 = new JRadioButton(a);
			ans2 = new JRadioButton(b);
			ans3 = new JRadioButton(c);
			ans4 = new JRadioButton(d);
			mainGroup = new ButtonGroup();
			mainGroup.add(ans1);
			mainGroup.add(ans2);
			mainGroup.add(ans3);
			mainGroup.add(ans4);
			add(ans1);
			add(ans2);
			add(ans3);
			add(ans4);
	}
	public ButtonGroup getButtGroup()
	{	
		return mainGroup;
	}
}