package com.tomcat.javaeetomcat;

import com.tomcat.javaeetomcat.model.MyListName;
import com.tomcat.javaeetomcat.model.MyListNameLocal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "nameServlet", value = "/name-servlet")
public class NameServlet extends HttpServlet {
    MyListNameLocal myListNameLocal = lookUpMyListNameLocal();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name != null) {
            myListNameLocal.addName(name);
        }

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (String myListNameLocalName : myListNameLocal.getNames()) {
            out.println("<h1>" + myListNameLocalName + "</h1>");
        }
        out.println("</body></html>");
    }

    public MyListNameLocal lookUpMyListNameLocal() {
        MyListNameLocal myListName = new MyListName();
        myListName.addName("aptech");
        myListName.addName("aptech1");
        myListName.addName("aptech2");
        return myListName;
    }
}
