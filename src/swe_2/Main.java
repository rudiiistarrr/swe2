/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package swe_2;

import DAO.KundenDAO;
import DAO.DAOFactory;

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
        kundendao.getKunden();
        kundendao.getKunden();
        kundendao.getKunden();

        

    }

}
