/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelreservation;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import javax.swing.*;

/**
 * Public Class Check Reservation 
 * @author Summayah Waseem
 * User interface has 2 text fields for the user to input their last name and their confirmation number. This class
 * takes the confirmationNumber given to the user and uses it to find the users information in the hotel_info excel
 * sheet. It matches the confirmation number inside the excel sheet and then pulls up the information of the customer
 * Imports apache poi libraries to help handle, read, and write the excel sheet. to learn more: https://poi.apache.org/
 */
public class checkReservation extends javax.swing.JFrame {

    /**
     * Creates new form confirmReservation
     */
    private String lastName;
    private String confirmationNumber;
    
    /**
     *
     */
    public checkReservation() {
        initComponents();
    }
        /**
         * readExcelFile
         * @param num
         * @param last
         * @throws FileNotFoundException
         * @throws IOException 
         * searches excel file using confirmation number. if found pulls information of the reservation off excel sheet
         */
        public static void readExcelFile(String num, String last) throws FileNotFoundException, IOException{
        String excelFilePath = "hotel_info.xlsx";
        File file = new File(excelFilePath);
        DataFormatter formatter = new DataFormatter();
        try (FileInputStream excelFile = new FileInputStream(file)) {
                
                XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
                XSSFSheet sheet = workbook.getSheet("Sheet1"); 
                int lastrow = sheet.getLastRowNum();
                int done = 0;
                for (int i = 0; i<= lastrow; i++){
                     Cell cell_confirm_num = sheet.getRow(i).getCell(7);
                     Cell cell_first_name = sheet.getRow(i).getCell(0);
                     Cell cell_last_name = sheet.getRow(i).getCell(1);
                     Cell cell_checkin_date = sheet.getRow(i).getCell(5);
                     Cell cell_checkout_date = sheet.getRow(i).getCell(6);
                     if (Objects.equals(formatter.formatCellValue(cell_confirm_num), num)){
                         Cell cell_reserve = sheet.getRow(i).getCell(8);
                         if (Objects.equals(formatter.formatCellValue(cell_reserve), "F")) {
                             //no reservation 
                             JFrame jFrame = new JFrame();
                             JOptionPane.showMessageDialog(jFrame, "Your reservation was canceled");
                         }
                         else {
                             //yes reservation 
                             //pull up info 
                             //pull up check reservation info page 
                             //String info = cell_info.getStringCellValue();
                             JFrame jFrame = new JFrame();
                             JOptionPane.showMessageDialog(jFrame, "Hi " + cell_first_name + " " + cell_last_name + "! " + "Your reservation is from " + cell_checkin_date + " to " + cell_checkout_date );
                             
                             //new checkReservationConfirm().setVisible(true);
                             
                         }
                         done = 1;
                         
                     }
                }
                if (done == 0){
                    // regirstation number not found
                     JFrame jFrame = new JFrame();
                     JOptionPane.showMessageDialog(jFrame, "No reservation found");
                }
                excelFile.close();
                
            try ( //this is what writes/saves the file
                    FileOutputStream outFile = new FileOutputStream(new File(excelFilePath))) {
                workbook.write(outFile);
            }
                
        }
        
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterLastName = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        enterConfirmationNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enterLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterLastNameActionPerformed(evt);
            }
        });

        cancel.setText("Check Reservation");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Confirmation Number:");

        enterConfirmationNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterConfirmationNumberActionPerformed(evt);
            }
        });

        jLabel2.setText("Last Name:");

        jButton1.setText("Back to Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterConfirmationNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(267, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterConfirmationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterLastNameActionPerformed
        // TODO add your handling code here:
        lastName = enterLastName.getText();
    }//GEN-LAST:event_enterLastNameActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        /**
         * gets confirmation number and last name 
         * calls readExcelFile
         */
        confirmationNumber = enterConfirmationNumber.getText();
        lastName = enterLastName.getText();
        try {
            readExcelFile(confirmationNumber, lastName);
        } catch (IOException ex) {
            Logger.getLogger(cancelRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cancelActionPerformed

    private void enterConfirmationNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterConfirmationNumberActionPerformed
        // TODO add your handling code here:
        //confirmationNumber = enterConfirmationNumber.getText();
    }//GEN-LAST:event_enterConfirmationNumberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new welcome().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(checkReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(checkReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(checkReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(checkReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new checkReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField enterConfirmationNumber;
    private javax.swing.JTextField enterLastName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
