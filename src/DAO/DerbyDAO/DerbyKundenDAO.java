/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.DerbyDAO;

import DAO.KundenDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author georg
 */
public class DerbyKundenDAO implements KundenDAO{
    public void getKunden() {
        try {
            DerbyQueryInterface i = new getKundenQuery();
            ResultSet rs = i.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " " + rs.getString("Name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DerbyKundenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private static final class getKundenQuery extends DerbyQueryTemplate{
        @Override
        public void executeSQL() {
            QueryString = "SELECT * FROM Kunden";
        }

    }
}
