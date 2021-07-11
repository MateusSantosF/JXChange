/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author mateus
 */
public class AddCSVController {
    
    
    public boolean salvaCSV(String nome, String diretorio ){
        
        if(nome.length() > 0 && diretorio.length() > 0){
            
            //aqui criaria o objeto CSV 
            
        }else{
            return false;
        }
        
        return true;
    }
}
