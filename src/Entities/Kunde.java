/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author georg
 */
public class Kunde {
    private int ID;
    private String Name;
    private boolean isChanged = false;

    public Kunde(int ID, String Name){
        this.ID = ID;
        this.Name = Name;
    }

    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
        this.setIsChanged(true);
    }

    /**
     * @return the isChanged
     */
    public boolean isChanged() {
        return isChanged;
    }

    /**
     * @param isChanged the isChanged to set
     */
    public void setIsChanged(boolean isChanged) {
        this.isChanged = isChanged;
    }


}
