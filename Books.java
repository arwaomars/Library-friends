package friendlibraries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//search
public class Books {
    
   private String searchBook;
   private int result = 0;
   
   public Books(String searchBook , int result){
       this.searchBook = searchBook;
       this.result = result;
   }
   
   public Books(String nameBook){
       searchBook = nameBook; 
   }
   public Books(int re){
       result = re; 
   }
   
   
   public void setSearch (String nameBook) throws FileNotFoundException{
       searchBook = nameBook;
       
       searchInAavailable(searchBook);
       
       //if result != 1 that's mean it may Unavailable or my be not in this library
       if (result != 1)
       searchInUnavailable(searchBook);
       
   }
   
   public void searchInAavailable(String searchBook)  {
       String books;
       try{
        File availableBooks = new File("AvailableBooks.txt");
       
        if(!availableBooks.exists()){ //cheack if file exists, or not. 
        System.exit(0);
        } 
        Scanner readfile = new Scanner(availableBooks); //read from file 
        
        while(readfile.hasNext()){ 
         books = readfile.nextLine();//variable to store data that read it
        if(books.equalsIgnoreCase(searchBook))
            result = 1;
        }
        }catch(FileNotFoundException e){
                System.out.println("there is no file"); 
      }
   }
   
   public void searchInUnavailable(String searchBook) {
       String books;
       try{
        File unavailableBooks = new File("unavailableBooks.txt");
        if(!unavailableBooks.exists()){ //cheack if file exists, or not. 
        System.exit(0);} 
        
        Scanner readfile = new Scanner(unavailableBooks); //read from file 
        
        while(readfile.hasNext()) { 
        books = readfile.nextLine();
        if(books.equalsIgnoreCase(searchBook)) 
            result = 2;
        }
       }catch(FileNotFoundException e){
            System.out.println("there is no file"); 
       }
        
   }
   
   
   
   public int getResultSearch (){
       return result;
   }
   
   public String toString (){
       
       String resultSearch;
       
       switch (result) {
            case 1:
                resultSearch = searchBook + " is Aavailable";
                break;
            case 2:
                resultSearch = searchBook + " It is not currently available "
                                          + "\nIt is rented";
                break;
            default:
                resultSearch = searchBook + " is not in this library";
                break;
        }
       
       return resultSearch;
   }
}



