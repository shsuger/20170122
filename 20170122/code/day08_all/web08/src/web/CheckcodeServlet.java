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
		 * 绘图
		 */
		//step1,创建一个内存映像对象(画布)
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//step2,获得画笔
		Graphics g = image.getGraphics();
		//step3,给笔设置颜色
		g.setColor(new Color(255,255,255));
		//step4,给画布设置颜色
		g.fillRect(0, 0, 80, 30);
		//step5,给笔设置颜色
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//step6,生成一个随机数(验证码)
		//String number = r.nextInt(88888) + "";
		String number = getNumber(5);
		//将number(验证码)绑订到session对象上
		HttpSession session = 
			request.getSession();
		session.setAttribute("number", number);
		//step7,将随机数绘制出来
		//Font(字体,风格,大小)
		g.setFont(new Font(null,Font.BOLD|Font.ITALIC,24));
		g.drawString(number, 5, 26);
		//step8,加一些干扰线
		for(int i = 0 ;i < 8 ;i ++){
			g.setColor(new Color(r.nextInt(255),
					r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30),
					r.nextInt(80), r.nextInt(30));
		}
		/*
		 * 将图片压缩，发送给浏览器
		 */
		//step1,设置content-type消息头，告诉
		//浏览器，返回的是图片
		response.setContentType("image/jpeg");
		//step2,获得字节输出流
		OutputStream ops = response.getOutputStream();
		//step3,压缩图片，并且将压缩之后的数据
		//存放到response
		javax.imageio.ImageIO
		.write(image, "jpeg", ops);
		ops.close();
	}
	
	/*
	 * 生成一个长度为size的验证码，
		从"A~Z,0~9"随机选取
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
