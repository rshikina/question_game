import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class enterClass extends JPanel
{
	private JPanel panel;
	private JPanel nextPanel;
	private JButton enter;
	private JLabel verify;
	private JButton next;
	private char getSelected;
	public enterClass(char x)
	{
		panel = new JPanel();
		getSelected = x;
		setLayout(new GridLayout(3,1));
		enter = new JButton("Enter");
		enter.addActionListener(new click());
		verify = new JLabel();
		nextPanel = new JPanel();
		next = new JButton("Go to next question.");
		next.addActionListener(new nextPage());
		panel.add(enter);
		add(panel);
		add(verify);
		add(nextPanel);
		
	}		
	private class click implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String action = e.getActionCommand();
			char letter = action.charAt(0);
			if(letter == getSelected.charAt(0))
				verify.setText("That's correct.");
			else
				verify.setText("Wrong.");
			add(verify);
			nextPanel.add(next);
			add(nextPanel);
		}
	}
	private class nextPage implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				arrayBuilder();
				getContentPane().removeAll();
				getContentPane().add(questionPanel, BorderLayout.NORTH);
				getContentPane().add(answerPanel, BorderLayout.CENTER);
				getContentPane().add(enterPanel, BorderLayout.SOUTH);
				getContentPane().revalidate();
				getContentPane().repaint();
				pack();
				setVisible(true);
			}
			catch (IOException p)
			{
				p.printStackTrace();
			}
		}	
	}
}