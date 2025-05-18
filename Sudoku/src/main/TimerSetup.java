package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TimerSetup {
	
	public static void TimerSet() {
        int delay = 1000;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	Launcher.seconds++;
            	if (Launcher.seconds >= 60) {
            		Launcher.minutes++;
            		Launcher.seconds -= 60;
            	}
            	if (Launcher.minutes >= 60) {
            		Launcher.hours++;
            		Launcher.minutes -= 60;
            	}
            	String hoursTime = String.format("%02d", Launcher.hours);
            	String minutesTime = String.format("%02d", Launcher.minutes);
            	String secondsTime = String.format("%02d", Launcher.seconds);
            	Launcher.timerLabel.setText(hoursTime + ":" + minutesTime + ":" + secondsTime);
            }
        };
        Launcher.timer = new Timer(delay, taskPerformer);
        Launcher.timer.start();
	}
}
