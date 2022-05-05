/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation;


import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 12137
 * 
 Provide a complete summary for each module/class header: include 
Module name or Class name in the Design:  hotelRooms.java
Date of the code 
Programmer's name: Yashira Almanza, Margarita
Brief description of the class/module: 
The customer will be able to select the room of their choice, and they would be able to select the dates of their check-in and check-out. 
Brief explanation of important functions in each class, including its input values and output values 
Select a room - The customer will be able to select the room, and for each selection the price will appear and they will be asked if they want to confirm the room, and if yes, it will go to the excel database. 
any important data structure in class/methods 
doubleBedsSelectedActionPerformed()
KingLakeSelectedActionPerformed()
KingbedwithbalconyActionPerformed()
* I have also used GUI for the customer to interact with the page for example to select the room, and the customer has to decide of they want to confirm the room or not
* if they confirm the room, then the data will go to the excel database.  
briefly describe any algorithm that you may have used and why did you select it upon other algorithms where more than one option exists.
* For each action performed, it will show the price and interact with the customer. 
* 

 */
public class hotelRooms extends javax.swing.JFrame {

//attributes
String outMsg;
int selectedCheckIn;
int selectedCheckOut;
ArrayList checkInArrayList;
ArrayList checkOutArrayList;
ArrayList roomsArrayList;

static String selectedRoomType;
//String checkIn;
//String checkOut;
int totalPrice;
int roomPrice;
int dayCount;

int monthIn;
int dayIn;
int yearIn;
int monthOut;
int dayOut;

String finalCheckIn;
String finalCheckOut;
    /**
     * Creates new form hotelRooms
     */
    public hotelRooms() {
        initComponents();
        getCheckInDates();
    }
    
    @SuppressWarnings("unchecked")
        /* Method for Check IN Date list*/
    
/** getCheckOutDates adds LocateDate items into the checkOutCombo JComboBox
 * which are based on the index of the selectedCheckIn date - plus 1 day to make
 * the check out dates valid. The checkInIndex is through the actions of 
 * selecting the check in date.
 */
 public void getCheckOutDates(int checkInIndex){
        LocalDate validCheckOut = LocalDate.now().plusDays(checkInIndex);
        LocalDate sunday = validCheckOut.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));            
            while(validCheckOut.isBefore(sunday)){
                validCheckOut = validCheckOut.plusDays(1);
                checkOutCombo.addItem(validCheckOut);   
            }
    }
/** getCheckInDates is a void method that adds LocalDates items into the 
 * the checkInCombo JComboBox. The LocalDates listed start with initial date(today) 
 * up to Sunday of the same week. This method is called in the constructor. 
 */
public static void getCheckInDates(){
    LocalDate validCheckIn = LocalDate.now();
    LocalDate sunday = validCheckIn.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)); 
        //while loop increments by one day while the current day is before sunday
        //adding all the days that are before sunday to the array
        while(validCheckIn.isBefore(sunday)){
            checkInCombo.addItem(validCheckIn);
            validCheckIn = validCheckIn.plusDays(1);                
            }    
    }

/** setFalse method is setting all the radio selection buttons to false,
 *  meaning the buttons are not available for selection by the user.
 */
public void setFalse(){
    doubleLakeSelected.getModel().setEnabled(false);
    kingBalconySelected.getModel().setEnabled(false);
    kingLakeSelected.getModel().setEnabled(false); 
}
/** booleanRoomSelection: determines which radio buttons
 * will be set to true which will allow user to select button
 * @param allRoomsAvailable is an ArrayList of objects of the rooms available
 * based on the dates selected by the user. setFalse method is called initially 
 * reset all radio buttons that may have previously been set to true
 */
 public void booleanRoomSelection(ArrayList allRoomsAvailable){
    List<Integer> roomsList = new ArrayList<>(allRoomsAvailable);
    boolean[] roomsTypesAvailable = new boolean[]{false,false,false};
    setFalse();
        /*using boolean array as flags to check that button has already 
        been made available*/
        for(int i = 0; i < roomsList.size(); i++){
                if(roomsList.get(i) < 5 && roomsTypesAvailable[0] == false){
                    roomsTypesAvailable[0] = true;
                    doubleLakeSelected.getModel().setEnabled(true);
                }
                    else if(roomsList.get(i) > 5 && roomsList.get(i) <= 10 && roomsTypesAvailable[1] == false){
                    roomsTypesAvailable[1] = true;
                    kingBalconySelected.getModel().setEnabled(true);
                }
                else if(roomsList.get(i) > 10 && roomsTypesAvailable[2] == false){
                    roomsTypesAvailable[2] = true;
                    kingLakeSelected.getModel().setEnabled(true);
                }
        }   
 }  

