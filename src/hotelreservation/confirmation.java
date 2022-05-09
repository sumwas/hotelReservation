/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation;



import static hotelreservation.customerInfo.selectedRoomType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 12137
 */

/**
Public Class Confirmation
April 8, 2022
Lissett Laguna
The following includes the parameter tags and the constructor to receive the data for first name, last name, guest number, phone number, email, and confirmation number.
These values were received through the customer input, and the reservation number was generated through the push of the button on the customerInfo page
We wanted to take the customer input and display it right away since it would be the same information being put into the excel file anyways, this was done for the sake of keeping things more simple for the time being
**/
public class confirmation extends javax.swing.JFrame {    
    
private String firstName;
private String lastName;
private String guestNum;
private String phoneNumber;
private String emailAddress;

int selectedCheckIn; 
int selectedCheckOut;
int confirmationNum;  
  
static String selectedRoomType;

int totalPrice;
int roomPrice;
int dayCount;
int features;  
  
String checkIn;
String checkOut;

int monthIn;
int dayIn;
int yearIn;

 String finalCheckIn;
 String finalCheckOut;
 
 String cardName;
 String cardNum;
 String cardExp;
 String cardCvc;
 
 boolean check;
 
    /**
     * Creates new form confirmation
     * @param first
     * @param last
     * @param guest
     * @param phone
     * @param email
     * @param number
     * @param type
     * @param dateIn
     * @param dateOut
     * @param total
     * @param roomAmount
     * @param days
     * @param feats
     * @param timeIn
     * @param timeOut
     * @param cardName
     * @param cardNum
     * @param cardExp
     * @param cVc
     * @param month
     * @param day
     * @param year
     */
   // public confirmation() {
     //   initComponents();
    //}
        //information will be set to the jlabel it is assigned     
        public confirmation(String first, String last, String guest, String phone, String email, int number, String type, String dateIn, String dateOut, int total, int roomAmount, int days, int feats, String timeIn, String timeOut){
        initComponents();
        nameHolder.setText(first);
        lastNameHolder.setText(last);
        guestHolder.setText(guest);
        phoneHolder.setText(phone);
        emailHolder.setText(email);
      //  resNumber.setText(number + "");
        selectedRoomHolder.setText(type);
      //  checkInHolder.setText(dateIn);
      //  checkOutHolder.setText(dateOut);
        totalPriceHolder.setText("$" + total );
        roomPriceHolder.setText("$" + roomAmount);
        dayCountHolder.setText("" +days);
        featurePriceHolder.setText("$" + feats);
    //    monthInHolder.setText("" +month);
      //  dayInHolder.setText("" +day);
        //yearInHolder.setText("" +year);
        checkInHolder.setText(""+timeIn);
        checkOutHolder.setText(""+timeOut);
      //  checkIn = dateIn;
       // checkOut = dateOut;
        
        selectedRoomType = type;
        firstName = first;
        lastName = last;
        guestNum = guest;
        phoneNumber = phone;
        emailAddress = email;
       finalCheckIn = timeIn;
       finalCheckOut = timeOut;
       confirmationNum = number;
        totalPrice = total;
        roomPrice = roomAmount;
        dayCount = days;
        features = feats;

        
      //cardHolder.setText(cardNumber);
       
    }

    private confirmation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
     
