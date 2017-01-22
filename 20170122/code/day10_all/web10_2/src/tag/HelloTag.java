package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 1.继承SimpleTagSupport类
 * 2.override doTag方法
 * 3.标签有哪些属性，标签类也要有相应的
 * 属性及对应的set方法。
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
		//通过继承自SimpleTagSupport类提供的方法
		//来获得pageContext。
		PageContext ctx = 
			(PageContext)getJspContext();
		//pageContext提供了获得其它所有隐含对象的方法
		JspWriter out = ctx.getOut();
		for(int i = 0; i < qty; i ++){
			out.println(info + "<br/>");
		}
	}
	
}
