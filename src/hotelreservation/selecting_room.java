/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelreservation;

import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author josea
 */


/*class Product{
    //properties
   int price;
   int totalaPrice;
}
*/
//constuctor
/*Product(int priceA, int totalPrice){
this.priceA = priceA;
 this.totalPrice = totalPrice;      
}

public int getPrice(){
return price;
}

public int getTotalPrice(){
return totalPrice;
}

*/
public class selecting_room extends javax.swing.JFrame {

    
    String outMsg;
int counter =0;


int totalPrice;
int roomPrice;
int dayCount;
static String selectedRoomType;
String checkIn;
String checkOut;
int features;

int monthIn;
int dayIn;
int yearIn;

String finalCheckIn;
String finalCheckOut;


         public selecting_room(String selection,  int total, int roomAmount, int days, String timeIn, String timeOut) {
        initComponents();
        selectedRoomType = selection;
      //  checkIn = dateIn;
      //  checkOut = dateOut;
        totalPrice = total;
        roomPrice = roomAmount;
        dayCount = days;
        finalCheckIn = timeIn;
        finalCheckOut = timeOut;
    //    yearIn = year;
      // customerInfo = info;
       // numGenerate = number; 
    }


    /**
     * Creates new form selecting_room
     */
    public selecting_room() {
        boolean done = false;

    int option = JOptionPane.showConfirmDialog(null, "Do you want to pick features to your room?"); // using will press "yes" or " no" or "cancel"
         
         switch (option){
             //if the customer says "yes" to register 
            case 0: 
               JOptionPane.showMessageDialog(null, "Great! You can choose up to 3 features and your total will be $50!"); 
               
               initComponents();
               //JOptionPane.showMessageDialog(null, "YOUR TOTAL IS $50"); 
               break;
             
               //if the customer says "no" to register 
            case 1: 
               done = true;
               
               customerInfo custInfo = new customerInfo();
                custInfo.show();
                dispose();
               
               break;
           
            //if the person did not choose any options 
            default: 
               JOptionPane.showMessageDialog(null, "Thank you!");
         }
        //only select 3 featrures 
       // String outMsg = "An additional selection it will cost $50!";
   //JOptionPane.showMessageDialog(null, outMsg);
    
       // initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BreakfastPlanft = new javax.swing.JCheckBox();
        petFriendly = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ExtraPillowsft = new javax.swing.JCheckBox();
        ExtraTowelsft = new javax.swing.JCheckBox();
        ExtraHangersft = new javax.swing.JCheckBox();
        gymArea = new javax.swing.JCheckBox();
        playgroundArea = new javax.swing.JCheckBox();
        smokingArea = new javax.swing.JCheckBox();
        poolAccessArea = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BreakfastPlanft.setText("Breakfast plan");
        BreakfastPlanft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BreakfastPlanftActionPerformed(evt);
            }
        });

        petFriendly.setText("Pet friendly");
        petFriendly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petFriendlyActionPerformed(evt);
            }
        });

        jLabel1.setText("Please choose up to 3 options for your room ");

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ExtraPillowsft.setText("Extra pillows");
        ExtraPillowsft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtraPillowsftActionPerformed(evt);
            }
        });

        ExtraTowelsft.setText("Extra towels");
        ExtraTowelsft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtraTowelsftActionPerformed(evt);
            }
        });

        ExtraHangersft.setText("Extra Hangers");
        ExtraHangersft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtraHangersftActionPerformed(evt);
            }
        });

        gymArea.setText("gym area");
        gymArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gymAreaActionPerformed(evt);
            }
        });

        playgroundArea.setText("Playground area");
        playgroundArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playgroundAreaActionPerformed(evt);
            }
        });

        smokingArea.setText("smoking area");
        smokingArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokingAreaActionPerformed(evt);
            }
        });

        poolAccessArea.setText("pool access");
        poolAccessArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poolAccessAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(gymArea))
                    .addComponent(playgroundArea)
                    .addComponent(smokingArea)
                    .addComponent(poolAccessArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ExtraTowelsft)
                        .addComponent(BreakfastPlanft)
                        .addComponent(ExtraPillowsft)
                        .addComponent(ExtraHangersft))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(petFriendly)
                        .addGap(12, 12, 12)))
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gymArea)
                    .addComponent(petFriendly))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(playgroundArea)
                        .addGap(18, 18, 18)
                        .addComponent(smokingArea)
                        .addGap(18, 18, 18)
                        .addComponent(poolAccessArea))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(ExtraPillowsft)
                        .addGap(18, 18, 18)
                        .addComponent(BreakfastPlanft)
                        .addGap(18, 18, 18)
                        .addComponent(ExtraTowelsft)))
                .addGap(26, 26, 26)
                .addComponent(ExtraHangersft)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * this button, will lead the to the next page to the customer can input their information 
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        totalPrice = totalPrice + features;
        
        new customerInfo(selectedRoomType, checkIn, checkOut, totalPrice, roomPrice, dayCount, features,  finalCheckIn, finalCheckOut).setVisible(true);
        this.setVisible(false);
     //   customerInfo custInfo = new customerInfo();
     //   custInfo.show();
    //    dispose();
        JOptionPane.showMessageDialog(null, "Great! Your total is $50!"); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ExtraHangersftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtraHangersftActionPerformed
        // TODO add your handling code here:
       
        if (ExtraHangersft.isSelected() && counter > 3) {
            ExtraHangersft.setSelected(false);
        } else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            
            if (ExtraHangersft.isSelected()) {
                
                counter++;
                features = 50;
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        }
    }//GEN-LAST:event_ExtraHangersftActionPerformed

    private void petFriendlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petFriendlyActionPerformed
        // TODO add your handling code here:
        if (petFriendly.isSelected() && counter >= 3) {
            petFriendly.setSelected(false);
            
            
        } else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            if (petFriendly.isSelected()) {
                
                counter++;
                features = 50;
               
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        }
    }//GEN-LAST:event_petFriendlyActionPerformed

    private void ExtraPillowsftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtraPillowsftActionPerformed
        // TODO add your handling code here:
        if (ExtraPillowsft.isSelected() && counter >= 3) {
            ExtraPillowsft.setSelected(false);
        } else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            if (ExtraPillowsft.isSelected()) {
                
                counter++;
                features = 50;
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        }
    }//GEN-LAST:event_ExtraPillowsftActionPerformed

    private void gymAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gymAreaActionPerformed
        // TODO add your handling code here:
        //first check if max is reached, if yes make checkbox unclickable
        if (gymArea.isSelected() && counter >= 3) {
            gymArea.setSelected(false);
        } else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            if (gymArea.isSelected()) {
                
                counter++;
                features = 50;
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        }
    }//GEN-LAST:event_gymAreaActionPerformed

    private void playgroundAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playgroundAreaActionPerformed
        // TODO add your handling code here:
        //first check if max is reached, if yes make checkbox unclickable
        if (playgroundArea.isSelected() && counter >= 3) {
            playgroundArea.setSelected(false);
        } else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            if (playgroundArea.isSelected()) {
               
                counter++;
                features = 50;
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        }
    }//GEN-LAST:event_playgroundAreaActionPerformed

    private void smokingAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokingAreaActionPerformed
        // TODO add your handling code here:
        //first check if max is reached, if yes make checkbox unclickable
        if (smokingArea.isSelected() && counter >= 3) {
            smokingArea.setSelected(false);
        } else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            if (smokingArea.isSelected()) {
               
                counter++;
                features = 50;
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        }
    }//GEN-LAST:event_smokingAreaActionPerformed

    private void poolAccessAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poolAccessAreaActionPerformed
        // TODO add your handling code here:
        if (poolAccessArea.isSelected() && counter >= 3) {
            poolAccessArea.setSelected(false);
        } else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            if (poolAccessArea.isSelected()) {
                
                counter++;
                features = 50;
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        }
    }//GEN-LAST:event_poolAccessAreaActionPerformed

    private void BreakfastPlanftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BreakfastPlanftActionPerformed
        // TODO add your handling code here:
        if (BreakfastPlanft.isSelected() && counter >= 3) {
            BreakfastPlanft.setSelected(false);
        } 
        else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            if (BreakfastPlanft.isSelected()) {
                
                counter++;
                features = 50;
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        //}
    }//GEN-LAST:event_BreakfastPlanftActionPerformed
    }
    
    private void ExtraTowelsftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtraTowelsftActionPerformed
        // TODO add your handling code here:
        if (ExtraTowelsft.isSelected() && counter >= 3) {
            ExtraTowelsft.setSelected(false);
            
        } 
        
        else {
            // if not max, and this checkbox is selected, add 1 to counter so it counts this checkbox as one of the 3 clicked
            if (ExtraTowelsft.isSelected()) {
                
                counter++;
                features = 50;
                //if not max, and this checkbox is unselected, subtract 1 from the counter so it removes this checkbox as one of the 3 clicked 
            } else {
                counter--;
            }

        }
    }//GEN-LAST:event_ExtraTowelsftActionPerformed

    
    
    
//outMsg = price; //welcome with the character pressed
               //JOptionPane.showMessageDialog(null,price);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    // int totalPrice = price; 
        
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
            java.util.logging.Logger.getLogger(selecting_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selecting_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selecting_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selecting_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selecting_room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BreakfastPlanft;
    private javax.swing.JCheckBox ExtraHangersft;
    private javax.swing.JCheckBox ExtraPillowsft;
    private javax.swing.JCheckBox ExtraTowelsft;
    private javax.swing.JCheckBox gymArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox petFriendly;
    private javax.swing.JCheckBox playgroundArea;
    private javax.swing.JCheckBox poolAccessArea;
    private javax.swing.JCheckBox smokingArea;
    // End of variables declaration//GEN-END:variables
}
