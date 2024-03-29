/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import common.Common;
import common.Session;
import db.DatabaseController;
import entity.Task;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gvt48
 */
public class MainWindow extends javax.swing.JFrame {

    private  Session session;
    ArrayList<Task> tasks;
    /**
     * Creates new form MainWindow
     */
    public MainWindow(Session session) {
        this.session = session;
        initComponents();
        
        this.createBtn.setContentAreaFilled(false);
        this.createBtn.setOpaque(true);
        
        this.refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        logoutBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        doneBtn = new javax.swing.JButton();
        settingsBtn = new javax.swing.JButton();
        catBtn = new javax.swing.JButton();
        recomBtn = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutBtn.setText("Atsijungti");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        createBtn.setBackground(new java.awt.Color(51, 153, 0));
        createBtn.setForeground(new java.awt.Color(255, 255, 255));
        createBtn.setText("Sukurti naują veiklą");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pavadinimas", "Kategorija", "Terminas", "Svarbus", "Aprašymas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(70);
            table.getColumnModel().getColumn(4).setPreferredWidth(300);
        }

        doneBtn.setText("Atliktos veiklos");
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        settingsBtn.setText("Paskyros nustatymai");
        settingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsBtnActionPerformed(evt);
            }
        });

        catBtn.setText("Kategorijų valdymas");
        catBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catBtnActionPerformed(evt);
            }
        });

        recomBtn.setText("Veiklų atlikimo rekomendacijos");
        recomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recomBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(catBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(recomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBtn)
                    .addComponent(doneBtn)
                    .addComponent(settingsBtn)
                    .addComponent(catBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn)
                    .addComponent(recomBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        this.dispose();
        LoginWindow login = new LoginWindow();
        Common.center(login);
        login.setTitle("Prisijungimas");
        login.setResizable(false);
        login.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        NewTaskWindow dialog = new NewTaskWindow(this, true, this.session);
        dialog.setTitle("Veiklos kūrimas");
        dialog.setModal(true);
        dialog.pack();
        Common.center(dialog);
        dialog.setResizable(false);
        dialog.setVisible(true);
        this.refreshTable();
    }//GEN-LAST:event_createBtnActionPerformed

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        DoneWindow dialog = new DoneWindow(this, true, this.session);
        dialog.setTitle("Atliktų veiklų sąrašas");
        dialog.setModal(true);
        dialog.pack();
        Common.center(dialog);
        dialog.setResizable(false);
        dialog.setVisible(true);
        this.refreshTable();
    }//GEN-LAST:event_doneBtnActionPerformed

    private void settingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBtnActionPerformed
        EditAccountWindow dialog = new EditAccountWindow(this, true, this.session);
        dialog.setTitle("Paskyros redagavimas");
        dialog.setModal(true);
        dialog.pack();
        Common.center(dialog);
        dialog.setResizable(false);
        dialog.setVisible(true);
        if (!new DatabaseController().doesUserExist(this.session.getUserId())) {
            this.dispose();
            LoginWindow login = new LoginWindow();
            Common.center(login);
            login.setTitle("Prisijungimas");
            login.setResizable(false);
            login.setVisible(true);
        } else {
            this.refreshTable();
        }
    }//GEN-LAST:event_settingsBtnActionPerformed

    private void catBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catBtnActionPerformed
        CategoriesWindow dialog = new CategoriesWindow(this, true, this.session);
        dialog.setTitle("Kategorijų sąrašas");
        dialog.setModal(true);
        dialog.pack();
        Common.center(dialog);
        dialog.setResizable(false);
        dialog.setVisible(true);
        this.refreshTable();
    }//GEN-LAST:event_catBtnActionPerformed

    private void recomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recomBtnActionPerformed
        RecommendationsWindow dialog = new RecommendationsWindow(this, true, this.session);
        dialog.setTitle("Veiklų atlikimo pirmumo rekomendacijos");
        dialog.setModal(true);
        dialog.pack();
        Common.center(dialog);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }//GEN-LAST:event_recomBtnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = this.table.rowAtPoint(evt.getPoint());
        EditTaskWindow dialog = new EditTaskWindow(this, true, this.session, this.tasks.get(row));
        dialog.setTitle("Veiklos redagavimas");
        dialog.setModal(true);
        dialog.pack();
        Common.center(dialog);
        dialog.setResizable(false);
        dialog.setVisible(true);
        this.refreshTable();
    }//GEN-LAST:event_tableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }
    
    private void refreshTable() {
        this.tasks = new DatabaseController().getUserTasks(this.session.getUserId());
        
        DefaultTableModel dm = (DefaultTableModel) this.table.getModel();
        int rowCount = dm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        
        for (Task o : tasks) {
            String deadline = dateFormat.format(o.getDeadline());

            String[] row = {
                o.getName(),
                o.getCatName(),
                deadline,
                o.getPriority() == 1 ? "Taip" : "Ne",
                o.getDescription()
            };
            dm.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton catBtn;
    private javax.swing.JButton createBtn;
    private javax.swing.JButton doneBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton recomBtn;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
