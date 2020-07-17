package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LiftcycleServlet")
public class LiftcycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LiftcycleServlet() {
        System.out.print("Lifecycle");
        
        //ó���� ����������Ŭ �̴�  ���� ����
        //�Ŀ� ���ΰ�ħ �ϸ� ���񽺸� ȣ��
        //������ �����ϸ� ��Ʈ���� ȣ�� �Ŀ� �ٽ� ó�� ���� ȣ��
    }

	
	public void init(ServletConfig config) throws ServletException {
		 System.out.print("init");
	}


	public void destroy() {
		 System.out.print("destroy");
	}


		//doget�� dopost �׽�Ʈ
	//�ش� ���� �ּҸ� ���� �Է��ϰų� ��ũ�� Ŭ���Ѵ� -> get���
	//doget�� ȣ�� �׷��� ���⼭ post�� ȣ���ϴ� dopost�� ȣ��ȴ�
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/firstweb/LiftcycleServlet'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}
	
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 System.out.print("service");
//	}
//	
	

}
