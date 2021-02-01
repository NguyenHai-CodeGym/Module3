import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PersonServlet", urlPatterns = "/index")
public class PersonServlet extends HttpServlet {
    Service service = new Service();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        RequestDispatcher requestDispatcher;
        if (id == null){
            request.setAttribute("list", service.findAll());
            requestDispatcher = request.getRequestDispatcher("index.jsp");
        }else {
            try {
                Person person = service.findId(Integer.parseInt(id));
                if (person != null){
                    request.setAttribute("person",person);
                    requestDispatcher = request.getRequestDispatcher("WEB-INF/Person.jsp");
                }else {
                    throw new Exception();
                }

            }catch (Exception e){
                request.setAttribute("error","Khong Tim Thay");
                requestDispatcher = request.getRequestDispatcher("index.jsp");
            }
        }

        requestDispatcher.forward(request,response);
    }
}
