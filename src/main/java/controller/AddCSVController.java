/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.CSV;
import ui.MainMenu;

/**
 *
 * @author mateus
 */
public class AddCSVController {
    
    
    public boolean salvaCSV(String nome, String diretorio ){
        
        if(nome.length() > 0 && diretorio.length() > 0){
            
           CSV currentCSV = new CSV();
            try {
                currentCSV.setDiretorio(diretorio);
                currentCSV.setNomeAcao(nome);
                MainMenu.listaCSV.add(currentCSV);                     
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler arquivo."+ e);
            }
       
        }else{
            return false;
        }
        
        return true;
    }
}
