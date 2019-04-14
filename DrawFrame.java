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
			// �����������
			javax.swing.JFrame jf = new javax.swing.JFrame();
			jf.setSize(800, 800);
			jf.getContentPane().setBackground(Color.WHITE);//���ñ���ɫ
			jf.setTitle("����1.0");
			jf.setDefaultCloseOperation(3);
			// ���þ�ס��ʾ
			jf.setLocationRelativeTo(null);
			
			DrawMouse mouse = new DrawMouse();
			jf.setLayout(new BorderLayout());
			
			JPanel jp1= new JPanel();
			jp1.setBackground(Color.green);
			jf.add(jp1,BorderLayout.NORTH);

    //		JPanel jp2= new JPanel();
	//		jp2.setBackground(Color.white);
	//		jf.add(jp2,BorderLayout.CENTER);			
			
			String[] shape ={"ֱ��","����","������","��Բ","�������","����","��Ƥ��","����ͼ��","�ݹ�"};
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
			
			//��ȡ���ʶ���ͼ�λ����Ǹ�����ϣ����ʾʹӸ�����ϻ�ȡ
			//�Ӵ����ϻ�ȡ���ʶ���
		
			
			Graphics g = this.getGraphics();
			
			
			
			//���������������������
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
	
	
	
	
	