    public static void writeToFile(String first, String last, String guest, String phone, String email, int number, String type, String timeIn, String timeOut, int total, int roomAmount, int days, int feats, String in, String out, String cName, String cNum, String cExp, String cardC) throws FileNotFoundException, IOException{
        //opening excel file
        String excelFilePath = "hotel_info.xlsx";
        File file = new File(excelFilePath); 
            try (FileInputStream excelFile = new FileInputStream(file)) {
                
                XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
                XSSFSheet sheet = workbook.getSheet("Sheet1"); 
                                
                int lastRow = sheet.getLastRowNum();
                //last row needs to be incremted, otherwise will overwrite
                lastRow++;
                Row row = sheet.createRow(lastRow);
               
                Cell entry0 = row.createCell(0);
                entry0.setCellValue(first);
                
                Cell entry1 = row.createCell(1);
                entry1.setCellValue(last);
                
                Cell entry2 = row.createCell(2);
                entry2.setCellValue(guest);
                
                Cell entry3 = row.createCell(3);
                entry3.setCellValue(phone);
                
                Cell entry4 = row.createCell(4);
                entry4.setCellValue(email);
                
                
                Cell entry5 = row.createCell(5);
                entry5.setCellValue(in); 
                
                Cell entry6 = row.createCell(6);
                entry6.setCellValue(out);
                
                Cell entry7 = row.createCell(7);
                entry7.setCellValue(lastRow);
                
                Cell entry9 = row.createCell(9);
                entry9.setCellValue(type);
                
                Cell entry10= row.createCell(10);
                entry10.setCellValue(total);
                
                Cell entry11 = row.createCell(11);
                entry11.setCellValue(roomAmount);
                
                Cell entry12 = row.createCell(12);
                entry12.setCellValue(days);
                
                Cell entry13 = row.createCell(13);
                entry13.setCellValue(feats);    
                
                 Cell entry14 = row.createCell(14);
                entry14.setCellValue(cName);   
                            
                Cell entry15 = row.createCell(15);
                entry15.setCellValue(cNum);
                
               Cell entry16 = row.createCell(16);
                entry16.setCellValue(cExp);
                
                Cell entry17 = row.createCell(17);
                entry17.setCellValue(cardC);
                
                excelFile.close();
                
                //this is what writes/saves the file
                FileOutputStream outFile = new FileOutputStream(new File(excelFilePath));
                workbook.write(outFile);
                outFile.close();
                
            }
    }

    
    
    
    
    
    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    
    
