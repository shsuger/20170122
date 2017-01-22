package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 1.�̳�SimpleTagSupport��
 * 2.override doTag����
 * 3.��ǩ����Щ���ԣ���ǩ��ҲҪ����Ӧ��
 * ���Լ���Ӧ��set������
 */
public class HelloTag extends SimpleTagSupport{
	private String info;
	private int qty;
	public HelloTag(){
		System.out.println("HelloTag's constructor...");
	}
	public void setInfo(String info) {
		System.out.println("setInfo..." + info);
		this.info = info;
	}

	public void setQty(int qty) {
		System.out.println("setQty..." + qty);
		this.qty = qty;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("HelloTag's doTag...");
		//ͨ���̳���SimpleTagSupport���ṩ�ķ���
		//�����pageContext��
		PageContext ctx = 
			(PageContext)getJspContext();
		//pageContext�ṩ�˻������������������ķ���
		JspWriter out = ctx.getOut();
		for(int i = 0; i < qty; i ++){
			out.println(info + "<br/>");
		}
	}
	
}
