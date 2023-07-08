/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubersystemprogram;

/**
Name : Alanoud Owaed Almutairi
* ID : 2105088
* Email :AHEMIJANALMUTAIRI@stu.kau.edu.sa
* Section :B8B
* course : CPCS-204
* date :11 - nov - 2022
* Title : Uber System
 */
public class CaptainNode {
//DATA FELD:   
    private int captainID;
    private String CaptainName;
    private int star;
    private boolean available;
    private CaptainNode right;
    private CaptainNode left;

//CONSTRUCTORS:     
    //** 1 **
public CaptainNode(int Id , String name , int star , boolean available ){
   captainID = Id ; 
   CaptainName = name ;
   star =star;
   available = available ;
   left=right= null;
} 
   // ** 2 **
public CaptainNode(int Id , String name , int star , boolean available , CaptainNode right, CaptainNode left ){
   captainID = Id ; 
   CaptainName = name ;
   star =star;
   available = available ;
   left= left ;
   right= right;
} 

  // ** 3 **
public CaptainNode(){
    left = right = null;
}
  //** 4 **
    CaptainNode(int ID, String name) {
      captainID = ID;
      CaptainName = name ;
      available = true ;
      star = 0;
    }
    
    
  // SETERS AND GETERS :   
public void setName(String name){
    CaptainName = name;
}
public String getName(){
    return CaptainName;
}
public void setId (int id){
    captainID = id;
}
public int getID(){
    return captainID;
}
public void setStar(int Star){
    star = Star;
}
public int getStar(){
   return star; 
}
public void setavailable(boolean x){
    available = x;
}
public boolean getavailable(){
    return available;
}
public void setRight(CaptainNode x){
    right = x;
}
public CaptainNode getRight(){
    return right;
}
public void setLeft(CaptainNode x){
    left = x;
}
public CaptainNode getLeft(){
    return left;
}
        



}
