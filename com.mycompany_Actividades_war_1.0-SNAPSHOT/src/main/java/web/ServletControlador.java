package web;

import data.DisciplinasDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String accion = req.getParameter("accion");
        
        if(accion!=null){
            switch(accion){
                case "eliminar":
                    eliminarDisciplina(req,res);
                    break;
                case "editar":
                    editarDisciplina(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }else{
            accionDefault(req, res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{
        String queryParam = req.getParameter("accion");
        if(queryParam!=null){
            switch(queryParam){
                case "insertar":
                    insertarDisciplina(req,res);
                    break;
                case "modificar":
                    modificarDisciplina(req,res);
                    break;
                default:
                    accionDefault(req,res);
                    break;
            }
        }
    }
    
    private void accionDefault(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        List <ActividadesClub> disciplinas = new DisciplinasDAO().findAll();
        disciplinas.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("disciplinas", disciplinas);
        sesion.setAttribute("cantidadInscriptos",calcularInscriptos(disciplinas));
        sesion.setAttribute("precioTotal", calcularPrecio(disciplinas));
//        req.getRequestDispatcher("libros.jsp").forward(req, res);
        res.sendRedirect("disciplinas.jsp");
    }
    
    private void insertarDisciplina(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String deporte = req.getParameter("deporte");
        String dia = req.getParameter("dia");
        int maximo = Integer.parseInt(req.getParameter("maximo"));
        double valorCuota = Double.parseDouble(req.getParameter("valorCuota"));
        int inscriptos = Integer.parseInt(req.getParameter("inscriptos"));
        
        ActividadesClub disciplina = new ActividadesClub(deporte, dia, maximo, valorCuota, inscriptos);
        
        int registrosMod = new DisciplinasDAO().insert(disciplina);
        
        System.out.println("insertados = " + registrosMod);
        
        accionDefault(req, res);
    }
    
    private void eliminarDisciplina(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        int idActividad = Integer.parseInt(req.getParameter("idActividad"));
        
        int regMod = new DisciplinasDAO().deleteDisciplina(idActividad);
        
        System.out.println("SE ELIMINARON: "+ regMod +" REGISTROS");
        
        accionDefault(req, res);
    }
    
    private void editarDisciplina(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        int idActividad = Integer.parseInt(req.getParameter("idActividad"));
        ActividadesClub disciplina = new DisciplinasDAO().findById(idActividad);
        req.setAttribute("disciplina", disciplina);
        String jspEditar = "/WEB-INF/paginas/operaciones/editar.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }
    
    private void modificarDisciplina(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{
        String deporte = req.getParameter("deporte");
        String dia = req.getParameter("dia");
        int maximo = Integer.parseInt(req.getParameter("maximo"));
        double valorCuota = Double.parseDouble(req.getParameter("valorCuota"));
        int inscriptos = Integer.parseInt(req.getParameter("inscriptos"));
        
        int idActividad = Integer.parseInt(req.getParameter("idActividad"));
        
        ActividadesClub lib = new ActividadesClub(idActividad,deporte,dia,maximo,valorCuota,inscriptos);
        
        int regMod = new DisciplinasDAO().update(lib);
        
        System.out.println("SE ACTUALIZARON: "+ regMod +" REGISTROS");
        
        accionDefault(req, res);
    }
    
    private int calcularInscriptos(List<ActividadesClub> lib){
        int cant=0;
        for (int i = 0; i < lib.size(); i++) {
            cant += lib.get(i).getInscriptos();
        }
        return cant;
    }
    
    private double calcularPrecio(List<ActividadesClub> lib){
        double precio = 0;
        for (int i = 0; i < lib.size(); i++) {
            precio += (lib.get(i).getValorCuota() * lib.get(i).getInscriptos());
        }
        return precio;
    }

    
}
