/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mateus
 */
public class AplicaLookAndFeel {
    
    public AplicaLookAndFeel() {
    }
	public static void pegaNimbus() {
		try {
		    for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		       }
		    }
                  
		} catch (UnsupportedLookAndFeelException e) {

		    System.out.println("Erro: " + e.getMessage());
		    e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("Erro: " + e.getMessage());
		    e.printStackTrace();

		} catch (InstantiationException e) {

			System.out.println("Erro: " + e.getMessage());
		    e.printStackTrace();

		} catch (IllegalAccessException e) {

			System.out.println("Erro: " + e.getMessage());
		    e.printStackTrace();
		}
	}
}
