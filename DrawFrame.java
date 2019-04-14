package com.myf.draw1025;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawFrame extends JPanel {

	   private Shape[] arrayShape=new Shape[9000];
	
	
		public static void main(String[] args) {
			DrawFrame frame = new DrawFrame();
			frame.showUI();
		}

		public void showUI() {
			// 创建窗体对象
			javax.swing.JFrame jf = new javax.swing.JFrame();
			jf.setSize(800, 800);
			jf.getContentPane().setBackground(Color.WHITE);//设置背景色
			jf.setTitle("画板1.0");
			jf.setDefaultCloseOperation(3);
			// 设置居住显示
			jf.setLocationRelativeTo(null);
			
			DrawMouse mouse = new DrawMouse();
			jf.setLayout(new BorderLayout());
			
			JPanel jp1= new JPanel();
			jp1.setBackground(Color.green);
			jf.add(jp1,BorderLayout.NORTH);

    //		JPanel jp2= new JPanel();
	//		jp2.setBackground(Color.white);
	//		jf.add(jp2,BorderLayout.CENTER);			
			
			String[] shape ={"直线","矩形","三角形","椭圆","任意边形","曲线","橡皮擦","迭代图像","递归"};
			for(int i=0;i<shape.length;i++){
				JButton jbu = new JButton(shape[i]);
				jp1.add(jbu);
				jbu.addActionListener(mouse);
			}
			Color[] color = {Color.RED,Color.BLUE,Color.BLACK};
			for(int i=0;i<color.length;i++){
				JButton jbu = new JButton();
				jbu.setBackground(color[i]);
				jbu.setPreferredSize(new Dimension(30, 30));
				jp1.add(jbu);
				jbu.addActionListener(mouse);
			}
			this.setBackground(Color.WHITE);
			jf.add(this, BorderLayout.CENTER);			
			
			
			jf.setVisible(true);
			
			//获取画笔对象：图形画在那个组件上，画笔就从该组件上获取
			//从窗体上获取画笔对象
		
			
			Graphics g = this.getGraphics();
			
			
			
			//给窗体添加鼠标监听器方法
			this.addMouseListener(mouse);
			this.addMouseMotionListener(mouse);

			mouse.setGr(g);
			mouse.setArrayShape(arrayShape);
			
					
		}
		
		public void paint(Graphics g)
		{
			super.paint(g);
			
			for(int i=0;i<arrayShape.length;i++)
			{
				Shape shape=arrayShape[i];
				if(shape!= null)
					shape.drawShape(g);
				else break;
			}
			
		}
}
	
	
	
	
	

