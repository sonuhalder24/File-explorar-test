import java.io.*;
import java.net.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditFile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditFile() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        if (path == null) path = "";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><title>Edit File</title></head><body>");
        out.println("<h3>" + path + "</h3>");
        out.println("<form action=\"/SaveFile\" method=\"post\">");
        out.println("<input type=\"hidden\" name=\"path\" value=\"" + path + "\"/>");
        out.println("<textarea id=\"editor\" name=\"content\" rows=\"20\" cols=\"80\"></textarea><br/>");
        out.println("<input type=\"submit\" id=\"save\" value=\"Save\"/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
