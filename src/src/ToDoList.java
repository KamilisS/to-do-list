/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import common.*;
import db.DatabaseController;
import gui.LoginWindow;
import javax.swing.UIManager;

/**
 *
 * @author gvt48
 */
public class ToDoList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        showLoginWindow();
    }
    
    private static void showLoginWindow() {
        LoginWindow login = new LoginWindow();
        Common.center(login);
        login.setTitle("Prisijungimas");
        login.setResizable(false);
        login.setVisible(true);
    }
    
}
