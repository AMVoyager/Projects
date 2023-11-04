# Timer.java

## Overview
`Timer.java` is a versatile Java class that provides a user-friendly graphical interface for managing time intervals and executing actions at specific points in time. The class includes a `JFrame` with a start/stop button, three text fields for configuring timing parameters, and a sound notification that plays in a new window upon timer completion.

# Dependencies
- This file uses Java's built-in GUI libraries and requires no external dependencies.

## Features
- Schedule actions to run at specific times.
- Pause, resume, and cancel timers.
- Accurate time tracking with minimal resource consumption.

## Code
```java
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Timer extends Thread implements ActionListener, FocusListener {
	static ImageIcon photo = new ImageIcon("D:\\D\\buttton.jpg");
	static JFrame frame = new JFrame();
	static JTextArea hours = new JTextArea();
	static JTextArea minutes = new JTextArea();
	static JTextArea seconds = new JTextArea();
	static JLabel hrs = new JLabel("Hours");
	static JLabel mins = new JLabel("Minutes");
	static JLabel secs = new JLabel("Seconds");
	static JButton start = new JButton("Start", photo);
	static JButton stop = new JButton("Stop", photo);
	static String filePath;
	CircularProgressBar secondsmain = new CircularProgressBar();
	CircularProgressBar secondsinner = new CircularProgressBar();
	CircularProgressBar minutessmain = new CircularProgressBar();
	CircularProgressBar minutessinner = new CircularProgressBar();
	CircularProgressBar1 hoursmain = new CircularProgressBar1();
	CircularProgressBar1 hoursinner = new CircularProgressBar1();
	boolean flag = true;
	boolean fl = false;
	boolean isTimerEnd = false;

	public Timer() {
		start.setForeground(Color.WHITE);
		start.setHorizontalTextPosition(SwingConstants.CENTER);
		stop.setForeground(Color.WHITE);
		stop.setHorizontalTextPosition(SwingConstants.CENTER);
		Image backgroundImage = new ImageIcon("D:\\D\\timer.jpg").getImage();
		BackgroundPanel1 backgroundPanel1 = new BackgroundPanel1(backgroundImage);
		frame.setContentPane(backgroundPanel1);
		frame.add(hrs);
		secondsmain.setPreferredSize(new Dimension(100, 100));
		secondsinner.setPreferredSize(new Dimension(100, 100));
		hrs.setBounds(90, 39, 80, 50);
		hrs.setForeground(Color.WHITE);
		start.setForeground(Color.WHITE);
		stop.setForeground(Color.WHITE);
		hrs.setFont(new Font("FELIX TITLING", Font.BOLD, 17));
		frame.add(mins);
		mins.setBounds(184, 39, 80, 50);
		mins.setForeground(Color.WHITE);
		mins.setFont(new Font("FELIX TITLING", Font.BOLD, 17));
		frame.add(secs);
		secs.setBounds(287, 39, 90, 50);
		secs.setForeground(Color.WHITE);
		secs.setFont(new Font("FELIX TITLING", Font.BOLD, 17));
		frame.add(hours);
		hours.setBounds(110, 130, 70, 50);
		hours.setOpaque(false);
		hours.setBackground(new Color(0, 0, 0, 0));
		hours.setForeground(Color.WHITE);
		hours.setFont(new Font("ZCOOL QingKe HuangYou", Font.CENTER_BASELINE, 26));
		hoursinner.setBounds(82, 91, 75, 100);
		hoursinner.setOpaque(false);
		hoursinner.setBackground(new Color(0, 0, 0, 0));
		hoursmain.setBounds(75, 60, 90, 160);
		frame.add(minutes);
		minutes.setBounds(213, 130, 70, 50);
		minutes.setOpaque(false);
		minutes.setBackground(new Color(0, 0, 0, 0));
		minutes.setForeground(Color.WHITE);
		minutes.setFont(new Font("ZCOOL QingKe HuangYou", Font.CENTER_BASELINE, 26));
		minutessinner.setBounds(185, 91, 75, 100);
		minutessinner.setOpaque(false);
		minutessinner.setBackground(new Color(0, 0, 0, 0));
		minutessmain.setBounds(178, 60, 90, 160);
		start.setBounds(88, 230, 130, 60);
		stop.setBounds(230, 230, 130, 60);
		start.setFont(new Font("FELIX TITLING", Font.BOLD, 17));
		stop.setFont(new Font("FELIX TITLING", Font.BOLD, 17));
		frame.add(seconds);
		seconds.setBounds(313, 130, 70, 50);
		seconds.setOpaque(false);
		seconds.setBackground(new Color(0, 0, 0, 0));
		seconds.setForeground(Color.WHITE);
		seconds.setFont(new Font("ZCOOL QingKe HuangYou", Font.CENTER_BASELINE, 26));
		secondsinner.setBounds(287, 91, 75, 100);
		secondsinner.setOpaque(false);
		secondsinner.setBackground(new Color(0, 0, 0, 0));
		secondsmain.setBounds(280, 60, 90, 160);
		frame.add(start);
		start.addActionListener(this);
		frame.add(stop);
		stop.addActionListener(this);
		frame.add(secondsinner);
		frame.add(secondsmain);
		frame.add(minutessinner);
		frame.add(minutessmain);
		frame.add(hoursinner);
		frame.add(hoursmain);
		frame.setLayout(null);
		frame.setSize(500, 500);
		frame.setVisible(true);
		hours.setText(Integer.toString(0));
		minutes.setText(Integer.toString(0));
		seconds.setText(Integer.toString(0));
		minutes.addFocusListener(this);
		seconds.addFocusListener(this);
		Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
		start.setBorder(border);
		stop.setBorder(border);
		hoursmain.setProgress(24);
		minutessmain.setProgress(60);
		secondsmain.setProgress(60);

	}

	public static void main(String[] args) {
		new Timer();
	}

	int hours1 = 0, minutes1 = 0, seconds1 = 0;
	Thread thread1;
	boolean isStopClicked = true;
	boolean isTimerRunning = false;

	@Override
	public void actionPerformed(ActionEvent e) {
		hours1 = Integer.parseInt(hours.getText());
		minutes1 = Integer.parseInt(minutes.getText());
		seconds1 = Integer.parseInt(seconds.getText());
		// int i, j;
		if (e.getSource() == start) {
			if (isStopClicked) {
				start.setText("Pause");
				Runnable task1 = new Runnable() {
					@Override
					public void run() {
						isTimerRunning = true;
						start.setText("Pause");
						try {
							while (hours1 >= 0 && minutes1 >= 0 && seconds1 >= 0) {
								// Update the GUI with the current time values
								hours.setText(String.format("%02d", hours1));
								minutes.setText(String.format("%02d", minutes1));
								seconds.setText(String.format("%02d", seconds1));

								Thread.sleep(1000);
								if (seconds1 > 0) {
									seconds1--;
									seconds.setText(Integer.toString(seconds1));
									secondsmain.setProgress(seconds1);
								} else {
									if (minutes1 > 0) {
										minutes1--;
										minutes.setText(Integer.toString(minutes1 - 1));
										minutessmain.setProgress(minutes1);
										seconds1 = 59;
									} else {
										if (hours1 > 0) {
											hours1--;
											hours.setText(Integer.toString(hours1 - 1));
											minutes1 = 59;
											seconds1 = 59;
											hoursmain.setProgress(hours1);
										} else {
											// Timer has finished
											isTimerRunning = false;
										}
									}
								}
								if (!isTimerRunning) {
									start.setText("Start");
									hours.setEditable(true);
									minutes.setEditable(true);
									seconds.setEditable(true);
									hoursmain.setProgress(0);
									minutessmain.setProgress(0);
									secondsmain.setProgress(0);
									JFrame jf2 = new JFrame();
									JLabel jl = new JLabel("Timer Completed");
									JButton stop1 = new JButton("Stop");
									stop1.setBounds(166, 200, 166, 50);
									jl.setBounds(166, 166, 166, 50);
									jf2.add(jl);
									jf2.add(stop1);
									jf2.setLayout(null);
									jf2.setVisible(true);
									jf2.setSize(500, 500);
									String audioFilePath = "C:\\Users\\abhij\\Music\\melody_alarm_clock.wav";
									File audioFile = new File(audioFilePath);
									System.out.println("Loop Finished");
									try {
										AudioInputStream audioInputStream = AudioSystem
												.getAudioInputStream(audioFile);
										Clip clip = (Clip) AudioSystem
												.getLine(new DataLine.Info(Clip.class,
														audioInputStream.getFormat()));
										clip.open(audioInputStream);
										clip.start();
										stop1.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												clip.close();
												jf2.dispose();
											}
										});
									} catch (UnsupportedAudioFileException | IOException
											| LineUnavailableException e) {
										e.printStackTrace();
									}
									break;
								}
							}
						} catch (InterruptedException ex) {
							// Timer paused or stopped
						}
					}
				};
				thread1 = new Thread(task1);
				thread1.start();
			} else {
				thread1.interrupt();
				hours.setText(Integer.toString(hours1));
				minutes.setText(Integer.toString(minutes1));
				seconds.setText(Integer.toString(seconds1));
				start.setText("Start");
			}
			isStopClicked = !isStopClicked;
		}
		if (e.getSource() == stop)

		{
			hours.setText(Integer.toString(0));
			minutes.setText(Integer.toString(0));
			seconds.setText(Integer.toString(0));
			thread1.interrupt();
			hoursmain.setProgress(0);
			minutessmain.setProgress(0);
			secondsmain.setProgress(0);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == hours) {
			hours.setText(null);
		} else if (e.getSource() == minutes) {
			minutes.setText(null);
		} else if (e.getSource() == seconds) {
			seconds.setText(null);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == hours) {
			hours.setText(hours.getText());
		}
		if (e.getSource() == minutes) {
			minutes.setText(minutes.getText());
		}
		if (e.getSource() == seconds) {
			seconds.setText(seconds.getText());
		}
	}
}

class BackgroundPanel extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
