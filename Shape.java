package com.myf.draw1025;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
     private int x1,y1,x2,y2,x,y;
	 private String name;
	 private Color color;

	 

	 
	 
	 public Shape(int x1,int y1,int x2,int y2,String name,Color color)
	 {
		 this.x1=x1;
		 this.y1=y1;
		 this.x2=x2;
		 this.y2=y2;
		 this.name=name;
		 this.color=color;
	 }
	
	 public void drawShape(Graphics g)
	 {
		 switch(name)
		 {
		 case "Ö±Ïß":
			 g.setColor(color);
			 g.drawLine(x1, y1, x2, y2);
			// System.out.println("»­");
			 break;
		 case "¾ØÐÎ":
			 g.setColor(color);
			 g.drawRect(x1, y1, x2, y2);
			 break;
		 case "ÍÖÔ²":
			 g.setColor(color);
			 g.drawOval(x1, y1, x2, y2);
			 break;		
		 case "ÏðÆ¤²Á":
			 g.setColor(color);
			 g.clearRect(x1, y1, x2, y2);
			 break;		 
		 }
		 
		 
		 
	 }
	   
	 
	
	
}
