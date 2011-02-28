/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DAO.DerbyDAO.DerbyDAOFactory;
import DAO.FakeDAO.FakeDAOFactory;

/**
 *
 * @author georg
 */
public abstract class DAOFactory {
    public static final int DERBY = 1;
    public static final int FAKE  = 2;

    public abstract KundenDAO getKundenDAO();

    public static DAOFactory getDAOFactory(int type){
        switch(type){
            case DERBY:
                return new DerbyDAOFactory();
            case FAKE:
                return new FakeDAOFactory();
            default:
                return null;
        }
    }
}
