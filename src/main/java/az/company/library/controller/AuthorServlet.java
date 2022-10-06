package az.company.library.controller;

import az.company.library.dao.AuthorDao;
import az.company.library.dao.impl.AuthorDaoImpl;
import az.company.library.model.Author;
import az.company.library.model.Book;
import az.company.library.service.AuthorService;
import az.company.library.service.impl.AuthorServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AuthorServlet", value = "/as")
public class AuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String action = null;
            AuthorDao authorDao = new AuthorDaoImpl();
            AuthorService authorService = new AuthorServiceImpl(authorDao);
            String address = null;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

            if(request.getParameter("action")!=null){

                action=request.getParameter("action");

                if (action.equalsIgnoreCase("getAuthorList")) {
                    List<Author> authorList = authorService.getAuthorList();
                    request.setAttribute("authorList", authorList);

                    address = "WEB-INF/pages/author_list.jsp";
                }
                else if (action.equalsIgnoreCase("addAuthor")) {
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String dob = request.getParameter("dob");

                    Author author = new Author();
                    author.setName(name);
                    author.setSurname(surname);
                    author.setDob(df.parse(dob));

                    authorService.addAuthor(author);

                    out.write("success");

                } else if (action.equalsIgnoreCase("getAuthorData")) {
                    List<Author> authorList = authorService.getAuthorList();
                    request.setAttribute("authorList", authorList);
                    address = "WEB-INF/pages/authorData.jsp";
                }

                if (address != null) {
                    request.getRequestDispatcher(address).forward(request, response);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
