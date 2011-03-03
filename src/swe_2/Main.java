/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package swe_2;

import GUI.MainFrame;
import DAO.KundenDAO;
import DAO.DAOFactory;
import Entities.Kunde;
import java.util.ArrayList;

/**
 *
 * @author georg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.DERBY);
        KundenDAO kundendao = dao.getKundenDAO();
        ArrayList<Kunde> k = kundendao.getKunden();
        for(Kunde i : k){
            System.out.println(i.getID() + " " + i.getName());
        }

        MainFrame.main(null);


    }

}
