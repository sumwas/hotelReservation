/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservation;

/**
 *
 * @author josea
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class LogIn_2 {
   public static void main(String args[]) throws IOException{
      //Reading the word to be found from the user
      boolean win = false;
      boolean done = false;
      String outMsg="";
      
      Scanner sc1 = new Scanner(System.in);
      
      String input = null;
      String email = "";
      email = JOptionPane.showInputDialog("Enter your email: ");
      
      boolean flag = false;
      int count = 0;
      //System.out.println("Contents of the line");
      //Reading the contents of the file
      
      //change the directory of the flat text
      Scanner sc2 = new Scanner(new FileInputStream("membershipHotel.txt"));
      
      while(sc2.hasNextLine()) {
         String line = sc2.nextLine();
         System.out.println(line);
         
         if(line.indexOf(email)!=-1) {
            flag = true;
            count = count+1;
         }
      }
      
      if(flag) {
         //System.out.println("You are a member!");
         JOptionPane.showMessageDialog(null, "You are a member!");
         JOptionPane.showMessageDialog(null, "You get to choose a REWARD!");
         String[] buttons = {"Massage Coupon","10% discount","An Upgrade","A towel"};// the buttons' names (parameter)
         int cont = JOptionPane.showOptionDialog(null,"Select a Reward", "Options of Rewards:", 0, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]); 
         //System.out.println("Number of occurrences is: "+count);
         outMsg = "You Chose " + buttons[cont] +". Yay!"; //welcome with the character pressed
         JOptionPane.showMessageDialog(null,outMsg);
         JOptionPane.showMessageDialog(null, "Thank you for being a member!");
         
      } else {
         JOptionPane.showMessageDialog(null, "You are nor a member "); 
         //System.out.println("You are nor a member, Do you want to become one?");
         int option = JOptionPane.showConfirmDialog(null, "Do you want to become one?"); // using will press "yes" or " no" or "cancel"
         
         switch (option){
            case 0: 
               JOptionPane.showMessageDialog(null, "Great! Let's get you register"); 
               FileWriter fw = new FileWriter("/Users/josea/Downloads/hotelReservation/hotelReservation/membershipHotel.txt",true);
               PrintWriter out = new PrintWriter(fw);
               email = JOptionPane.showInputDialog("Enter your email: "); 
               out.println(email);
            
            // Close the file.
               out.close();
            
               outMsg = "You are all done!"; //welcome with the character pressed
               JOptionPane.showMessageDialog(null,outMsg);
               
               break;
            case 1: 
               JOptionPane.showMessageDialog(null, "Ok, thank you for being a customer! You can continue as a guest.");
               done = true;
               break;
            default: 
               JOptionPane.showMessageDialog(null, "Thank you!");
         }
         
      }
   }

    void show() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
