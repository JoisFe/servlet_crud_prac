package Servlet;

import Domain.Member;
import Service.MemberService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 조재철
 * @since 1.0
 */
@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {

    private final MemberService memberService = MemberService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<Integer, Member> memberMap = memberService.findMemberMap();

        try (PrintWriter out = response.getWriter();) {
            out.println("");
            out.println("<html><head></head><body>");
            out.println("<h1>회원 리스트</h1>");

            out.println("<table border=\"1\">\n"
                + "\t<th>아이디</th>\n"
                + "\t    <td>삭제</td>\n"
                + "\t    <td>수정</td>\n");

            for (Integer num : memberMap.keySet()) {
                out.println("\t<tr>\n"
                    + "\t    <td>" + memberMap.get(num).getUsername() + "</td>\n"
                    + "\t<th><a href=\"/removeMember?id=" + num + "\">삭제</a></th>\n"
                    + "\t<th><a href=\"/updateMember?id=" + num + "\">수정</a></th>\n"
                    + "\t</tr>\n");
            }

            out.println("</table>");

            out.println("</body></html>");
        }
    }

}
