/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelreservation;

import static hotelreservation.customerInfo.selectedRoomType;
import java.io.File;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;  
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import javax.swing.*;

/**
 *
 * @author Lissett
 */
public class completeProcess extends javax.swing.JFrame {
    
    private String firstName;
private String lastName;
private String guestNum;
private String phoneNumber;
private String emailAddress;
private String checkIn;
private String checkOut;
int selectedCheckIn; 
int selectedCheckOut;
static int confirmationNum;  
  
 int roomNum; 
  
static String selectedRoomType;

int totalPrice;
int roomPrice;
int dayCount;
int features;  
  
int monthIn;
int dayIn;
int yearIn;

static String finalCheckIn;
static String finalCheckOut;
 
 String cardName;
 String cardNum;
 String cardExp;
 String cardCvc;
  
  

    /**
     * Creates new form completeProcess
     */

  /**
   * 
   * @param fName
   * @param lName
   * @param gNum
   * @param phone
   * @param email
   * @param number
   * @param first
   * @param last
   * @param guest
   * @param phone
   * @param email
   * @param number
   * @param type
   * @param dateIn
   * @param dateOut
     * @param cName
     * @param cNum
     * @param cardEx
     * @param cardC
   * @param total
   * @param roomAmount
   * @param days
   * @param feats
   * @param timeIn
   * @param timeOut 
   */
 
 
 
 /**
  * 
  * @param Cnumber
  * @param roomType
  * @param checkin
  * @param checkout
  * @throws IOException 
  */
 public completeProcess(int Cnumber, String roomType, String checkin, String checkout) throws IOException {
     initComponents();
     confirmationNum = Cnumber;
     selectedRoomType = roomType;
     finalCheckIn = checkin;
     finalCheckOut = checkout;
     roomNum = insertInSchedule(confirmationNum, selectedRoomType, finalCheckIn, finalCheckOut);
     resNumHolder.setText("" + roomNum);
     resNumHolder1.setText(""+confirmationNum);
 }
         
 /*
    public completeProcess(String first, String last, String guest, String phone, String email, int number, String type, String dateIn, String dateOut, int total, int roomAmount, int days, int feats, String timeIn, String timeOut, String cName, String cNum, String cardEx, String cardC) {
        initComponents();
               firstName = first;
               lastName = last;
               guestNum = guest;
               phoneNumber = phone;
               emailAddress = email;
               resNumHolder.setText("" + number);
               selectedRoomType = type;
                checkIn = dateIn;
                checkOut = dateOut;
                totalPrice = total;
                roomPrice = roomAmount;
                dayCount = days;
                features = feats;
                finalCheckIn = timeIn;
                finalCheckOut = timeOut;
                cardName = cName;
                cardNum = cNum;
                cardExp = cardEx;
                cardCvc = cardC;
    }

 
 */
 /**
 * 
 * @param confirmationNumber
 * @param roomType
 * @return 
 */
    public static int insertInSchedule(int confirmationNumber, String roomType, String checkinDate, String checkoutDate) throws FileNotFoundException, IOException{
        String excelFilePath = "Hotel_Schedule.xlsx";
        File file = new File(excelFilePath);
        DataFormatter formatter = new DataFormatter();
        
        int roomNum = 1;
        int startingRow = 1;
        int endingRow = 15;
        int startingCol = 1;
        int endingCol = 7;
        boolean found = true;
        int done = 0;
        
        if ("Double Queen Beds".equals(roomType)){
            startingRow = 1;
            endingRow = 5;
        }
        else if ("King Bed with Balcony".equals(roomType)){
            startingRow = 6;
            endingRow = 10;
        }
        else if ("King Bed with Lakeview".equals(roomType)){
            startingRow = 11;
            endingRow = 15;
        }
        if ("5-9-2022".equals(checkinDate)){
            startingCol = 1;
        }
        else if ("5-10-2022".equals(checkinDate)){
            startingCol = 2;
        }
        else if ("5-11-2022".equals(checkinDate)){
            startingCol = 3;
        }
        else if ("5-12-2022".equals(checkinDate)){
            startingCol = 4;
        }
        else if ("5-13-2022".equals(checkinDate)){
            startingCol = 5;
        }
        else if ("5-14-2022".equals(checkinDate)){
            startingCol = 6;
        }
        if ("5-10-2022".equals(checkoutDate)){
            endingCol = 2;
        }
        else if ("5-11-2022".equals(checkoutDate)){
            endingCol = 3;
        }
        else if ("5-12-2022".equals(checkoutDate)){
            endingCol = 4;
        }
        else if ("5-13-2022".equals(checkoutDate)){
            endingCol = 5;
        }
        else if ("5-14-2022".equals(checkoutDate)){
            endingCol = 6;
        }
        else if ("5-15-2022".equals(checkoutDate)){
            endingCol = 7;
        }
        //if roomType 1 then search rows 0-4
        //else if roomType 2 then search 5-9
        //else if roomType 3 then search 10 - 14
        //endingRow = (5*roomType)-1;
        //startingRow = endingRow - 4;
        /*if (startingRow == 6){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Your reservation was canceled");
        }*/
        try (FileInputStream excelFile = new FileInputStream(file)) {
                
                XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
                XSSFSheet sheet = workbook.getSheet("Sheet1"); 
                
                while (done == 0 && startingRow<=endingRow) {
                    int j = startingCol;
                    while (j < endingCol && found == true){
                        Cell cell = sheet.getRow(startingRow).getCell(j);
                        if (cell == null || Objects.equals(formatter.formatCellValue(cell), "")){
                            found = true;
                        }
                        else {
                            found = false;
                        }
                        j++;
                    }
                    if (found == true){
                        roomNum = startingRow;
                        done = 1;
                    }
                    startingRow++;
                }
                for (int i = startingCol; i<endingCol; i++ ){
                    //Cell cell = sheet.getRow(roomNum).getCell(i);
                    //cell.setCellValue(confirmationNumber);
                    Row row = sheet.createRow(roomNum);
                    Cell entry0 = row.createCell(i);
                    entry0.setCellValue(confirmationNumber);
                }
                
                
        }
        return roomNum;
    }
  //  completeProcess(String firstName, String lastName, String guestNum, String phoneNumber, String emailAddress, int confirmationNum) {
  //      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  //  }

    /*private static void getRoomType() throws IOException{
        int roomNumber = insertInSchedule(confirmationNum, selectedRoomType, finalCheckIn, finalCheckOut);
        resNumHolder.setText("" + Cnumber);
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        resNumHolder = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        resNumHolder1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Thank you");

        jLabel2.setText("Here is your room number: ");

        resNumHolder.setText("resNum");

        jButton1.setText("Back to Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Here is your confirmation number: ");

        resNumHolder1.setText("resNum");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(resNumHolder))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(resNumHolder1)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(resNumHolder))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(resNumHolder1))
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new welcome().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(completeProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(completeProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(completeProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(completeProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        //getRoomType();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        //        new completeProcess().setVisible(true);
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel resNumHolder;
    private javax.swing.JLabel resNumHolder1;
    // End of variables declaration//GEN-END:variables
}
