/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.DerbyDAO;

import DAO.KundenDAO;
import Entities.Kunde;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author georg
 */
public class DerbyKundenDAO implements KundenDAO{
    public ArrayList<Kunde> getKunden() {
        try {
            Connection db = DerbyDAOFactory.getConnection();
            PreparedStatement ps = db.prepareStatement("SELECT * FROM Kunden");
            ResultSet rs = ps.executeQuery();

            ArrayList<Kunde> kunden = new ArrayList<Kunde>();

            while(rs.next()){
                kunden.add(new Kunde(rs.getInt("ID"), rs.getString("Name")));
            }

            return kunden;
        } catch (SQLException ex) {
            Logger.getLogger(DerbyKundenDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int updateKunde(Kunde k){

        return 0;
    }

    public int updateKunden(ArrayList<Kunde> kunden){
        int rowsUpdated = 0;

        for(Kunde k : kunden){
            rowsUpdated += updateKunde(k);
        }

        return rowsUpdated;
    }
}
