/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.FakeDAO;

import DAO.KundenDAO;
import DAO.DAOFactory;

/**
 *
 * @author georg
 */
public class FakeDAOFactory extends DAOFactory {
    
    @Override
    public KundenDAO getKundenDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
