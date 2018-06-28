import javax.swing.*;
import java.awt.*;
import java.io.*;

public class questionClass extends JPanel
{
	private JTextArea qBlock;
	private JPanel forColor = new JPanel();
	Color defaultColor = forColor.getBackground();
	int qNumber;
	String question;
	
	public questionClass(String x)
	{
		question = x;
		qBlock = new JTextArea(3, 50);
		qBlock.setLineWrap(true);
		qBlock.setWrapStyleWord(true);
		qBlock.setText(question);
		qBlock.setBackground(defaultColor);
		add(qBlock);
	}
}