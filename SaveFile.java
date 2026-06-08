import java.io.*;
import java.net.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveFile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveFile() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        String content = request.getParameter("content");
        if (path != null && content != null) {
            File f = new File(path);
            if (f.getParentFile() != null) {
                f.getParentFile().mkdirs();
            }
            FileWriter fw = null;
            try {
                fw = new FileWriter(f, false);
                fw.write(content);
                fw.flush();
            } finally {
                if (fw != null) try { fw.close(); } catch (IOException e) {}
            }
        }
        response.sendRedirect("/FileExplorer");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
