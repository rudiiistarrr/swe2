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
        Connection db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            db = DerbyDAOFactory.getConnection();
            ps = db.prepareStatement("SELECT * FROM Kunden");
            rs = ps.executeQuery();

            ArrayList<Kunde> kunden = new ArrayList<Kunde>();

            while(rs.next()){
                kunden.add(new Kunde(rs.getInt("ID"), rs.getString("Name")));
            }

            return kunden;
        } catch (SQLException ex) {
            Logger.getLogger(DerbyKundenDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                db.close();
            } catch (SQLException ex) {
                Logger.getLogger(DerbyKundenDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public int updateKunde(Kunde k){
        if(k.isChanged()){
            Connection db = null;
            PreparedStatement ps = null;

            db = DerbyDAOFactory.getConnection();
            try {
                ps = db.prepareStatement("UPDATE Kunden SET Name = ? WHERE ID = ?");
                ps.setString(1, k.getName());
                ps.setInt(2, k.getID());
                int rowsChanged =  ps.executeUpdate();
                k.setIsChanged(false);
                return rowsChanged;
            } catch (SQLException ex) {
                Logger.getLogger(DerbyKundenDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public int updateKunden(ArrayList<Kunde> kunden){
        int rowsUpdated = 0;

        for(Kunde k : kunden){
            if(k.getID() == -1){
                rowsUpdated += addKunde(k.getName());
            }else if(k.isChanged()){
                rowsUpdated += updateKunde(k);
            }
        }

        return rowsUpdated;
    }

    public int deleteKunde(Kunde k) {
            Connection db = null;
            PreparedStatement ps = null;

            db = DerbyDAOFactory.getConnection();
            try {
                ps = db.prepareStatement("DELETE FROM Kunden WHERE ID = ?");
                ps.setInt(1, k.getID());
                int rowsChanged =  ps.executeUpdate();

                return rowsChanged;
            } catch (SQLException ex) {
                Logger.getLogger(DerbyKundenDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
    }

    public int addKunde(String name) {
            Connection db = null;
            PreparedStatement ps = null;

            db = DerbyDAOFactory.getConnection();
            try {
                ps = db.prepareStatement("INSERT INTO Kunden (\"NAME\") VALUES (?)");
                ps.setString(1, name);
                int rowsChanged =  ps.executeUpdate();

                return rowsChanged;
            } catch (SQLException ex) {
                Logger.getLogger(DerbyKundenDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
    }
}
