import java.io.*;
import java.util.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileExplorer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FileExplorer() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File reposDir = new File("/usr/repos");
        Map<String, List<String>> repoFiles = new LinkedHashMap<String, List<String>>();
        if (reposDir.exists() && reposDir.isDirectory()) {
            File[] repos = reposDir.listFiles();
            if (repos != null) {
                Arrays.sort(repos);
                for (File repo : repos) {
                    if (repo.isDirectory()) {
                        List<String> files = new ArrayList<String>();
                        File[] fileList = repo.listFiles();
                        if (fileList != null) {
                            Arrays.sort(fileList);
                            for (File f : fileList) {
                                if (f.isFile()) {
                                    files.add(f.getAbsolutePath());
                                }
                            }
                        }
                        repoFiles.put(repo.getName(), files);
                    }
                }
            }
        }
        request.setAttribute("repoFiles", repoFiles);
        request.getRequestDispatcher("/view.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
