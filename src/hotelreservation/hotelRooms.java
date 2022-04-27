/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 12137
 * 
 Provide a complete summary for each module/class header: include 
Module name or Class name in the Design:  hotelRooms.java
Date of the code 
Programmer's name: Yashira Almanza & 
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
int selectedCheckIn;
String outMsg;
    
    /**
     * Creates new form hotelRooms
     */
    public hotelRooms() {
        initComponents();
     /*Calling getCheckInDates(), iterating through arrayList to create 
        array to set in check-in comboBox */ 
            ArrayList checkInDays = getCheckInDates();
            String[] checkInDaysArray = new String[checkInDays.size()];
                for(int i = 0; i < checkInDays.size(); i++){
                    checkInDaysArray[i] = checkInDays.get(i).toString() + " ";
                }
            checkInCombo.setModel(new javax.swing.DefaultComboBoxModel<>(checkInDaysArray));  
    }

    /**
     * This method is called from within the constructor to initialize the form.WARNING: Do NOT modify this code.The content of this method is always
 regenerated by the Form Editor.
     *
     * @return 
     */
    @SuppressWarnings("unchecked")
        /* Method for Check IN Date list*/
    
    
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
    
     /* Method for Check Out Date list
       selectedCheckIn date is passed in through action(combobox selection)
       method determines valid user dates for check in starting at the 
       selectedDay + 1. String array of valid check out dates - only up to sunday of
       that week. 
    */
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
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomSelection = new javax.swing.ButtonGroup();
        selectRoomLabel = new javax.swing.JLabel();
        kingLakeIMG = new javax.swing.JLabel();
        doubleBedIMG = new javax.swing.JLabel();
        kingBalconyIMG = new javax.swing.JLabel();
        nextButton = new java.awt.Button();
        doubleBedsSelected = new javax.swing.JRadioButton();
        KingLakeSelected = new javax.swing.JRadioButton();
        checkInLabel = new javax.swing.JLabel();
        selectRoomLabel1 = new javax.swing.JLabel();
        checkOutCombo = new javax.swing.JComboBox<>();
        checkOutLabel = new javax.swing.JLabel();
        checkInCombo = new javax.swing.JComboBox<>();
        kingbedwithbalcony = new javax.swing.JRadioButton();

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

        roomSelection.add(doubleBedsSelected);
        doubleBedsSelected.setText("Double Queen Beds");
        doubleBedsSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleBedsSelectedActionPerformed(evt);
            }
        });

        roomSelection.add(KingLakeSelected);
        KingLakeSelected.setText("King Bed with Lake View");
        KingLakeSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KingLakeSelectedActionPerformed(evt);
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

        roomSelection.add(kingbedwithbalcony);
        kingbedwithbalcony.setText("King bed with balcony");
        kingbedwithbalcony.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kingbedwithbalconyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kingLakeIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kingBalconyIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doubleBedIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(doubleBedsSelected, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KingLakeSelected, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(selectRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(selectRoomLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nextButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkInLabel)
                            .addComponent(checkOutLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkOutCombo, 0, 127, Short.MAX_VALUE)
                            .addComponent(checkInCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(kingbedwithbalcony, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectRoomLabel)
                    .addComponent(selectRoomLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doubleBedIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doubleBedsSelected)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkInLabel)
                            .addComponent(checkInCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkOutLabel)
                            .addComponent(checkOutCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kingbedwithbalcony)
                            .addComponent(kingBalconyIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kingLakeIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(KingLakeSelected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * this is linked to another class 
 * @param evt 
 */
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        selecting_room room = new selecting_room();
        room.show();
        dispose();
    }//GEN-LAST:event_nextButtonActionPerformed

    
    private void doubleBedsSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleBedsSelectedActionPerformed
        // TODO add your handling code here:
        //room type: 1 (rows/index 1-5)
        //roomType = 1... 
        //search(roomType)... returns available dates
            /* search method will loops through Monday - Sunday row index(of file)
               searching for available checkIn dates
               based on this checkIn date, we can determine valid checkOut date
            */
            outMsg = "$50"; //welcome with the character pressed
            
            /**
             * A message will appear for each option of the rooms,
             * then the customer will decide if they want to choose that room, and if do, it will update the excel
             * if the customer says no, they they will be able to choose another room option and same process. 
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
      
    }//GEN-LAST:event_doubleBedsSelectedActionPerformed

    private void KingLakeSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KingLakeSelectedActionPerformed
        // TODO add your handling code here:
        //room type: 3 (rows/index 11-15)
        //roomType = 3... 
        //search(roomType)... returns available dates
            /* search method will loops through Monday - Sunday row index
               searching for available checkIn dates
               based on this checkIn date, we can determine valid checkOut date
            */
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
      
    }//GEN-LAST:event_KingLakeSelectedActionPerformed
    }
    private void checkOutComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutComboActionPerformed
        // TODO add your handling code here:
        /*checkOut variable is being assigned to date selected on combobox */
            int selectedCheckOut = checkOutCombo.getSelectedIndex();
            String checkOut = checkOutCombo.getItemAt(selectedCheckOut);
    }//GEN-LAST:event_checkOutComboActionPerformed

    private void checkInComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInComboActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        //checkIn variable is being assigned to date selected on the combobox
            selectedCheckIn = checkInCombo.getSelectedIndex();
            String checkIn = checkInCombo.getItemAt(selectedCheckIn);
        /*Calling void method that will create and display checkOUTDates in combobox*/
            getCheckOutDates(selectedCheckIn);
        /*if user does not select a checkOUT date, the system will automatically 
        use the displayed date*/
            int selectedCheckOut = checkOutCombo.getSelectedIndex();
            String checkOut = checkOutCombo.getItemAt(selectedCheckOut);
    }//GEN-LAST:event_checkInComboActionPerformed

    private void kingbedwithbalconyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kingbedwithbalconyActionPerformed
        // TODO add your handling code here:
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
      
    }//GEN-LAST:event_kingbedwithbalconyActionPerformed

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
    private javax.swing.JRadioButton KingLakeSelected;
    private static javax.swing.JComboBox<String> checkInCombo;
    private javax.swing.JLabel checkInLabel;
    private static javax.swing.JComboBox<String> checkOutCombo;
    private javax.swing.JLabel checkOutLabel;
    private javax.swing.JLabel doubleBedIMG;
    private javax.swing.JRadioButton doubleBedsSelected;
    private javax.swing.JLabel kingBalconyIMG;
    private javax.swing.JLabel kingLakeIMG;
    private javax.swing.JRadioButton kingbedwithbalcony;
    private java.awt.Button nextButton;
    private javax.swing.ButtonGroup roomSelection;
    private javax.swing.JLabel selectRoomLabel;
    private javax.swing.JLabel selectRoomLabel1;
    // End of variables declaration//GEN-END:variables
}
