package Java.com;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "XmlServlet", description="A xml form servlet", urlPatterns = "/XmlCheck"
,initParams = {@WebInitParam(name = "defaultUser",value="Kamalita")})

public class XmlServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        response.setContentType("text/html");
        String userName=request.getParameter("userName");
        HttpSession session=request.getSession();
        ServletContext servletContext=request.getServletContext();
        if(userName!=null && userName!=""){
            session.setAttribute("savedUserName",userName);
            servletContext.setAttribute("savedName",userName);
        }
        if(userName==null){
            writer.println("<html>My name in session " +(String)session.getAttribute("savedUserName")+" ");
            writer.println("My name in context " +(String)servletContext.getAttribute("savedName"));
        }
        else{
            writer.println("<html>My name is" +userName);
        }
        writer.println(getInitParameter("defaultUser"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        response.setContentType("text/html");
        String userName=request.getParameter("userName");
        String userAge=request.getParameter("userAge");
        String location[]=request.getParameterValues("location");
        HttpSession session=request.getSession();
        ServletContext servletContext=request.getServletContext();
        if(userName==null){
            session.setAttribute("savedUserName",userName);
            servletContext.setAttribute("SavedName",userName);
        }
        writer.println("<html>My name is" +userName);
        writer.println("<html>My name is " +(String)session.getAttribute("userName"));
        writer.println("<html>My name is " +(String)servletContext.getAttribute("userName"));
        writer.println("My Age :"+userAge);
        writer.println(" I live in ");
        for(String i:location){
            writer.println(i);
        }
        writer.println("</html>");
    }
}
