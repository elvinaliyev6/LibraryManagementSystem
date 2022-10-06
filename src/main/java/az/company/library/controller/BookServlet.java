package az.company.library.controller;

import az.company.library.dao.BookDao;
import az.company.library.dao.impl.BookDaoImpl;
import az.company.library.model.AuthorBookGenre;
import az.company.library.model.Book;
import az.company.library.service.BookService;
import az.company.library.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/bs")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try{
            String action = null;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            BookDao bookDao=new BookDaoImpl();
            BookService bookService=new BookServiceImpl(bookDao);

            if(request.getParameter("action").equalsIgnoreCase("getBookList")){
                List<AuthorBookGenre> bookList=bookService.getBookList();
                request.setAttribute("bookList",bookList);

                request.getRequestDispatcher("WEB-INF/pages/book_list.jsp").forward(request,response);
            }else{
                out.println("<h1>Error!!!</h1>");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
