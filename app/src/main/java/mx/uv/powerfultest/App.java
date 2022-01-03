package mx.uv.powerfultest;

import static spark.Spark.*;
import com.google.gson.Gson;

import mx.uv.powerfultest.dao.TareaDAO;
import mx.uv.powerfultest.dao.UsuarioDAO;
import mx.uv.powerfultest.objeto.Tarea;
import mx.uv.powerfultest.objeto.Usuario;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
public class App {
    public static void main( String[] args ){
        Gson gson = new Gson();
        staticFiles.location("/");
        init();
        get("/acceso", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            System.out.println("acceder");
            System.out.println(req.host());
            return new ModelAndView(model, "/accesoUsuarios.vm");
        }, new VelocityTemplateEngine());

        get("/home", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            System.out.println("pagina principal");
            System.out.println(req.host());
            String cor = req.queryParams("correo");
            System.out.println(cor);
            Usuario u = UsuarioDAO.usuarioCorreo(cor);
            model.put("usuario", u);
            List<Tarea> tareas = TareaDAO.getTareabyUsuario(u.getId());
            model.put("tareas", tareas);
            return new ModelAndView(model, "/homeUsuario.vm");
        }, new VelocityTemplateEngine());

        get("/crearTarea", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            System.out.println("crear una tarea");
            System.out.println(req.host());
            return new ModelAndView(model, "/registrarTarea.vm");
        }, new VelocityTemplateEngine());

        get("/registrarUsuarioNuevo", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            System.out.println("registro");
            System.out.println(req.host());
            return new ModelAndView(model, "/registroUsuario.vm");
        }, new VelocityTemplateEngine());
        
        post("/accesoUsuarios", (req, res) -> {
            Usuario u = gson.fromJson(req.body(), Usuario.class);
            String correo = u.getCorreo_e();
            String clave = u.getClave();
            u = UsuarioDAO.accesodeUsuario(correo, clave);
            if (u != null) {
                System.out.println("¡Bienvenido " + u.getNombre() + "!");
            } else {
                System.out.println("oops! un problema");
            }
            res.body("bienvenido " + u.getNombre());
            return res.body();
        });

        post("/registrarUsuario", (req, res) -> {
            Usuario us = gson.fromJson(req.body(), Usuario.class);
            String nombres = us.getNombre();
            String correo = us.getCorreo_e();
            String clave = us.getClave();

            System.out.println(us.toString());

            if (UsuarioDAO.registrarUsuario(new Usuario(0, nombres, correo, clave))) {
                System.out.println("Usuario registrado con exito!");
            } else {
                System.out.println("oops! un problema");
            }
            return "listo";
        });

        post("/registrarTarea", (req, res) -> {
            Tarea ta = gson.fromJson(req.body(), Tarea.class);
            int id = 0;
            String titulo = ta.getTitulo();
            String descripcion = ta.getDescripcion();
            Blob imagen = ta.getImagen();
            int id_usuario = ta.getId_usuario();

            if (TareaDAO.registrarTarea(new Tarea(id, titulo, descripcion, imagen, id_usuario))) {
                System.out.println("Tarea registrada con exito!");
            } else {
                System.out.println("oops! un problema");
            }
            return "listo";
        });
    }
}
