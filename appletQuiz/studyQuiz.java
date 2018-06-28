import java.util.Enumeration;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class studyQuiz extends JApplet
{
	private questionClass questionPanel;
	private answerClass answerPanel;
	private enterClass enterPanel;
	private int total, correct, wrong = 0;
	String answer;
	String mainAns1;
	String mainAns2;
	String mainAns3;
	String mainAns4;
	String mainQuestion;
	String mainArray[][] = new String[400][5];
	char mainAnswer;
	
	pickerC one;
	int ticket;
		
	public void init()
	{
		setLayout(new BorderLayout());
		
		arrayBuilder();
				
		add(questionPanel, BorderLayout.NORTH);
		add(answerPanel, BorderLayout.CENTER);
		add(enterPanel, BorderLayout.SOUTH);
	}
	public void arrayBuilder()
	{
		ticket = generator();
		mainArray = testBuilder.build();
		mainQuestion = mainArray[ticket][0];
		mainAns1 = mainArray[ticket][1];
		mainAns2 = mainArray[ticket][2];
		mainAns3 = mainArray[ticket][3];
		mainAns4 = mainArray[ticket][4];
		mainAnswer = mainQuestion.charAt((char)0);
		
		questionPanel = new questionClass(mainQuestion.substring(1));
		answerPanel = new answerClass(mainAns1, mainAns2, mainAns3, mainAns4);
		enterPanel = new enterClass(mainAnswer);
	}
	public int generator()
	{
		one = new pickerC();
		return one.numPicker();
	}
	public class enterClass extends JPanel
	{
		private JPanel panel;
		private JPanel nextPanel;
		private JButton enter;
		private JLabel verify;
		private JLabel correctAns;
		private JButton next;
		private char getSelected;
		public enterClass(char x)
		{
			panel = new JPanel();
			getSelected = x;
			setLayout(new GridLayout(4,1));
			enter = new JButton("Enter");
			enter.addActionListener(new click());
			verify = new JLabel();
			correctAns = new JLabel();
			next = new JButton("Go to next question.");
			next.addActionListener(new nextPage());
			panel.add(enter);
			add(panel);
			add(verify);
			add(correctAns);
		}
		private class click implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				total++;
				Enumeration<AbstractButton> allRadioButton=answerPanel.getButtGroup().getElements();
				while(allRadioButton.hasMoreElements())
				{
					JRadioButton temp = (JRadioButton)allRadioButton.nextElement();
					if(temp.isSelected())
					{
						String ansLetter = temp.getText();
						char letter = ansLetter.charAt(0);
						if(letter == getSelected)
						{
							verify.setText("That's correct.");
							correct++;
						}
						else
						{
							verify.setText("Wrong.");
							wrong++;
							switch(getSelected)
							{
								case 'a':
									correctAns.setText(mainAns1);
									break;
								case 'b':
									correctAns.setText(mainAns2);
									break;
								case 'c':
									correctAns.setText(mainAns3);
									break;
								default:
									correctAns.setText(mainAns4);
							}	
						}
						add(verify);
						add(correctAns);
						panel.removeAll();
						panel.add(next);	
						panel.repaint();
					}
				}
			}
		}
	}
	private class nextPage implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
				arrayBuilder();
				getContentPane().removeAll();
				getContentPane().add(questionPanel, BorderLayout.NORTH);
				getContentPane().add(answerPanel, BorderLayout.CENTER);
				getContentPane().add(enterPanel, BorderLayout.SOUTH);
				getContentPane().revalidate();
				getContentPane().repaint();
				
				setVisible(true);
				System.out.println(correct + " out of " + total + "correct.");
			}
		}	
	}