    public static int getLastRow() throws FileNotFoundException, IOException{
        String excelFilePath = "hotel_info.xlsx";
        File file = new File(excelFilePath);
        //int number = Integer.parseInt(num);
        int lastrow;
        //DataFormatter formatter = new DataFormatter();
        try (FileInputStream excelFile = new FileInputStream(file)) {
                
                XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
                XSSFSheet sheet = workbook.getSheet("Sheet1"); 
                lastrow = sheet.getLastRowNum();
                excelFile.close();
                
            try ( //this is what writes/saves the file
                    FileOutputStream outFile = new FileOutputStream(new File(excelFilePath))) {
                workbook.write(outFile);
            }
                
        }
        return lastrow;
    }
    
    
   
    
    
    
 //   confirmation(String firstName, String lastName, String guestNum, String phoneNumber, String emailAddress, int confirmationNum) {
  //      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  //  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        holder = new javax.swing.JLabel();
        Holderlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameHolder = new javax.swing.JLabel();
        lastNameHolder = new javax.swing.JLabel();
        guestHolder = new javax.swing.JLabel();
        phoneHolder = new javax.swing.JLabel();
        emailHolder = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        enterCardName = new javax.swing.JFormattedTextField();
        enterCardNum = new javax.swing.JFormattedTextField();
        enterCardExp = new javax.swing.JFormattedTextField();
        enterCardCvc = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        checkInHolder = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        checkOutHolder = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        writeButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        totalPriceHolder = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        selectedRoomHolder = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        roomPriceHolder = new javax.swing.JLabel();
        featurePriceHolder = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dayCountHolder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(100, 100));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(456, 640));

        holder.setText("First Name");

        Holderlabel.setText("Last Name");

        jLabel1.setText("Guest Number");

        jLabel2.setText("Phone Number");

        jLabel3.setText("Email");

        nameHolder.setText("jLabel6");

        lastNameHolder.setText("jLabel7");

        guestHolder.setText("jLabel8");

        phoneHolder.setText("jLabel9");

        emailHolder.setText("jLabel10");

        jLabel4.setText("Please enter payment information:");

        jLabel5.setText("Name on card");

        jLabel6.setText("Card Number");

        jLabel7.setText("Card Exp.");

        jLabel8.setText("Card Cvc");

        try {
            enterCardNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        enterCardNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterCardNumActionPerformed(evt);
            }
        });

        try {
            enterCardExp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            enterCardCvc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        enterCardCvc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterCardCvcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enterCardName)
                            .addComponent(enterCardNum, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(enterCardCvc)
                            .addComponent(enterCardExp, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(enterCardName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(enterCardNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(enterCardExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(enterCardCvc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Check In");

        checkInHolder.setText("checkIn");

        jLabel10.setText("Check Out");

        checkOutHolder.setText("checkOut");

        writeButton.setText("Finish");
        writeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeButtonActionPerformed(evt);
            }
        });

        jLabel13.setText("Total:");

        totalPriceHolder.setText("totalPrice");

        jLabel15.setText("Room Selection");

        selectedRoomHolder.setText("selectedRoomType");

        jLabel14.setText("Price per night:");

        jLabel16.setText("Features: ");

        roomPriceHolder.setText("roomPrice");

        featurePriceHolder.setText("featurePrice");

        jLabel17.setText("Night stay");

        dayCountHolder.setText("dayCount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectedRoomHolder)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dayCountHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalPriceHolder)
                    .addComponent(featurePriceHolder)
                    .addComponent(roomPriceHolder))
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(checkInHolder))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkOutHolder)
                                    .addComponent(jLabel10))
                                .addGap(176, 176, 176))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Holderlabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(holder, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(phoneHolder)
                                                .addComponent(emailHolder))
                                            .addComponent(guestHolder)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lastNameHolder, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(nameHolder))))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(writeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(holder)
                    .addComponent(nameHolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Holderlabel)
                    .addComponent(lastNameHolder))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(guestHolder))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(phoneHolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailHolder))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkInHolder))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkOutHolder)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(roomPriceHolder))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(featurePriceHolder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(totalPriceHolder)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedRoomHolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(dayCountHolder))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(writeButton)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterCardCvcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterCardCvcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterCardCvcActionPerformed

    private void enterCardNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterCardNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterCardNumActionPerformed

    private void writeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeButtonActionPerformed
        // TODO add your handling code here:
        
        cardName = enterCardName.getText().trim();
        cardNum = enterCardNum.getText().trim(); 
        cardExp = enterCardExp.getText().trim();
        cardCvc = enterCardCvc.getText().trim();
        
        
         //Check for empty fields, else write user info to file
        if(cardName.isEmpty() || cardNum.isEmpty() || cardExp.isEmpty() || cardCvc.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter all text fields!", "Error", JOptionPane.ERROR_MESSAGE);
                check = false;
                System.out.println(check);
        }
        
        else{
            try {
                writeToFile(firstName, lastName, guestNum, phoneNumber, emailAddress, confirmationNum, selectedRoomType, checkIn, checkOut, totalPrice, roomPrice, dayCount, features, finalCheckIn, finalCheckOut, cardName, cardNum, cardExp, cardCvc);
                confirmationNum = getLastRow();
                check = true;

                //linking confirmation page, dependent
                new completeProcess(confirmationNum, selectedRoomType, finalCheckIn, finalCheckOut).setVisible(true);
                this.setVisible(false);
                System.out.println(check);
        
            
            } catch (IOException ex) {
                Logger.getLogger(customerInfo.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        
        
                        //linking confirmation page, dependent
             //   new completeProcess(firstName, lastName, guestNum, phoneNumber, emailAddress, confirmationNum).setVisible(true);
             //   this.setVisible(false);
        
    }//GEN-LAST:event_writeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new confirmation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Holderlabel;
    private javax.swing.JLabel checkInHolder;
    private javax.swing.JLabel checkOutHolder;
    private javax.swing.JLabel dayCountHolder;
    private javax.swing.JLabel emailHolder;
    private javax.swing.JFormattedTextField enterCardCvc;
    private javax.swing.JFormattedTextField enterCardExp;
    private javax.swing.JFormattedTextField enterCardName;
    private javax.swing.JFormattedTextField enterCardNum;
    private javax.swing.JLabel featurePriceHolder;
    private javax.swing.JLabel guestHolder;
    private javax.swing.JLabel holder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lastNameHolder;
    private javax.swing.JLabel nameHolder;
    private javax.swing.JLabel phoneHolder;
    private javax.swing.JLabel roomPriceHolder;
    private javax.swing.JLabel selectedRoomHolder;
    private javax.swing.JLabel totalPriceHolder;
    private javax.swing.JButton writeButton;
    // End of variables declaration//GEN-END:variables
}
