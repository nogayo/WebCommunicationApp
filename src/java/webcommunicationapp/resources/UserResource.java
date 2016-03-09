/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcommunicationapp.resources;

import webcommunicationapp.model.Message;
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

/**
 *
 * @author Guido Cruz
 */
@Stateless
@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static List<Message> list;

    public UserResource() {
        list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Message message = new Message();
            message.setValue("value" + i);
            list.add(message);
        }
    }

    @GET
    public List<Message> getAll() {
        return list;
    }

    @POST
    public void registerUser(User user) {
        String name = user.getName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String ussername = user.getUssername();
        String password = user.getPassword();

        MyConnection.getInstance().registerUser(name, lastName, email, ussername, password);
    }
}
