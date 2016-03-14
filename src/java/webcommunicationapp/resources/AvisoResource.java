/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webcommunicationapp.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import webcommunicationapp.connection.MyConnection;
import webcommunicationapp.connection.User;
import webcommunicationapp.model.Message;
import webcommunicationapp.model.Publicacion;

/**
 *
 * @author ariel
 */
@Stateless
@Path("aviso")
@Produces(MediaType.APPLICATION_JSON)
public class AvisoResource {
    private static List<Publicacion> list;

    public AvisoResource() {
        list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Publicacion p = new Publicacion();
            p.setTitulo("publicacion " + i);
            p.setAviso("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quas iure facilis necessitatibus ipsam, itaque consequatur illum odit vero minus pariatur quae inventore provident id deleniti ab nisi harum libero soluta.");
            list.add(p);
        }
    }

    @GET
    public List<Publicacion> getAll() {
        //No pude probrar que la BD funciona, por eso lo comente esta parte del codigo.
        return MyConnection.getInstance().obtenerAvisos();
        
//        return list;
    }

    @POST
    public void saveTask(Publicacion p) {
        String titulo = p.getTitulo();
        String aviso = p.getAviso();
//        list.add(0,p);
        MyConnection.getInstance().guardarAviso(titulo, aviso);
    }
}
