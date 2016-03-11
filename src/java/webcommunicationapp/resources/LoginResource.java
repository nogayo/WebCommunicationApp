/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcommunicationapp.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import webcommunicationapp.connection.MyConnection;
import webcommunicationapp.connection.Session;
import webcommunicationapp.connection.User;

/**
 *
 * @author Guido Cruz
 */
@Path("login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    public LoginResource() {

    }

    @POST
    public Session login(User user) {
        Session session = MyConnection.getInstance().login(user.getUssername(), user.getPassword());
        return session;
    }
}
