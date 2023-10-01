package friendlibraries;


import java.io.FileNotFoundException;

//in this class visitors can rent a book
public class visitors {
    
    Books book;
    public int numBook;
    private final double price = 3;
    public int day;
    private double total;
    private int numDay;
    private String searching;
    
    /* constructor 1 */
    public visitors(int number, int day, Books name){
        book = name;
        numBook = number;
        numDay = day;
    }
    
    /* constructor 2 
    if user do not determine the name book*/
    public visitors (int number,int day){
        numBook = number;
        numDay = day;
    }
    // constructor 3
    public visitors(Books book, int numBook,double price, int day, 
                    double total, int numDay, String searching){
    }
    // constructor 4 
    public visitors(){
    }
    
    /* set number of book
    @param numberBook
    */
    public void setnumBook(int numberBook){
        numBook = numberBook;
    }
    
    /*set day of rent 
    @param days
    */
    public void setday(int days){
        day = days;
    }
    
    /* get number of book
    @return numBook
    */
    public int getnumBook(){
        return numBook;}
    
    /* get day 
    @return day
    */
    public int getday(){
       return day;
    }
    
    /* Make sure the book is there then Calculates the rental cost
    @param day, number of day
    @return total, total cost
    */
    public double totalPrice(int day){
        if(book.getResultSearch() == 1){
        total = price*day;
        }else{
            total = 0;
        }
        return total;
    }
    
    /* Calculates the rental cost
    @param day, numBook, number of day and number of book
    @return total, total cost
    */
    public double totalPrice(int day, int numBook){
        total = price*day*numBook;
        return total;
    }
    
    /*search Book before rent
    @param nameBook, it object 
    @return searching*/
    public String searchBook(Books nameBook) throws FileNotFoundException{
       searching = nameBook.toString();
       return searching;
    }
    
    
    
   /* to print
    @return all, all result
    */
    public String toString(){
        String all;
        
        switch (book.getResultSearch()) {
            case 1:
                all = book + ",the price is: " + total + "\n"
                        + "\nplease go as soon as possible to pay and receive it,"
                        + "\notherwise it may be rented to someone else\n";
                break;
            case 2:
                all = book + "\n";
                break;
            default:
                all = book + "\n";
                break;
        }
      return all;
    }
    
}

