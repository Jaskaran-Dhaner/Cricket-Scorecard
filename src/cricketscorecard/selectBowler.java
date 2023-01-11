/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cricketscorecard;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class selectBowler extends javax.swing.JFrame {

    String CurBowler = "";
    static String name,id,Bruns,Wicket,Overs,Econ,Maidens;
    /**
     * Creates new form selectBowler
     */
    public selectBowler() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bowlerJTable = new javax.swing.JTable();
        select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Select Bowler");

        bowlerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player ID", "Player Name", "Runs", "Overs", "Maiden's", "Wickets", "Economy"
            }
        ));
        jScrollPane1.setViewportView(bowlerJTable);

        select.setText("Selected");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(190, 190, 190))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(select)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            java.sql.Connection cnBowl = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
            
            Statement st1 = cnBowl.createStatement();
            
            String bowlingTeam = firstInningBat.getBatTeam2();
//            System.out.println(bowlingTeam);
            String batQuery = "SELECT * FROM "+bowlingTeam;
            
            ResultSet bowlRS = null;
            bowlRS = st1.executeQuery(batQuery);
            while(bowlRS.next()){
                name = bowlRS.getString("PlayerName");
                id = bowlRS.getString("PlayerId");
                Bruns = bowlRS.getString("PlayerBRuns");
                Overs = bowlRS.getString("PlayerOvers");
                Econ = bowlRS.getString("PlayerEconomy");
                Maidens = bowlRS.getString("PlayerMaiden");
                Wicket = bowlRS.getString("PlayerWickets");
                String bowlTB[]= {id,name,Bruns,Overs,Maidens,Wicket,Econ};
                
                DefaultTableModel bowlModel = (DefaultTableModel)bowlerJTable.getModel();
                bowlModel.addRow(bowlTB);
            }
            cnBowl.close();
        }catch(Exception e){
            System.out.println("Error Occured!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        DefaultTableModel modelBowler = (DefaultTableModel)bowlerJTable.getModel();
        int[] index = bowlerJTable.getSelectedRows();
        System.out.println(Arrays.toString(index));
        CurBowler= modelBowler.getValueAt(index[0],1).toString();
        Bruns = modelBowler.getValueAt(index[0],2).toString();
        Overs = modelBowler.getValueAt(index[0],3).toString();
        Maidens = modelBowler.getValueAt(index[0],4).toString();
        Econ = modelBowler.getValueAt(index[0],6).toString();
        Wicket = modelBowler.getValueAt(index[0],5).toString();
//        firstInningsJFrame frames = new firstInningsJFrame();
//        frames.setVisible(true);
        firstInningsJFrame.currentBowler.setText(CurBowler);
//        BowlStats.BowlStats
           firstInningsJFrame.curBowlerEconomy.setText(selectBowler.Econ);
            firstInningsJFrame.curBowlerMaidens.setText(selectBowler.Maidens);
            firstInningsJFrame.curBowlerOver.setText(selectBowler.Overs);
            firstInningsJFrame.curBowlerRun.setText(selectBowler.Bruns);
            firstInningsJFrame.curBowlerWickets.setText(selectBowler.Wicket); 
        dispose();
        
    }//GEN-LAST:event_selectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set  the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(selectBowler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectBowler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectBowler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectBowler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selectBowler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bowlerJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton select;
    // End of variables declaration//GEN-END:variables
}