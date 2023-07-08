/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubersystemprogram;

import java.io.PrintWriter;
/**
Name : Alanoud Owaed Almutairi
* ID : 2105088
* Email :AHEMIJANALMUTAIRI@stu.kau.edu.sa
* Section :B8B
* course : CPCS-204
* date :22-nov-2022
* Title : Uber System
 */
public class UberTree {
//data feld  :  
  private CaptainNode root ;
//constructor:
public UberTree(){
     root = null ;
}  
//method add (insert):
public CaptainNode Add(int ID , String name){
//creat a new node with new id 
    CaptainNode newNode = new CaptainNode(ID,name);
//sent this node to add node    
    root = Add(root,newNode);
    return newNode;
}


private CaptainNode Add(CaptainNode p, CaptainNode newNode){
//if the pointer == null , the tree is empty     
    if(p==null){
        return newNode;
    }
//the tree in not empty     
    else {
//finde the correct place for new node
        if(newNode.getID()>p.getID()){
        CaptainNode temp=  Add(p.getRight(),newNode);
        p.setRight(temp);
        }
        else{
         CaptainNode temp = Add(p.getLeft(),newNode);
         p.setLeft(temp);
        }
    }
    return p;
}
//thus method display all information for all captains
public void DisplayAll(PrintWriter output ){
    DisplayAll(root,output);
}

private void DisplayAll (CaptainNode x , PrintWriter output ){
//if the tree is not empty     
    if(x != null){
//print information          
        output.println("\n\t\t\tID: " + x.getID());
        output.println("\t\t\tName: " + x.getName());
        output.println("\t\t\tAvailable: " + x.getavailable());
        output.println("\t\t\tRating star: " + x.getStar());
        output.println("\n----------------------------------------------------------------");
//go left and go right to print all nodes in tree        
        DisplayAll(x.getLeft(),output);
        DisplayAll(x.getRight(),output);
            }
}
//search for captain  by his ID
public CaptainNode Search(int ID){
   CaptainNode x=  Search(root, ID);
       return x ;   
}
private CaptainNode Search(CaptainNode p , int ID){
//if the tree is empty   
    if (p == null)
    return null;
//if tree is not empty 
  else {
// if the data we are searching for is found at p (root)
    if (ID == p.getID())
        return p; 
//if the data we are searching for is less then the root , go left and complet search    
    else if (ID < p.getID()) 
       return Search( p.getLeft() ,  ID);

//if the data we are searching for is greater then the root , go right and complet search        
    else
        return Search( p.getRight() , ID);
 
}
}

public void BookRide(int ID,PrintWriter output ){
    BookRide(root,ID, output);
}
private void BookRide( CaptainNode p ,int id ,PrintWriter output ){
//print    
    output.print("Command BOOK_RIDE: ");
//search for this captain be his id    
   CaptainNode y = Search(id);
//of we find the captain   
   if(y!=null){
//if the captain is available       
   if(y.getavailable()==true){
//change the available to False + print this comment       
       y.setavailable(false);
       output.println("Book a new Ride with captain "+y.getID());
   }
//if the captain is not available, print thic comment   
   else
       output.println("The captain "+y.getName()+" is not available. He is on another ride!");
}
//if we don't find the captain , print thi comment   
   else 
       output.println("Couldn’t find any captain with ID number "+id );
//print   
  output.println(" \n----------------------------------------------------------------");
 }

public void finish(int id , int star,PrintWriter output){
//search for captain by his id    
    CaptainNode y = Search(id);
//if we find the captain     
    if(y!= null){
// if the captain available        
        if(y.getavailable() == true){
//print comment            
            output.println("The captain "+y.getName()+" is not in a ride!");
// and go out this method            
      return ;}
//if the captain is not available         
        else
//change the available to true            
        y.setavailable(true);
//and if stars equal 1 , increase the captain stars by 1        
        if(star==1)
            y.setStar(y.getStar()+1);
//if stars equal 0 , decrease the captain stars by 1        
        else{
            if(y.getStar()!=0)
                y.setStar(y.getStar()-1);
        }
//print Info        
        output.println("Finish ride with captain " + id);
        printInfo(y , output);
    }
//if we don't find the captain    
    else
        output.println("Couldn’t find any captain with ID number "+ id);
    
}
public void Delet(int id ,PrintWriter output){
 root = Delet(root , id);
}

private CaptainNode Delet(CaptainNode p , int id){
    CaptainNode node2delet,newnode2delet,node2save,parent;
    int saveV;
//search for captain with his id    
    node2delet=Search(id);
//if we don't find the captain     
    if(node2delet == null)
        return root;
//search for parent of the captain we want to delet it  
    parent = parent( node2delet);
//>>node2delet is leaf node   
     if(isLeaf(node2delet)){
//if parent == null, this means this node the only node in the tree         
         if(parent==null)
             return null;
//Delet node if it is left node     
     if(id <parent.getID())
         parent.setLeft(null);
//delet node if it is right node     
     else
         parent.setRight(null);
//return the root of the tree     
    return p;}
//>>node2delet has only left child        
     if(hasOnlyLeftChild(node2delet)){
// if node2delet is root          
      if(parent == null)
          return node2delet.getLeft();
//if node2delet is not root , maby it is in the left      
      if(id<parent.getID())
          parent.setLeft(parent.getLeft().getLeft());
//if node2delet is not root , and not left , maby it is right 
      else
          parent.setRight(parent.getRight().getLeft());
//return the root      
      return p;    }
     
//>>node2delet has only right child     
     if(hasOnlyRightChild(node2delet)){
// if node2delet is root         
      if(parent==null)
          return node2delet.getRight();
//if node2delet is not root , maby it is in the left       
      if(id<parent.getID())
          parent.setLeft(parent.getLeft().getRight());
//if node2delet is not root , maby it is in the right     
      else
          parent.setRight(parent.getRight().getRight());
//return the root     
      return p;  }
//>> node2delet has 2 children
//find min value from right subtree
     newnode2delet = minNode(node2delet.getRight());
//we need to save data      
     saveV = newnode2delet.getID();
//we recursively call our delete method to actually delete this node that we just copied the data from
      p=Delet(p,saveV);
//put the saved data (in saveValue) into the correct place (the original node we wanted to delete)      
     node2delet.setId(saveV);
//return root     
     return p;}


public CaptainNode minNode(CaptainNode root) {
//if the tree is empty    
     if (root == null) {
        return null;}
//if the tree is not empty  
     else {
//if left == null , we don't have valuse less than root         
     if (root.getLeft() == null) {
//return root    
         return root;}
//if we have a valuse less tha root , we have a left part  
    else {
// recursively call minNode to find the min value         
       return minNode(root.getLeft());
 
}
}}
 
public CaptainNode maxNode(CaptainNode root) {
//if the tree is empty     
   if (root == null) {
       return null;}
//if tree is not empty 
    else {
//if we dont have right part , we don't have values greater than root       
       if (root.getRight() == null) {
//return root      
           return root;}
//if we have values greater than root and we have right part 
    else {
//// recursively call maxNode to find the max value           
       return maxNode(root.getRight());
      }
}}

public CaptainNode parent(CaptainNode p) {
        return parent(root, p);
 }

private CaptainNode parent(CaptainNode root, CaptainNode p) {
//if the tree is empty , or the root equal the node
    if (root == null || root == p)
// return null , because there is on parent  
        return null; 
    
// If root is the actual parent of node p
    if (root.getLeft()==p || root.getRight()==p)
//return root ,  because root is the parent of p        
        return root; 
 
 
// Look for p's parent in the left side of root
    if (p.getID()< root.getID())
        return parent(root.getLeft(), p);
 
// Look for p's parent in the right side of root 
    else if (p.getID()> root.getID())
         return parent(root.getRight(), p);
 
// Take care of any other cases
    else
        return null;}

//chack if the node is leaf nood or not 
public boolean isLeaf(CaptainNode p) {
     return (p.getLeft()==null && p.getRight()==null);
 
}
//check it has a left child only 
public boolean hasOnlyLeftChild(CaptainNode p) {
    return (p.getLeft()!=null && p.getRight()==null);
 
}
 //check it has a right child only 
public boolean hasOnlyRightChild(CaptainNode p) { 
    return (p.getLeft()==null && p.getRight()!=null);
}

//***this method for print captain Informatio***
public void printInfo(CaptainNode z, PrintWriter output){
     output.println("\n\t\t\t ID: " + z.getID());
               output.println("\t\t\t Name: "+ z.getName());
               output.println("\t\t\t Available: " + z.getavailable());
               output.println("\t\t\t Rating star: "+ z.getStar());
}


}