package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//브라우저가 응답을 받았을때 타입을 알려주는 것
		PrintWriter out = response.getWriter();//보내는 통로
		out.print("<h1>1-10출력 </h1>");
		for(int i=0;i<10;i++) {
			out.print(i+"<br>");
		}
		out.close();}
	
	//2.5버전으로 하면 어노테이션이 없어지고 web.xml로 대체된다 
	//당신의 url에서의 마지막 서블릿 매핑을 web.xml에 서블릿매핑에서 저장하는데 
	//거기서 동일한 이름을 찾지못하면 404 에러가 뜬다
	//3.0 버전 전에서는 서블릿이 하나 더 만들어 지면 web.xml에 반드시 등록해야 했다
	
	//web.xml에서 매핑값을 변경하면 그 값으로 페이지가 열린다.
}
