package az.company.library.controller;

import az.company.library.dao.AuthorDao;
import az.company.library.dao.GenreDao;
import az.company.library.dao.impl.AuthorDaoImpl;
import az.company.library.dao.impl.GenreDaoImpl;
import az.company.library.model.Author;
import az.company.library.model.Genre;
import az.company.library.service.AuthorService;
import az.company.library.service.GenreService;
import az.company.library.service.impl.AuthorServiceImpl;
import az.company.library.service.impl.GenreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GenreServlet", value = "/gs")
public class GenreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request,HttpServletResponse response){
        try{
            String action=null;
            String address=null;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            GenreDao genreDao=new GenreDaoImpl();
            GenreService genreService=new GenreServiceImpl(genreDao);

           if(request.getParameter("action")!=null){
               action=request.getParameter("action");

               if(action.equalsIgnoreCase("getGenreList")){
                   List<Genre> genreList=genreService.getGenreList();
                   request.setAttribute("genreList",genreList);


                   address="WEB-INF/pages/genre_list.jsp";
               }
               else if(action.equalsIgnoreCase("addGenre")){
                   String name = request.getParameter("name");

                   Genre genre=new Genre();
                   genre.setName(name);

                   genreService.addGenre(genre);

                   out.write("success");
               }else if(action.equalsIgnoreCase("getGenreData")){
                   List<Genre> genreList = genreService.getGenreList();
                   request.setAttribute("genreList", genreList);
                   address = "WEB-INF/pages/genreData.jsp";
               }

               if(address!=null){
                   request.getRequestDispatcher(address).forward(request,response);
               }
           }
        }catch (Exception ex){
            ex.printStackTrace();
        }



    }
}