/** searchRoomAvailability: will open weekly Hotel_Schedule file, where the 
 * method will loop through only the specified dates which the user has selected
 * which are reflective of the rows, cols and cells in the file - additionally 
 * will store the room (equal to the row number) into an ArrayList. Note that
 * selectedDayOfWeek reflects a number 1 to 7 that reflects the day of the week
 * where Monday = 1, Tuesday = 2, etc. 
 * @return roomsArrayList which contains available rooms based on selected dates
 * @throws FileNotFoundException
 * @throws IOException 
 */
public ArrayList searchRoomAvailability() throws FileNotFoundException, IOException{
    int totalNights = 0;
    int datesMatch = 0;
    String excelFilePath = "Hotel_Schedule.xlsx";
    File file = new File(excelFilePath);
    roomsArrayList = new ArrayList();
    int selectedDayOfWeek = checkInCombo.getItemAt(selectedCheckIn).getDayOfWeek().getValue();
        //if statement prevents crash from null selection
        if(checkOutCombo.getItemAt(selectedCheckOut) != null){
            totalNights = (checkOutCombo.getItemAt(selectedCheckOut).getDayOfMonth() - 
                    checkInCombo.getItemAt(selectedCheckIn).getDayOfMonth()); 
        }
        try (FileInputStream excelFile = new FileInputStream(file)) {   
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = workbook.getSheet("Sheet1"); 
            //loop through rooms, then loop only through the selected dates
            for(int i = 1; i <=15; i++){
                Row availableRoom = sheet.getRow(i);
                for(int j = selectedDayOfWeek; j <= selectedDayOfWeek+totalNights; j++){
                    if(availableRoom.getCell(j) != null && datesMatch != totalNights){
                        datesMatch = 0;
                    }
                    else{
                        datesMatch++;
                        }
                }
                if(datesMatch >= totalNights){
                    roomsArrayList.add(availableRoom.getRowNum());
                }
            }
            excelFile.close();
            FileOutputStream outFile = new FileOutputStream(new File(excelFilePath));
            workbook.write(outFile);
            outFile.close();      
        } 
        //TEST LINE
        System.out.println("Rooms available: " + roomsArrayList);
    return roomsArrayList;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomSelectionGroup = new javax.swing.ButtonGroup();
        selectRoomLabel = new javax.swing.JLabel();
        kingLakeIMG = new javax.swing.JLabel();
        doubleBedIMG = new javax.swing.JLabel();
        kingBalconyIMG = new javax.swing.JLabel();
        nextButton = new java.awt.Button();
        doubleLakeSelected = new javax.swing.JRadioButton();
        kingLakeSelected = new javax.swing.JRadioButton();
        checkInLabel = new javax.swing.JLabel();
        selectRoomLabel1 = new javax.swing.JLabel();
        checkOutCombo = new javax.swing.JComboBox<>();
        checkOutLabel = new javax.swing.JLabel();
        checkInCombo = new javax.swing.JComboBox<>();
        kingBalconySelected = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectRoomLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectRoomLabel.setText("Select a room:");

        kingLakeIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelPictues/King Bed Lake View.JPG"))); // NOI18N

        doubleBedIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelPictues/Double Beds.JPG"))); // NOI18N

        kingBalconyIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelPictues/King Bed Balcony.JPG"))); // NOI18N

        nextButton.setBackground(new java.awt.Color(255, 255, 255));
        nextButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nextButton.setLabel("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        roomSelectionGroup.add(doubleLakeSelected);
        doubleLakeSelected.setText("Double Queen Beds");
        doubleLakeSelected.setEnabled(false);
        doubleLakeSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleLakeSelectedActionPerformed(evt);
            }
        });

        roomSelectionGroup.add(kingLakeSelected);
        kingLakeSelected.setText("King Bed with Lake View");
        kingLakeSelected.setEnabled(false);
        kingLakeSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kingLakeSelectedActionPerformed(evt);
            }
        });

        checkInLabel.setText("Check-In:");

        selectRoomLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectRoomLabel1.setText("Select dates:");

        checkOutCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutComboActionPerformed(evt);
            }
        });

        checkOutLabel.setText("Check-Out:");

        checkInCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInComboActionPerformed(evt);
            }
        });

        roomSelectionGroup.add(kingBalconySelected);
        kingBalconySelected.setText("King bed with balcony");
        kingBalconySelected.setEnabled(false);
        kingBalconySelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kingBalconySelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectRoomLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkInLabel)
                                        .addGap(27, 27, 27))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(checkOutLabel)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkOutCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkInCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kingBalconySelected)
                            .addComponent(doubleLakeSelected)
                            .addComponent(selectRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kingLakeSelected))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doubleBedIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kingBalconyIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kingLakeIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectRoomLabel1)
                            .addComponent(selectRoomLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkInCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkInLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(doubleLakeSelected)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkOutLabel)
                                            .addComponent(checkOutCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(kingBalconySelected)))
                                .addGap(69, 69, 69)
                                .addComponent(kingLakeSelected))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(kingBalconyIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(kingLakeIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(doubleBedIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * this is linked to another class 
 * @param evt 
 */
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        //radio button error check
        if(roomSelectionGroup.getSelection() == null){
            JOptionPane.showMessageDialog(null, "Please select a room!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
         this.kingLakeSelected.setActionCommand("King Bed with Lakeview");
         this.doubleLakeSelected.setActionCommand("Double Queen Beds");
         this.kingBalconySelected.setActionCommand("King Bed with Balcony");

        // option selected  
        selectedRoomType = this.roomSelectionGroup.getSelection().getActionCommand();
        
        if (doubleLakeSelected.isSelected()){
            roomPrice = 50;
            System.out.println(" " + roomPrice);
        }
             if (kingBalconySelected.isSelected()){
            roomPrice = 100;
            System.out.println(" " + roomPrice);
        }
        
            if (kingLakeSelected.isSelected()){
            roomPrice = 150;
            System.out.println(" " + roomPrice);
        }
            
    // String inString = checkInCombo.getItemAt(selectedCheckIn).getValue();
    //   LocalDate  outString = checkOutCombo.getItemAt(selectedCheckOut);
            
           int checkInDay = checkInCombo.getItemAt(selectedCheckIn).getDayOfWeek().getValue();
           int checkOutDay = checkOutCombo.getItemAt(selectedCheckOut).getDayOfWeek().getValue();

           System.out.println("check in "+checkInDay);
           System.out.println("check out "+checkOutDay);
     //      System.out.println("check in string " +checkIn);
         //  System.out.println(inString);
         //  System.out.println(outString);
         System.out.println(selectedCheckIn);
     //   System.out.println(checkInCombo.getItemAt(selectedCheckIn).().getValue());
        

         monthIn = checkInCombo.getItemAt(selectedCheckIn).getMonthValue();
       dayIn = checkInCombo.getItemAt(selectedCheckIn).getDayOfMonth();
     yearIn = checkInCombo.getItemAt(selectedCheckIn).getYear();
     
       monthOut = checkOutCombo.getItemAt(selectedCheckOut).getMonthValue();
       dayOut = checkOutCombo.getItemAt(selectedCheckOut).getDayOfMonth();
       finalCheckIn = monthIn + "-" + "" + dayIn + "-" + "" + yearIn;
       finalCheckOut = monthOut + "-" + "" + dayOut + "-" + "" + yearIn;
      System.out.println(finalCheckIn);
      System.out.println(finalCheckOut);
           
           dayCount = (checkOutDay+1) - (checkInDay+1);
           totalPrice = roomPrice * dayCount;
           System.out.println("days " +dayCount);
           System.out.println("Total " +totalPrice);
        
    new selecting_room(selectedRoomType, totalPrice, roomPrice, dayCount, finalCheckIn, finalCheckOut).setVisible(true);
     this.setVisible(false);  
     
     
   //  this.checkIn.getSelectedValue();
        
        //selecting_room room = new selecting_room();
       // room.show();
       // dispose();
    }//GEN-LAST:event_nextButtonActionPerformed

    
    private void doubleLakeSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleLakeSelectedActionPerformed

        // TODO add your handling code here:
        /*selected room JOptionPane confirmation*/
        outMsg = "$50"; //welcome with the character pressed
        
        
        /**A message will appear for each option of the rooms,
         then the customer will decide if they want to choose that room, and if do, it will update the excel
         if the customer says no, they they will be able to choose another room option and same process.
         */
        JOptionPane.showMessageDialog(null,outMsg);
        int option = JOptionPane.showConfirmDialog(null, "Do you want room?"); // using will press "yes" or " no" or "cancel"
        switch (option){
            case 0:
                JOptionPane.showMessageDialog(null, "Great! ");
         
                //excel
         
                outMsg = "You are all done!"; //welcome with the character pressed
                JOptionPane.showMessageDialog(null,outMsg);
                break;
        case 1:
                JOptionPane.showMessageDialog(null, "Ok, please choose another");
                // done = true;
                break;
        default:
                JOptionPane.showMessageDialog(null, "Thank you!");
        }

    }//GEN-LAST:event_doubleLakeSelectedActionPerformed

    private void kingLakeSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kingLakeSelectedActionPerformed
  
        // TODO add your handling code here:
        outMsg = "$150"; //welcome with the character pressed
        JOptionPane.showMessageDialog(null,outMsg);
        
        //JOptionPane.showMessageDialog(null, "Do you want this room? "); 
        //System.out.println("You are nor a member, Do you want to become one?");
        int option = JOptionPane.showConfirmDialog(null, "Do you want room?"); // using will press "yes" or " no" or "cancel"
        
        switch (option){
            case 0:
                JOptionPane.showMessageDialog(null, "Great! ");
                
                //excel
                
                outMsg = "You are all done!"; //welcome with the character pressed
                JOptionPane.showMessageDialog(null,outMsg);
                
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Ok, please choose another");
                // done = true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Thank you!");
    }//GEN-LAST:event_kingLakeSelectedActionPerformed

    }
    private void checkOutComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutComboActionPerformed
        try {
            /*checkOut variable is being assigned to date selected on combobox */
            selectedCheckOut = checkOutCombo.getSelectedIndex();
            ArrayList roomsAvailable = searchRoomAvailability(); 
        } catch (IOException ex) {
            Logger.getLogger(hotelRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        booleanRoomSelection(roomsArrayList);      
    }//GEN-LAST:event_checkOutComboActionPerformed

    private void checkInComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInComboActionPerformed
        // TODO add your handling code here:
        /*Calling void method that will create and display checkOUTDates in combobox*/
        checkOutCombo.removeAllItems();
        selectedCheckIn = checkInCombo.getSelectedIndex();
        getCheckOutDates(selectedCheckIn);
        
        /*if user does not select a checkOUT date, the system will automatically 
        use the displayed date*/
            selectedCheckOut = checkOutCombo.getSelectedIndex();
            LocalDate checkOut = checkOutCombo.getItemAt(selectedCheckOut);

    }//GEN-LAST:event_checkInComboActionPerformed

    private void kingBalconySelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kingBalconySelectedActionPerformed

        // TODO add your handling code here:     
        /*selected room JOptionPane confirmation*/
        outMsg = "$100"; //welcome with the character pressed
        JOptionPane.showMessageDialog(null,outMsg);
        int option = JOptionPane.showConfirmDialog(null, "Do you want room?"); // using will press "yes" or " no" or "cancel"
        
        switch (option){
            case 0:
                JOptionPane.showMessageDialog(null, "Great! ");
                
                //excel
                
                outMsg = "You are all done!"; //welcome with the character pressed
                JOptionPane.showMessageDialog(null,outMsg);
                
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Ok, please choose another");
                // done = true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Thank you!");
                
        }
  
      
    }//GEN-LAST:event_kingBalconySelectedActionPerformed

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
            java.util.logging.Logger.getLogger(hotelRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hotelRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hotelRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hotelRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hotelRooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox<LocalDate> checkInCombo;
    private javax.swing.JLabel checkInLabel;
    private static javax.swing.JComboBox<LocalDate> checkOutCombo;
    private javax.swing.JLabel checkOutLabel;
    private javax.swing.JLabel doubleBedIMG;
    private javax.swing.JRadioButton doubleLakeSelected;
    private javax.swing.JLabel kingBalconyIMG;
    private javax.swing.JRadioButton kingBalconySelected;
    private javax.swing.JLabel kingLakeIMG;
    private javax.swing.JRadioButton kingLakeSelected;
    private java.awt.Button nextButton;
    private javax.swing.ButtonGroup roomSelectionGroup;
    private javax.swing.JLabel selectRoomLabel;
    private javax.swing.JLabel selectRoomLabel1;
    // End of variables declaration//GEN-END:variables
}
