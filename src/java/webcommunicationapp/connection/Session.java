/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcommunicationapp.connection;

import java.util.Objects;

/**
 *
 * @author Guido Cruz
 */
public class Session {
    
    private String loginValue;
    private String ussername;

    public Session() {
    }
    
    public String getLoginValue() {
        return loginValue;
    }

    public void setLoginValue(String loginValue) {
        this.loginValue = loginValue;
    }

    public String getUssername() {
        return ussername;
    }

    public void setUssername(String ussername) {
        this.ussername = ussername;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.loginValue);
        hash = 53 * hash + Objects.hashCode(this.ussername);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Session other = (Session) obj;
        if (!Objects.equals(this.loginValue, other.loginValue)) {
            return false;
        }
        if (!Objects.equals(this.ussername, other.ussername)) {
            return false;
        }
        return true;
    }
}
