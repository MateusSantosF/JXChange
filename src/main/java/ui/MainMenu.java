/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SingleSelectionModel;
import model.AplicaLookAndFeel;
import model.CSV;
import model.GerenciadorJPanel;
import model.Observador;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author mateus
 */
public class MainMenu extends javax.swing.JFrame implements Observador {

    private AddCSV telaAddCSV = null;

    public static ArrayList<CSV> listaCSV = new ArrayList<>();

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        new AplicaLookAndFeel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenuLateral = new javax.swing.JPanel();
        jPanelBotoes = new javax.swing.JPanel();
        jLabelDashboard = new javax.swing.JLabel();
        jLabelTools = new javax.swing.JLabel();
        jLabelSettings = new javax.swing.JLabel();
        jLabelHelp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelAddcsv = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JXCHANGE");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelMenuLateral.setBackground(new java.awt.Color(24, 24, 24));
        jPanelMenuLateral.setPreferredSize(new java.awt.Dimension(300, 720));

        jPanelBotoes.setBackground(new java.awt.Color(24, 24, 24));
        jPanelBotoes.setLayout(new java.awt.GridLayout(8, 1));

        jLabelDashboard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDashboard.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-dash.png"))); // NOI18N
        jLabelDashboard.setText("Dashboard");
        jLabelDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDashboard.setIconTextGap(6);
        jLabelDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDashboardMousePressed(evt);
            }
        });
        jPanelBotoes.add(jLabelDashboard);

        jLabelTools.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTools.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-tools.png"))); // NOI18N
        jLabelTools.setText("Tools");
        jLabelTools.setIconTextGap(6);
        jLabelTools.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelToolsMousePressed(evt);
            }
        });
        jPanelBotoes.add(jLabelTools);

        jLabelSettings.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelSettings.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-config.png"))); // NOI18N
        jLabelSettings.setText("Settings");
        jLabelSettings.setIconTextGap(6);
        jLabelSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelSettingsMousePressed(evt);
            }
        });
        jPanelBotoes.add(jLabelSettings);

        jLabelHelp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelHelp.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-ajuda.png"))); // NOI18N
        jLabelHelp.setText("Help");
        jLabelHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHelp.setIconTextGap(6);
        jLabelHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelHelpMousePressed(evt);
            }
        });
        jPanelBotoes.add(jLabelHelp);
        jPanelBotoes.add(jLabel1);
        jPanelBotoes.add(jLabel2);

        jLabelAddcsv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelAddcsv.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddcsv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-addcsv.png"))); // NOI18N
        jLabelAddcsv.setText("New Exchange");
        jLabelAddcsv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddcsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelAddcsvMousePressed(evt);
            }
        });
        jPanelBotoes.add(jLabelAddcsv);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMenuLateralLayout = new javax.swing.GroupLayout(jPanelMenuLateral);
        jPanelMenuLateral.setLayout(jPanelMenuLateralLayout);
        jPanelMenuLateralLayout.setHorizontalGroup(
            jPanelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLateralLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLateralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(45, 45, 45))
        );
        jPanelMenuLateralLayout.setVerticalGroup(
            jPanelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLateralLayout.createSequentialGroup()
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addGap(143, 143, 143))
        );

        getContentPane().add(jPanelMenuLateral, java.awt.BorderLayout.LINE_START);

        painelPrincipal.setBackground(new java.awt.Color(170, 175, 208));
        painelPrincipal.setLayout(new java.awt.BorderLayout());
        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingsMousePressed
        new GerenciadorJPanel(painelPrincipal, new Settings());

    }//GEN-LAST:event_jLabelSettingsMousePressed

    private void jLabelDashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDashboardMousePressed

        new GerenciadorJPanel(painelPrincipal, new Dashboard());
        listarGraficos();
    }//GEN-LAST:event_jLabelDashboardMousePressed

    private void jLabelHelpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHelpMousePressed
        new GerenciadorJPanel(painelPrincipal, new Help());
    }//GEN-LAST:event_jLabelHelpMousePressed

    private void jLabelToolsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelToolsMousePressed

        new GerenciadorJPanel(painelPrincipal, new Tools());
    }//GEN-LAST:event_jLabelToolsMousePressed

    private void jLabelAddcsvMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddcsvMousePressed

        if (telaAddCSV == null) {
            telaAddCSV = new AddCSV();
            telaAddCSV.registrarObservador(this);
            telaAddCSV.setVisible(true);
        } else {
            telaAddCSV.setVisible(true);
        }
    }//GEN-LAST:event_jLabelAddcsvMousePressed
    private void listarGraficos() {

        int cont = 0;
        painelPrincipal.removeAll();
        painelPrincipal.repaint();
        javax.swing.JTabbedPane pane = new javax.swing.JTabbedPane();
        painelPrincipal.add(pane);

        for (CSV csv : listaCSV) {

            try {
                JFreeChart chart = ChartFactory.createCandlestickChart(csv.getNomeAcao(),
                        "Data",
                        "Valor",
                        csv.montaDataSet(csv.montaDataItem(csv.getDiretorio())), true);
                
                
                ChartPanel painelGrafico = new ChartPanel(chart);
                painelGrafico.setName(csv.getNomeAcao());
                
                pane.add(painelGrafico);
                pane.setTitleAt(cont++, csv.getNomeAcao());
                
            } catch (Exception e) {
             
                JOptionPane.showMessageDialog(null, e + "teste");
            }

        }
    }

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAddcsv;
    private javax.swing.JLabel jLabelDashboard;
    private javax.swing.JLabel jLabelHelp;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelSettings;
    private javax.swing.JLabel jLabelTools;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelMenuLateral;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Boolean b) {

        if (b) {
            listarGraficos();
        }

    }

}
