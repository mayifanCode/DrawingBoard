package com.myf.draw1025;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

public class DrawMouse implements MouseListener, ActionListener,MouseMotionListener {
	private Graphics gr;
	private int x1, y1, x2, y2, x3, y3;
	private double x;
	private double y;	
	private int xf,yf,xl,yl,x0,y0;
	private String name;
    private int flag=0;
    private int flagq=0;
    private int step=1;
    private int flag_line=0;
    private Color color = Color.black;
    private double a=-1.2;
    private double b=1.6;
    private double c=-1;
    private double d=-1.5;
    private int index=0;
    private Shape[] arrayShape;
	public void setGr(Graphics g) {
		gr = g;
	}

	public void setArrayShape(Shape[] arrayShape)
	{
		this.arrayShape=arrayShape;
	}
	
	public void mouseClicked(MouseEvent e) {

		
		if ("�������".equals(name)){
			if(flag==0)
			{
				x0 = e.getX();
				y0 = e.getY();
				xf = e.getX();
				yf = e.getY();				
				flag=1;
			}
			else
			{
				xl = e.getX();
				yl = e.getY();
				gr.drawLine(xf, yf, xl, yl);
				set_shape(xf, yf, xl, yl,"ֱ��",color);
				xf=xl;
			    yf=yl;
				if(e.getClickCount()==2)
				{
					flag=0;
					gr.drawLine(x0, y0, xl, yl);
					set_shape(x0, y0, xl, yl,"ֱ��",color);
				}
			}
			
		}
		if("������".equals(name)){
			System.out.println(step); 
			   switch(step)
			   {
			   case 1:
				   x1=e.getX();
				   y1=e.getY();
				   step++;
				   break;
			   case 2:
				   x2=e.getX();
				   y2=e.getY();
				   gr.drawLine(x1, y1, x2, y2);
				   step++;
			       break;
			   case 3:
				   x3=e.getX();
				   y3=e.getY();
				   set_shape(x1,y1,x2,y2,"ֱ��",color);
				   set_shape(x2,y2,x3,y3,"ֱ��",color);
				   set_shape(x1,y1,x3,y3,"ֱ��",color);
				   step=1;
				   gr.drawLine(x2, y2, x3, y3);
				   gr.drawLine(x1, y1, x3, y3);
				   break;		   
			   default:;
			   }
			 
			   
		}
		if("����ͼ��".equals(name))
		{
			x=e.getX();
			y=e.getY();
			iterate(x,y); 
			//set_shape((int)x, (int)y, 0, 0,"����ͼ��",color);
		}
		if("�ݹ�".equals(name))
		{
			  int xa=1+(int)(Math.random()*800);
			  int ya=1+(int)(Math.random()*800);
			  int xb=1+(int)(Math.random()*800);
			  int yb=1+(int)(Math.random()*800);
			  int xc=1+(int)(Math.random()*800);
			  int yc=1+(int)(Math.random()*800);
			  int xp=1+(int)(Math.random()*800);			  
			  int yp=1+(int)(Math.random()*800);		
			  int turn=1;
			  System.out.println("xa"+xa+"ya"+ya+"xb"+xb+"yb"+yb+"xc"+xc+"yc"+yc+"xp"+xp+"yp"+yp);
			  for(int i=0;i<10000;i++)
			  {
				  turn=1+(int)(Math.random()*3);
				  switch(turn)
				  {
				  case 1:
					  
					  xp=(xa+xp)/2;
					  yp=(ya+yp)/2;
					  gr.drawLine(xp, yp, xp, yp);
					  break;
				  case 2:
					  
					  xp=(xb+xp)/2;
					  yp=(yb+yp)/2;
					  gr.drawLine(xp, yp, xp, yp);					  
					  break;
				  case 3:
					  
					  xp=(xc+xp)/2;
					  yp=(yc+yp)/2;
					  gr.drawLine(xp, yp, xp, yp);				  
					  break	;			  
				  }
				  
				  
			  }
			
			
			
		}
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("����");
		if("����".equals(name)||"��Բ".equals(name))
		{
		x1 = e.getX();
		y1 = e.getY();
		}
		//System.out.println(name);
    	if ("����".equals(name))
    	{
    		flagq=1;
    		//System.out.println(flagq);
    		xf=e.getX();
    		yf=e.getY();
    	}
    	if("ֱ��".equals(name))
    	{
    		x0=e.getX();
    		y0=e.getY();    		
    		x1=e.getX();
    		y1=e.getY();   		
    		flag_line=1;
    		
    	}
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("�ͷ�");
		
		if("����".equals(name)||"��Բ".equals(name))
		{
		x2 = e.getX();
		y2 = e.getY();
		}
		/*if ("ֱ��".equals(name)) {
			// ����
			gr.drawLine(x1, y1, x2, y2);
		}*/
		if ("����".equals(name)) {
			gr.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			set_shape(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2),"����",color);
    		
		}
		if("��Բ".equals(name)){
			gr.drawOval(Math.min(x1, x2),Math.min(y1, y2), Math.abs(x1-x2),Math.abs(y1-y2));
			set_shape(Math.min(x1, x2),Math.min(y1, y2), Math.abs(x1-x2),Math.abs(y1-y2),"��Բ",color);    		
		}
    	if ("����".equals(name))
    	{
    		flagq=0;
    		System.out.println(flagq);
    	}
    	if("ֱ��".equals(name))
    	{
    		flag_line=0;
			set_shape(x0,y0,x2,y2,"ֱ��",color);
    	}
		
		
	}

	public void mouseEntered(MouseEvent e) {
		//System.out.println("����");

	}

	public void mouseExited(MouseEvent e) {
		//System.out.println("�˳�");

	}

	public void actionPerformed(ActionEvent e) {
		
		
		if("".equals(e.getActionCommand())){
			//��ȡ��ǰ�¼�Դ
			JButton jbu = (JButton)e.getSource();
			//��ȡ��ť�ı���ɫ
			color = jbu.getBackground();
			//���û�����ɫ
			gr.setColor(color);
		}else{
			// ��ȡ��ť����
			name = e.getActionCommand();
		}
		
		System.out.println("name = " + name);
	}
	
    public void mouseDragged(MouseEvent e)
    {
    	//System.out.print("x����:"+e.getX()+"  y����:"+e.getY());
    	if (flagq==1)
    	{
    		xl=e.getX();
    		yl=e.getY();
    		gr.drawLine(xf, yf, xl, yl);
    		set_shape(xf, yf, xl, yl,"ֱ��",color);
    		xf=xl;
    		yf=yl;
    	}
    	if("��Ƥ��".equals(name))
    	{

    		x1=e.getX();
    		y1=e.getY(); 
    		gr.setColor(Color.white);
    		gr.fillRect(x1-5, y1-5, 10, 10);
    		gr.setColor(color); 
    		//gr.clearRect(x1-5, y1-5, 10, 10);
    		set_shape(x1-5, y1-5, 10, 10,"��Ƥ��",color);
  		
    	}
    	if("ֱ��".equals(name)&&flag_line==1)
    	{
    		x2=e.getX();
    		y2=e.getY();
    		gr.setColor(Color.white);
    		gr.drawLine(x0, y0, x1, y1);
    		
    	    
			gr.setColor(color);  		
    		
    		gr.drawLine(x0, y0, x2, y2);
    		
    		x1=x2;
    		y1=y2;
    		
    	}
  	
    }
    public void mouseMoved(MouseEvent e)
    {
    	//System.out.print("��궯");
    }
	
	public void set_shape(int x1,int y1,int x2,int y2,String name,Color color)
	{
		
   		Shape shape=new Shape(x1,y1,x2,y2,name,color);   		
	  		
		arrayShape[index++] = shape;
		
	}
 
   public void iterate(double x,double y)
   {
	   System.out.println("��ӡ");
	   for(int i=0;i<25500;i++)
		 {         
			 double temx= Math.sin(a*y)+c*Math.cos(a*x); 			 
			 double temy=Math.sin(b*x)+d*Math.cos(b*y);              
			 int x1= (int)(temx*130+400);          //��x1,y1ת�ͣ��Ŵ��ƶ�����Ļ����ϵ
			 int y1= (int)(temy*130+400);  
			 //System.out.println("x1: "+x1+" y1: "+y1);           //��ɫ����������������         
			 gr.setColor(new Color(i/200,0,i/100));    
			 gr.drawLine(x1, y1, x1,y1);       
			 x=temx;           
			 y=temy;			 
		}
   }
  
	
	

}