package Servlet;

import Service.MemberService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 조재철
 * @since 1.0
 */
@WebServlet("/updateMember")
public class UpdateServlet extends HttpServlet {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter();) {
            out.println("");
            out.println("<html><head></head><body>");
            out.println("<h1>회원 수정하기</h1>");

            out.println("<form action=\"/updateMember?id=" + request.getParameter("id") + "\" method=\"post\">\n"
                + "\tID:<input type=\"text\" name=\"username\" placeholder=\"아이디\"><br/>\n"
                + "\t<input type=\"submit\">\n"
                + "</form>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        memberService.updateMember(Integer.valueOf(request.getParameter("id")), request.getParameter("username"));

        response.sendRedirect("index.jsp");
    }
}
