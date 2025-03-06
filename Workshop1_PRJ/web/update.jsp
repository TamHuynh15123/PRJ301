<%@page import="dao.ProjectDAO"%>
<%@page import="dto.ProjectDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("projectId");
    ProjectDAO dao = new ProjectDAO();
    ProjectDTO project = dao.readbyID(id);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Project</title>
    </head>
    <body>
        <h2>Update Project</h2>
        <form action="MainController" method="POST">
            <input type="hidden" name="action" value="updateProject">
            <input type="hidden" name="projectId" value="<%= project.getProjectId()%>">

            Project Name: <input type="text" name="projectName" value="<%= project.getProjectName()%>" readonly=""><br>
            Description: <input type="text" name="description" value="<%= project.getDescription()%>" readonly><br>
            Status: <select name="status">
                <option value="Ideation" <%= project.getStatus().equals("Ideation") ? "selected" : ""%>>Ideation</option>
                <option value="Development" <%= project.getStatus().equals("Development") ? "selected" : ""%>>Development</option>
                <option value="Launch" <%= project.getStatus().equals("Launch") ? "selected" : ""%>>Launch</option>
                <option value="Scaling" <%= project.getStatus().equals("Scaling") ? "selected" : ""%>>Scaling</option>
            </select> <br>
            Estimated Launch: <input type="date" name="estimatedLaunch" value="<%= project.getEstimatedLaunch()%>" readonly=""><br>

            <input type="submit" value="Save">
        </form>
    </body>
</html>
