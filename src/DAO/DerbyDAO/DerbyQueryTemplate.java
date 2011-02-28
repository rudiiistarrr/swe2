/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.DerbyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author georg
 */
public abstract class DerbyQueryTemplate implements DerbyQueryInterface {
    public ResultSet executeQuery(){
        Connection db = DerbyDAOFactory.getConnection();
        executeSQL();
        try {
            PreparedStatement ps = db.prepareStatement(QueryString);
            ResultSet rs = ps.executeQuery();
            ps.close();
            db.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DerbyQueryTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected String QueryString;
    public abstract void executeSQL();

}
