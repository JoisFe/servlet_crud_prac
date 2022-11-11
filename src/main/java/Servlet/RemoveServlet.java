package Servlet;

import Service.MemberService;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 조재철
 * @since 1.0
 */
@WebServlet("/removeMember")
public class RemoveServlet extends HttpServlet {
    private final MemberService memberService = MemberService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        memberService.deleteMember(Integer.valueOf(request.getParameter("id")));

        response.sendRedirect("index.jsp");
    }
}
