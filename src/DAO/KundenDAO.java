/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entities.Kunde;
import java.util.ArrayList;

/**
 *
 * @author georg
 */
public interface KundenDAO {
    public ArrayList<Kunde> getKunden();
    public int updateKunden(ArrayList<Kunde> kunden);
    public int updateKunde(Kunde k);
    public int deleteKunde(Kunde k);
    public int addKunde(String Name);
}
