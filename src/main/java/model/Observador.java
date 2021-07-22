/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateus
 */
public interface Observador {
    
    public void update(Boolean b);
    
    
    public void update(Boolean[] b);
    
    public void update(int periodo);
     
    public void update(String diretorio);
    
}
