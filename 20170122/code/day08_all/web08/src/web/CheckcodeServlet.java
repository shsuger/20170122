package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * ��ͼ
		 */
		//step1,����һ���ڴ�ӳ�����(����)
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//step2,��û���
		Graphics g = image.getGraphics();
		//step3,����������ɫ
		g.setColor(new Color(255,255,255));
		//step4,������������ɫ
		g.fillRect(0, 0, 80, 30);
		//step5,����������ɫ
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//step6,����һ�������(��֤��)
		//String number = r.nextInt(88888) + "";
		String number = getNumber(5);
		//��number(��֤��)�󶩵�session������
		HttpSession session = 
			request.getSession();
		session.setAttribute("number", number);
		//step7,����������Ƴ���
		//Font(����,���,��С)
		g.setFont(new Font(null,Font.BOLD|Font.ITALIC,24));
		g.drawString(number, 5, 26);
		//step8,��һЩ������
		for(int i = 0 ;i < 8 ;i ++){
			g.setColor(new Color(r.nextInt(255),
					r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30),
					r.nextInt(80), r.nextInt(30));
		}
		/*
		 * ��ͼƬѹ�������͸������
		 */
		//step1,����content-type��Ϣͷ������
		//����������ص���ͼƬ
		response.setContentType("image/jpeg");
		//step2,����ֽ������
		OutputStream ops = response.getOutputStream();
		//step3,ѹ��ͼƬ�����ҽ�ѹ��֮�������
		//��ŵ�response
		javax.imageio.ImageIO
		.write(image, "jpeg", ops);
		ops.close();
	}
	
	/*
	 * ����һ������Ϊsize����֤�룬
		��"A~Z,0~9"���ѡȡ
	 */
	private String getNumber(int size) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXZY" +
				"0123456789";
		Random r = new Random();
		String number = "";
		for(int i = 0;i < size; i ++){
			number += str.charAt(r.nextInt(str.length()));
		}
		return number;
	}

}
