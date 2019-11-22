/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Kirja;
import java.util.ArrayList;

/**
 *
 * @author matilaol
 */
public interface Tietokanta {
    
    public void lisaa(Kirja kirja);
    
    public ArrayList<Kirja> haeLukuvinkit();
    
}
