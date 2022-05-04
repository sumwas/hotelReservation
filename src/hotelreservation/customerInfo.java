/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation;

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
public class customerInfo extends javax.swing.JFrame {

//From customerInfo
private String firstName;
private String lastName;
private String guestNum;
private String phoneNumber;
private String emailAddress;


  int confirmationNum;      

  //From hotelRoom page
  static String selectedRoomType;
  
int selectedCheckIn; 
int selectedCheckOut;

String checkIn;
String checkOut;
int totalPrice;
int roomPrice;
int dayCount;
  
  //From selecting_room
String outMsg;

  
  
  
      public customerInfo(String selection, String dateIn, String dateOut, int total, int roomAmount, int days) {
        initComponents();
        selectedRoomType = selection;
        checkIn = dateIn;
        checkOut = dateOut;
        totalPrice = total;
        roomPrice = roomAmount;
        dayCount = days;
      // customerInfo = info;
       // numGenerate = number; 
    }
      
      
      
/**a)customerInfo
 * b)04/14/2022
 * c)Margarita, Summayah
 * d)This class allows users to enter their information which is then filed
 * into a master excel sheet of all reservations made
 * e)Important functions in this class: getCheckInDates, getCheckOutDates,
 * writeToFile, getLastRow
 */


    public customerInfo() {
        initComponents();
        /*Calling getCheckInDates(), iterating through arrayList to create 
        array to set in check-in comboBox */
        /*
            ArrayList checkInDays = getCheckInDates();
            String[] checkInDaysArray = new String[checkInDays.size()];
                for(int i = 0; i < checkInDays.size(); i++){
                    checkInDaysArray[i] = checkInDays.get(i).toString() + " ";
                }
            checkInCombo.setModel(new javax.swing.DefaultComboBoxModel<>(checkInDaysArray)); 
        */
    }
    

    /** getCheckIn dates creates an ArrayList of the valid check in dates for 
     * the user starting with the current date (today's date) until Saturday
     * of the same week
     * @return the ArrayList with the check out dates, as specified
     */
/*
    public static ArrayList getCheckInDates(){
        ArrayList currentWeek = new ArrayList(); 
        LocalDate localDate = LocalDate.now();
        LocalDate sunday = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)); 
            //while condition increments current day by 1 day
            //adding all the days that are before sunday to the array
            while(localDate.isBefore(sunday)){
                currentWeek.add(localDate.format(DateTimeFormatter.ofPattern("MMM dd,yyyy ")));
                localDate = localDate.plusDays(1);
            }    
       return currentWeek; 
    }
    */
    
    
    /** getCheckOutDates method determines valid user dates for checking out,
     * starting at the selectedCheckIn + 1. 
     * @param selectedCheckIn is an int representing the day of the week 
     * selected where an int, 1-7, represent the specific day of the week, Mon-
     * Sunday.
     * 
    */
/*
    public void getCheckOutDates(int selectedCheckIn){
        ArrayList validDatesArrayList = new ArrayList();
        LocalDate validCheckOut = LocalDate.now().plusDays(selectedCheckIn);
        LocalDate sunday = validCheckOut.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
            //adding dates to the arrayList
            while(validCheckOut.isBefore(sunday)){
                validCheckOut = validCheckOut.plusDays(1);
                validDatesArrayList.add(validCheckOut.format(DateTimeFormatter.ofPattern("MMM dd,yyyy ")));
            }
        String[] validDatesArray = new String[validDatesArrayList.size()];
            //converting arrayList to string[]
            for(int i = 0; i < validDatesArrayList.size(); i++){
                validDatesArray[i] = validDatesArrayList.get(i).toString() + " ";
            }  
        checkOutCombo.setModel(new javax.swing.DefaultComboBoxModel<>(validDatesArray));
    }
    
 */   
    
    /** writeToFile method is called when user click button, and its purpose is
     * taking the users input and writing it to the next available row
     * in the excel sheet (containing all reservations made)
     * @param first is the users input string for their first name
     * @param last is the users input string for their first name
     * @param numOfGuest is the users input string for the number of guests
     * @param phone is the users input string for their phone number
     * @param email is the users input string for their email
     * @param inDate is the users selected check in date
     * @param outDate is the users selected check out date
     * @throws FileNotFoundException
     * @throws IOException
     */
    
    
    
    
    /*
    public static void writeToFile(String first, String last, String numOfGuest, String phone, String email, String inDate, String outDate) throws FileNotFoundException, IOException{
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
                entry2.setCellValue(numOfGuest);
                
                Cell entry3 = row.createCell(3);
                entry3.setCellValue(phone);
                
                Cell entry4 = row.createCell(4);
                entry4.setCellValue(email);
                
                Cell entry5 = row.createCell(5);
                entry5.setCellValue(inDate);
                
                Cell entry6 = row.createCell(6);
                entry6.setCellValue(outDate);
                
                Cell entry7 = row.createCell(7);
                entry7.setCellValue(lastRow);
                
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
    
    /*
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
    
    */
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField7 = new javax.swing.JFormattedTextField();
        customerInputPanel = new javax.swing.JPanel();
        enterInfo = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        phoneNumLabel = new javax.swing.JLabel();
        emailAddLabel = new javax.swing.JLabel();
        checkInLabel = new javax.swing.JLabel();
        checkOutLabel = new javax.swing.JLabel();
        guestNumLabel = new javax.swing.JLabel();
        enterFirstName = new javax.swing.JFormattedTextField();
        confirmationButton = new java.awt.Button();
        enterLastName = new javax.swing.JFormattedTextField();
        enterGuestNum = new javax.swing.JFormattedTextField();
        enterEmailAddress = new javax.swing.JFormattedTextField();
        enterPhoneNumber = new javax.swing.JFormattedTextField();

