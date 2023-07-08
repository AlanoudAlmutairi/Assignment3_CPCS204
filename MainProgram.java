/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ubersystemprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
Name : Alanoud 
* course : CPCS-204
* date :11-nov- 2022
* Title :Uber System
 */
public class MainProgram {

   
    public static void main(String[] args) throws FileNotFoundException {
   //creat command file and check if it is exsist or not 
        File commandFile = new File("input.txt");
        if(!commandFile.exists()){
            System.out.println("The file is not exists");
            System.exit(0);}
    //read from command file 
        Scanner input = new Scanner(commandFile); 
    //  print in new file 
        PrintWriter output = new PrintWriter("output.txt");
    //creat Tree     
        UberTree myTree = new UberTree();
    //print the header 
    output.println("--------------- Welcome to Uber Booking System ---------------");
     String command ;
     do{
    //resd the command from input file 
         command = input.next();
    //------------------------- Add Captain --------------------------------//     
         if(command.equalsIgnoreCase("ADD_CAPTAIN")){
    //print the header          
             output.println("Command: ADD_CAPTAIN: Add a new captain record in the System"); 
    //raed ID , name from input file         
             int ID = input.nextInt();
             String fullName = input.next();
    //invok Add method from UberTree class         
             CaptainNode newNode =myTree.Add(ID, fullName);
    //print Information          
              output.println("\n\t\t\t ID: " + newNode.getID());
              output.println("\t\t\t Name: "+ newNode.getName());
              output.println("\t\t\t Available: " + newNode.getavailable());
              output.println("\t\t\t Rating star: "+ newNode.getStar());
              output.println("\n----------------------------------------------------------------");
             
         }
    //------------------------- Book Ride --------------------------------//        
         else if(command.equalsIgnoreCase("BOOK_RIDE")){
    //read Id from input File          
             int ID = input.nextInt();
    //Invok Book Ride method from UberTree class         
             myTree.BookRide(ID, output);     
         }
    //------------------------- Display All Captains --------------------------------//        
         else if(command.equalsIgnoreCase("DISPLAY_ALL_CAPTAINS")){
    //print te header          
             output.println("Command DISPLAY_ALL_CAPTAINS:");
    //invoke DesplayAll method from Uber Tree class         
             myTree.DisplayAll(output);
         }
     //------------------------- Display Captain Info --------------------------------//        
         else if(command.equalsIgnoreCase("DISPLAY_CAPTAIN_INFO")){
    //read Id from input file          
           int id = input.nextInt();
    //invok search method to find the captain with specific id       
           CaptainNode z = myTree.Search(id);
    //print        
           output.print("Command DISPLAY_CAPTAIN_INFO: ");
    //if we find the captain:       
           if(z!=null){
    //display his information be invok printTnfo method           
              myTree.printInfo(z, output);
           }
    // if we don't find the captain print this comment       
           else 
               output.println("Couldn’t find any captain with ID number " + id);
            output.println("\n----------------------------------------------------------------");
         }
    //------------------------- Finish Ride --------------------------------//       
         else if(command.equalsIgnoreCase("FINISH_RIDE")){
    //print         
             output.print("Command FINISH_RIDE:");
    //read id and stars from input file         
             int id = input.nextInt();
             int stars = input.nextInt();
    //invok finish ride method        
             myTree.finish(id, stars, output);
    //print         
             output.println("----------------------------------------------------------------");
        }
    //------------------------- Delet Captain --------------------------------//      
          else if(command.equalsIgnoreCase("DELETE_CAPTAIN")){
    //print          
              output.print("Command DELETE_CAPTAIN: ");
    //rad id from input file          
              int Id = input.nextInt();
    //search for the captain with specific id          
              CaptainNode find = myTree.Search(Id);
    //if we don't find the captain print this comment          
              if(find == null)
                 output.println("Couldn't find any captain with ID number "+Id);
    // if we find the captain ,invok delet method from Uber Tree class and print the comment           
              else{
                myTree.Delet(Id,output);
               output.println("The captain "+find.getName()+" left Uber  ");
              }
    //print                  
      output.println("----------------------------------------------------------------");
          }     
     }while( ! command.equalsIgnoreCase("Quit"));
    //print this comment at the end , if we finish all commands     
    output.println("Thank you for using Uber System, Good Bye!");
        
    input.close();
    output.close();
        
    }
    
}
