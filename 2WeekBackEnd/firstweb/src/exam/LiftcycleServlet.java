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
        
        //처음만 라이프사이클 이닛  서비스 생성
        //후에 새로고침 하면 서비스만 호출
        //내용을 수정하면 디스트로이 호출 후에 다시 처음 부터 호출
    }

	
	public void init(ServletConfig config) throws ServletException {
		 System.out.print("init");
	}


	public void destroy() {
		 System.out.print("destroy");
	}


		//doget과 dopost 테스트
	//해당 서블릿 주소를 직접 입력하거나 링크를 클릭한다 -> get방식
	//doget이 호출 그래서 여기서 post로 호출하니 dopost가 호출된다
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