        jFormattedTextField3.setText("jFormattedTextField1");
        jFormattedTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField3ActionPerformed(evt);
            }
        });

        jFormattedTextField7.setText("jFormattedTextField1");
        jFormattedTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField7ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enterInfo.setText("To begin, enter the following information:");

        firstNameLabel.setText("First name:");

        lastNameLabel.setText("Last name:");

        phoneNumLabel.setText("Phone number:");

        emailAddLabel.setText("Email address: ");

        checkInLabel.setText("Check-in date:");

        checkOutLabel.setText("Check out date:");

        guestNumLabel.setText("Number of guests:");

        enterFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterFirstNameActionPerformed(evt);
            }
        });

        confirmationButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmationButton.setLabel("Confirm Your Reservation");
        confirmationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmationButtonActionPerformed(evt);
            }
        });

        enterLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterLastNameActionPerformed(evt);
            }
        });

        enterGuestNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        enterGuestNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterGuestNumActionPerformed(evt);
            }
        });

        enterEmailAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterEmailAddressActionPerformed(evt);
            }
        });

        try {
            enterPhoneNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        enterPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterPhoneNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerInputPanelLayout = new javax.swing.GroupLayout(customerInputPanel);
        customerInputPanel.setLayout(customerInputPanelLayout);
        customerInputPanelLayout.setHorizontalGroup(
            customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInputPanelLayout.createSequentialGroup()
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerInputPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(customerInputPanelLayout.createSequentialGroup()
                                    .addComponent(guestNumLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(enterGuestNum, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(customerInputPanelLayout.createSequentialGroup()
                                    .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(firstNameLabel)
                                        .addComponent(lastNameLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(enterLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enterFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(customerInputPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(enterInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customerInputPanelLayout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(checkOutLabel))))
                    .addGroup(customerInputPanelLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(confirmationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(customerInputPanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerInputPanelLayout.createSequentialGroup()
                        .addComponent(phoneNumLabel)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerInputPanelLayout.createSequentialGroup()
                        .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkInLabel)
                            .addComponent(emailAddLabel))
                        .addGap(18, 18, 18)))
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerInputPanelLayout.createSequentialGroup()
                        .addComponent(enterPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(customerInputPanelLayout.createSequentialGroup()
                        .addComponent(enterEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        customerInputPanelLayout.setVerticalGroup(
            customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enterFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLabel))
                .addGap(26, 26, 26)
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enterLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel))
                .addGap(26, 26, 26)
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enterGuestNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guestNumLabel))
                .addGap(26, 26, 26)
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enterEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddLabel))
                .addGap(44, 44, 44)
                .addGroup(customerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkInLabel)
                    .addComponent(checkOutLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(confirmationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customerInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customerInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jFormattedTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField3ActionPerformed

    private void jFormattedTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField7ActionPerformed

    private void enterFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterFirstNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_enterFirstNameActionPerformed

    private void confirmationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmationButtonActionPerformed

        /* TODO add your handling code here:
            Getting customer info via button click, text is being 
            stored in declared variable by variable = textfieldboxname.getText()*/
        firstName = enterFirstName.getText().trim();
        lastName = enterLastName.getText().trim();
        guestNum = enterGuestNum.getText().trim(); 
        phoneNumber = enterPhoneNumber.getText().trim();
        emailAddress = enterEmailAddress.getText().trim();
        
        /*
        //Check for empty fields, else write user info to file
        if(firstName.isEmpty() || lastName.isEmpty() || guestNum.isEmpty() 
           || phoneNumber.isEmpty() || emailAddress.isEmpty() || checkOutCombo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Please enter all text fields!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            try {
                writeToFile(firstName,lastName, guestNum, phoneNumber,emailAddress,checkIn,checkOut);
                int confirmationNum = getLastRow();

            
                //linking confirmation page, dependent
                new confirmation(firstName, lastName, guestNum, phoneNumber, emailAddress, confirmationNum).setVisible(true);
                this.setVisible(false);
        
            
            } catch (IOException ex) {
                Logger.getLogger(customerInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */
        
                //linking confirmation page, dependent
                new confirmation(firstName, lastName, guestNum, phoneNumber, emailAddress, confirmationNum, selectedRoomType, checkIn, checkOut, totalPrice, roomPrice, dayCount).setVisible(true);
                this.setVisible(false);
        
    
    /*links this panel to hotelRoom via button click
    confirmation confirm = new confirmation();
    confirm.show();
    dispose();*/
    }//GEN-LAST:event_confirmationButtonActionPerformed

    private void enterLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterLastNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_enterLastNameActionPerformed

    private void enterGuestNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterGuestNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterGuestNumActionPerformed

    private void enterEmailAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterEmailAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterEmailAddressActionPerformed

    private void enterPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterPhoneNumberActionPerformed

    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     * @throws java.lang.reflect.InvocationTargetException
     */
    
    public static void main(String args[]) throws IOException, InterruptedException, InvocationTargetException {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new customerInfo().setVisible(true);
            } 
        });
        
        
        
         
       
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel checkInLabel;
    private javax.swing.JLabel checkOutLabel;
    private java.awt.Button confirmationButton;
    private static javax.swing.JPanel customerInputPanel;
    private javax.swing.JLabel emailAddLabel;
    private javax.swing.JFormattedTextField enterEmailAddress;
    private javax.swing.JFormattedTextField enterFirstName;
    private javax.swing.JFormattedTextField enterGuestNum;
    private javax.swing.JLabel enterInfo;
    private javax.swing.JFormattedTextField enterLastName;
    private javax.swing.JFormattedTextField enterPhoneNumber;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel guestNumLabel;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField7;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel phoneNumLabel;
    // End of variables declaration//GEN-END:variables
}
