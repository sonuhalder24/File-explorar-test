<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.regex.*" %>
<%@ page import="java.util.*,java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>File Explorer</title></head>
<body>
<h2>Repositories</h2>
<%
    Map<String, List<String>> repoFiles = (Map<String, List<String>>) request.getAttribute("repoFiles");
    if (repoFiles != null && !repoFiles.isEmpty()) {
        for (Map.Entry<String, List<String>> entry : repoFiles.entrySet()) {
            String repoName = entry.getKey();
            List<String> files = entry.getValue();
%>
<h3><%= repoName %></h3>
<ul>
<%
            for (String filePath : files) {
%>
<li><a href="/EditFile?path=<%= URLEncoder.encode(filePath, "UTF-8") %>"><%= filePath %></a></li>
<%
            }
%>
</ul>
<%
        }
    }
%>
</body>
</html>
