/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.DerbyDAO;

import java.sql.Connection;
import DAO.DAOFactory;
import DAO.KundenDAO;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author georg
 */
public class DerbyDAOFactory extends DAOFactory {
    public static Connection getConnection(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SWE2_1;");
        } catch (SQLException ex) {
            Logger.getLogger(DerbyDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }

    public DerbyDAOFactory(){

    }
    @Override
    public KundenDAO getKundenDAO() {
        return new DerbyKundenDAO();
    }

}
