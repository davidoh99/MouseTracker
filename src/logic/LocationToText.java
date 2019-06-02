package logic;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class LocationToText extends TimerTask{
	private Robot robot;
	
	private static FileOutputStream instantiateFOS() {		 
		try {
			FileOutputStream fos = new FileOutputStream("c://MouseTracker//test.txt");
			return fos;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Error with instantiating the FileOutputStream.");
		return null;
	}
	
	public void run() {		
		FileOutputStream fos = instantiateFOS();
		Point p;
		p = MouseInfo.getPointerInfo().getLocation();
		
		StringBuilder sb = new StringBuilder();
		sb.append(p.x);
		sb.append(" ");
		sb.append(p.y);
		sb.append("\n");
		
		try {
			fos.write(sb.toString().getBytes());
		} catch (IOException e) {
			System.out.println("Error writing data.");
		}
		
		try {
			Thread.sleep(8);
		} catch (InterruptedException e1) {
			System.out.println("Problem sleeping thread.");
		}
	}	
}
