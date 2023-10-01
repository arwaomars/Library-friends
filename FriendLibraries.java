package friendlibraries;

//Arwa Omar Sait, ID: 2111782
//Shahad alharbi, ID: 2113525 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;




public class FriendLibraries extends JFrame{

    private JRadioButton JRBV;
    private JRadioButton JRBL;
    private ButtonGroup group; 
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JRadioButton JRBVs;
    private JRadioButton JRB_books;
    private JRadioButton JRB_availableBooks;
    private JRadioButton JRB_unavailableBooks;
    private JRadioButton JRB_rent;
    private JRadioButton JRB_searching;
    private JRadioButton JRB_image;
    private ButtonGroup group2v;
    private Button Button1;
    private Button Button2;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel8;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem exitItem;
    private JSeparator seprat;
    private JCheckBoxMenuItem avalible;
    private JCheckBoxMenuItem unavalible;
    private JTextField text;

    public FriendLibraries() {
    	   
          setSize(500,300);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setTitle("Friend of Libraries");
          setLocationRelativeTo(null);
          
          //Layout mangers
          setLayout(new BorderLayout());
          
          //set Components
          label1 = new JLabel("Welcome in Friend of the Library ");
          label1.setFont(new Font("Welcome in Friend of the Library ",Font.ITALIC,24));
          label1.setForeground(Color.BLACK);
         
          //add(label1)
          panel1 = new JPanel();
          panel1.add(label1);
          
          label2 = new JLabel("Who are you? ");
          label2.setFont(new Font("Who are you? m",Font.ITALIC,18));
          label2.setForeground(Color.blue);
          panel4 = new JPanel();
          panel4.add(label2);
          
          panel5 = new JPanel();
          panel5.setLayout(new BorderLayout());
          panel5.add(panel1, BorderLayout.NORTH);
          panel5.add(panel4, BorderLayout.CENTER);
          
          
          JRBV = new JRadioButton("visitor ");
          JRBV.setBackground(Color.red);
          JRBV.setForeground(Color.WHITE);
          JRBV.setFont(new Font("visitor ",Font.ITALIC,18));
          JRBL= new JRadioButton("librarian ",true);
          JRBL.setBackground(Color.red);
          JRBL.setForeground(Color.WHITE);
          JRBL.setFont(new Font("librarian ",Font.ITALIC,18));
          group = new ButtonGroup();
          group.add(JRBV);
          group.add(JRBL);
          
          panel2 = new JPanel();
          panel2.setLayout(new FlowLayout());
          panel2.add(JRBV);
          panel2.add(JRBL);
          
          
          Button1 = new Button("click ");
          Button1.setBackground(Color.red);
          Button1.setForeground(Color.WHITE);
          Button1.setFont(new Font("click ",Font.ITALIC,18));
          add(Button1);
          
          panel3 = new JPanel();
          panel3.add(Button1);
        
          add(panel5, BorderLayout.NORTH);
          add(panel2, BorderLayout.CENTER);
          add(panel3, BorderLayout.SOUTH);
          
          Button1.addActionListener(new inner());
          
          //menue
          menuBar = new JMenuBar();
          setJMenuBar(menuBar);
          
          menu1 = new JMenu("exit");
          menuBar.add(menu1);
          exitItem = new JMenuItem("Exit");
          exitItem.setMnemonic(KeyEvent.VK_X);
          exitItem.addActionListener(new ExitListener());
          seprat = new JSeparator(); 
          menu1.add(exitItem);
          menu1.add(seprat);
          
          menu2 = new JMenu("Quick Operations");
          menuBar.add(menu2);
          avalible = new JCheckBoxMenuItem("List of all books available for rent");
          avalible.addActionListener(new Selectistener());
          unavalible = new JCheckBoxMenuItem("List of all unavailable for rent");
          unavalible.addActionListener(new Selectistener());
          menu2.add(avalible);
          menu2.add(seprat);
          menu2.add(unavalible);
          
          
          setVisible(true);
         }
    
    
    private class ExitListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    System.exit(0);
    }
    }
    
   public class Selectistener   extends JFrame implements ActionListener{
	   
	   public void actionPerformed(ActionEvent e){
	   
		   if (e.getSource()== avalible) {
		    Frame fourthWindow = new JFrame();
		    fourthWindow.setSize(300,300);
		    //fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    fourthWindow.setTitle("List of all book");
		    fourthWindow.setLocationRelativeTo(null);
           
                    fourthWindow.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
                    //read from file
          	    try{
          	    File availableBooks = new File("AvailableBooks.txt");
          	    Scanner readfile = new Scanner(availableBooks); //read from file 
          	    String[] books = new String[100];
          	    int i = 0;
          	    while(readfile.hasNext()){ 
          	    books[i] = readfile.nextLine();
          	    i++;
          	    } 
          	    JList bookList = new JList(books);
          	    JScrollPane scorl = new JScrollPane(bookList); 
          	    bookList.setBorder(BorderFactory.createLineBorder(Color.black,1));
          	    fourthWindow.add(scorl);
          	    readfile.close(); 
                }catch(Exception eb){
                    System.out.println("there is no book");
                }
          	fourthWindow.setVisible(true);   
                
		}else if(e.getSource()==unavalible)  {
	            Frame fourthWindow = new JFrame();
	            fourthWindow.setSize(300,300);
	            //fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            fourthWindow.setTitle("List of all book");
	            fourthWindow.setLocationRelativeTo(null);
           
	            fourthWindow.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
			   
	           try{
	              File unavailableBooks = new File("unavailableBooks.txt");
	              Scanner readfile = new Scanner(unavailableBooks);
	              String[] books = new String[100];
	              int i = 0;
	              while(readfile.hasNext()){ 
	              books[i] = readfile.nextLine();
			        i++;
			           } 
			      JList bookList = new JList(books);
			       JScrollPane scorl = new JScrollPane(bookList);
			       bookList.setBorder(BorderFactory.createLineBorder(Color.black,1));
			       fourthWindow.add(scorl);
			                    readfile.close(); 
			       }catch(FileNotFoundException ex){
			     System.out.println("there is no book");
			      }
	            fourthWindow.setVisible(true);
			                
			   
		   }
		   
		  
   }}
   
    private class inner implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            if(JRBV.isSelected()){
                vistor();
            }else if(JRBL.isSelected()){
                librarian();
            }
        }
    
        public void vistor (){
            //creat seconed window
            
            JFrame seconedWindo = new JFrame();
            seconedWindo.setSize(370,500);
            seconedWindo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            seconedWindo.setTitle("visitors");
            seconedWindo.setLocationRelativeTo(null);
            
            seconedWindo.setLayout(new BorderLayout());
            
          JRB_books = new JRadioButton("List of all library books");
          JRB_books.setBackground(Color.blue);
          JRB_books.setForeground(Color.WHITE);
          JRB_books.setFont(new Font("List of all library books ",Font.ITALIC,18));
          panel1 = new JPanel();
          panel1.add(JRB_books);
          
          JRB_availableBooks = new JRadioButton("List of all books available for rent");
          JRB_availableBooks.setBackground(Color.blue);
          JRB_availableBooks.setForeground(Color.WHITE);
          JRB_availableBooks.setFont(new Font("\"List of all books available for rent ",Font.ITALIC,18));
          panel2 = new JPanel();
          panel2.add(JRB_availableBooks);
          
          JRB_unavailableBooks = new JRadioButton("List of all books unavailable for rent");
          JRB_unavailableBooks.setBackground(Color.blue);
          JRB_unavailableBooks.setForeground(Color.WHITE);
          JRB_unavailableBooks.setFont(new Font("\"List of all books unavailable for rent ",Font.ITALIC,18));
          panel3 = new JPanel();
          panel3.add(JRB_unavailableBooks);
          
          JRB_rent = new JRadioButton("rent a book ");
          JRB_rent.setBackground(Color.blue);
          JRB_rent.setForeground(Color.WHITE);
          JRB_rent.setFont(new Font("\"rent a book ",Font.ITALIC,18));
          panel4 = new JPanel();
          panel4.add(JRB_rent);
          
          JRB_searching = new JRadioButton("searching about book ");
          JRB_searching.setBackground(Color.blue);
          JRB_searching.setForeground(Color.WHITE);
          JRB_searching.setFont(new Font("\"searching about book ",Font.ITALIC,18));
          panel5 = new JPanel();
          panel5.add(JRB_searching);
          
          
          JRB_image = new JRadioButton("most popular books");
          JRB_image.setBackground(Color.blue);
          JRB_image.setForeground(Color.WHITE);
          JRB_image.setFont(new Font("\"most popular books ",Font.ITALIC,18));
          panel8 = new JPanel();
          panel8.add(JRB_image);
          
          group2v = new ButtonGroup();
          group2v.add(JRB_books);
          group2v.add(JRB_availableBooks);
          group2v.add(JRB_unavailableBooks);
          group2v.add(JRB_rent);
          group2v.add(JRB_searching);
          group2v.add(JRB_image);
          
          
          JPanel panel6 = new JPanel();
          panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
          panel6.add(panel1);
          panel6.add(panel2);
          panel6.add(panel3);
          panel6.add(panel4);
          panel6.add(panel5);
          panel6.add(panel8);
          
            
          Button1 = new Button("clik");
          Button1.setBackground(Color.red);
          Button1.setForeground(Color.WHITE);
          JPanel panel7 = new JPanel();
          panel7.add(Button1);
          
          seconedWindo.add(panel6, BorderLayout.CENTER);
          seconedWindo.add(panel7, BorderLayout.SOUTH);
          
          Button1.addActionListener(new forVistor());
          seconedWindo.setVisible(true);
        }
        
        public void librarian(){
            JFrame thirdWindow = new JFrame();
            thirdWindow.setSize(500,500);
            thirdWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            thirdWindow.setTitle("librarian");
            thirdWindow.setLocationRelativeTo(null);
            
            thirdWindow.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
             
          JRB_availableBooks = new JRadioButton("add new available books to list");
          JRB_availableBooks.setBackground(Color.WHITE);
          JRB_availableBooks.setForeground(Color.PINK);
          JRB_unavailableBooks = new JRadioButton("add new unavailable books to list");
          JRB_unavailableBooks.setBackground(Color.WHITE);
          JRB_unavailableBooks.setForeground(Color.PINK);
          thirdWindow.add(JRB_availableBooks);
          thirdWindow.add(JRB_unavailableBooks);
          
          group2v = new ButtonGroup();
          group2v.add(JRB_availableBooks);
          group2v.add(JRB_unavailableBooks);
            
          Button1 = new Button("clik");
          Button1.setBackground(Color.red);
          Button1.setForeground(Color.blue);
          thirdWindow.add(Button1);
          Button1.addActionListener(new forlibrarian());
          
          thirdWindow.setVisible(true);
        }
    }
    
    private class forlibrarian implements ActionListener{

        public void actionPerformed(ActionEvent ae) {
            
             if(JRB_availableBooks.isSelected()){
                 
                 JFrame fourthWindow = new JFrame();
                 fourthWindow.setSize(200,200);
                 fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 fourthWindow.setTitle("add available Books");
                 fourthWindow.setLocationRelativeTo(null);
                 
                 fourthWindow.setLayout(new BorderLayout(10,10));
                 
                  text = new JTextField(30);
                  fourthWindow.add(text,BorderLayout.NORTH);
                  
                  label1 = new JLabel("");
                  fourthWindow.add(label1,BorderLayout.SOUTH);
                          
                  Button1 = new Button("done");
                  fourthWindow.add(Button1, BorderLayout.CENTER);
                  fourthWindow.setVisible(true);
                  
                  //here the proplem
                  Button1.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent ae){ 
                          try{
                            FileWriter availableBooks = new FileWriter("AvailableBooks.txt", true); 
                            PrintWriter bookFile = new PrintWriter(availableBooks); //open file                     
                            bookFile.println(text.getText());
                            bookFile.close(); //close file
                          }catch (IOException ex) {
                            System.out.print("File not Found !");
                          }
                            JFrame fifthWindow = new JFrame();
                            fifthWindow.setSize(500,100);
                            fifthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            fifthWindow.setTitle("result of adding");
                            fifthWindow.setLocationRelativeTo(null);
                              
                            label3 = new JLabel("The book has been successfully added to the list");
                          
                            fifthWindow.add(label3);
                            fifthWindow.setVisible(true);
                            fifthWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
                    
                    }});
                  
              }else{
                 JFrame fourthWindow = new JFrame();
                 fourthWindow.setSize(200,200);
                 fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 fourthWindow.setTitle("add Unavailable Books");
                 fourthWindow.setLocationRelativeTo(null);
                 
                 fourthWindow.setLayout(new BorderLayout(10,10));
                 
                  text = new JTextField(30);
                  fourthWindow.add(text,BorderLayout.NORTH);
                          
                  Button1 = new Button("done");
                  fourthWindow.add(Button1, BorderLayout.CENTER);
                  fourthWindow.setVisible(true);
                  
                  //here the proplem
                  Button1.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent ae){ 
                          try{
                            FileWriter unavailableBooks = new FileWriter("unavailableBooks.txt", true);
                            PrintWriter bookFile = new PrintWriter(unavailableBooks); //open file                    
                            bookFile.println(text.getText());
                            bookFile.close(); //close file
                          }catch (IOException ex) {
                            System.out.print("File not Found !");
                          }
                            JFrame fifthWindow = new JFrame();
                            fifthWindow.setSize(500,100);
                            fifthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            fifthWindow.setTitle("result of adding");
                            fifthWindow.setLocationRelativeTo(null);
                              
                            label3 = new JLabel("The book has been successfully added to the list");
                          
                            fifthWindow.add(label3);
                            fifthWindow.setVisible(true);
                            fifthWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
                    
                    }});
              }     
        }
    
}
    
    private class forVistor implements ActionListener{

        public void actionPerformed(ActionEvent ae) {
            
            if(JRB_books.isSelected()){
                
                JFrame fourthWindow = new JFrame();
                 fourthWindow.setSize(300,300);
                 fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 fourthWindow.setTitle("List of all book");
                 fourthWindow.setLocationRelativeTo(null);
                 
                 fourthWindow.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
               //read from file
                try{
                    File availableBooks = new File("AvailableBooks.txt");
                    Scanner readfile = new Scanner(availableBooks); //read from file 
                    String[] books = new String[100];
                    int i = 0;
                    while(readfile.hasNext()){ 
                        books[i] = readfile.nextLine();
                        i++;
                    } 
                    JList bookList = new JList(books);
                    JScrollPane scorl = new JScrollPane(bookList); 
                    bookList.setBorder(BorderFactory.createLineBorder(Color.black,1));
                    fourthWindow.add(scorl);
                    readfile.close(); 
                }catch(Exception e){
                    System.out.println("there is no book");
                }
                
                try{
                    File unavailableBooks = new File("unavailableBooks.txt");
                    Scanner readfile = new Scanner(unavailableBooks);
                    String[] books = new String[100];
                    int i = 0;
                    while(readfile.hasNext()){ 
                       books[i] = readfile.nextLine();
                        i++;
                    } 
                    JList bookList = new JList(books);
                    JScrollPane scorl = new JScrollPane(bookList);
                    bookList.setBorder(BorderFactory.createLineBorder(Color.black,1));
                    fourthWindow.add(scorl);
                    readfile.close(); 
                }catch(Exception e){
                    System.out.println("there is no book");
                }
                fourthWindow.setVisible(true);
                
            }else if(JRB_availableBooks.isSelected()){
                
                JFrame fourthWindow = new JFrame();
                 fourthWindow.setSize(300,300);
                 fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 fourthWindow.setTitle("List of all book");
                 fourthWindow.setLocationRelativeTo(null);
                 
                 fourthWindow.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
               //read from file
                try{
                    File availableBooks = new File("AvailableBooks.txt");
                    Scanner readfile = new Scanner(availableBooks); //read from file 
                    String[] books = new String[100];
                    int i = 0;
                    while(readfile.hasNext()){ 
                        books[i] = readfile.nextLine();
                        i++;
                    } 
                    JList bookList = new JList(books);
                    JScrollPane scorl = new JScrollPane(bookList);
                    bookList.setBorder(BorderFactory.createLineBorder(Color.black,1));
                    fourthWindow.add(scorl);
                    readfile.close(); 
                }catch(Exception e){
                    System.out.println("there is no book");
                }
                fourthWindow.setVisible(true);
                
            }else if(JRB_unavailableBooks.isSelected()){
                JFrame fourthWindow = new JFrame();
                 fourthWindow.setSize(300,300);
                 fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 fourthWindow.setTitle("List of all book");
                 fourthWindow.setLocationRelativeTo(null);
                 
                 fourthWindow.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
                //read from file
                try{
                    File unavailableBooks = new File("unavailableBooks.txt");
                    Scanner readfile = new Scanner(unavailableBooks);
                    String[] books = new String[100];
                    int i = 0;
                    while(readfile.hasNext()){ 
                       books[i] = readfile.nextLine();
                        i++;
                    } 
                    JList bookList = new JList(books);
                    JScrollPane scorl = new JScrollPane(bookList);
                    bookList.setBorder(BorderFactory.createLineBorder(Color.black,1));
                    fourthWindow.add(scorl);
                    readfile.close(); 
                }catch(Exception e){
                    System.out.println("there is no book");
                }
                fourthWindow.setVisible(true);
                
            }else if(JRB_rent.isSelected()){
                 JFrame fourthWindow = new JFrame();
                 fourthWindow.setSize(300,200);
                 fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 fourthWindow.setTitle("List of all book");
                 fourthWindow.setLocationRelativeTo(null);
                 
                 fourthWindow.setLayout(new BorderLayout(10,10));
                 
                 JPanel panel1 = new JPanel();
                 label1 = new JLabel("select the book:");
                 panel1.add(label1);
                 panel1.setBorder(BorderFactory.createLineBorder(Color.black,1));
                 try{
                    File availableBooks = new File("AvailableBooks.txt");
                    Scanner readfile = new Scanner(availableBooks); //read from file 
                    String[] books = new String[100];
                    int i = 0;
                    while(readfile.hasNext()){ 
                        books[i] = readfile.nextLine();
                        i++;
                    } 
                    JList bookList = new JList(books);
                    bookList.setVisibleRowCount(3);
                    JScrollPane scorl = new JScrollPane(bookList);
                    bookList.setBorder(BorderFactory.createLineBorder(Color.black,1));
                    panel1.add(scorl);
                    readfile.close(); 
                }catch(Exception e){
                    System.out.println("there is no book");
                }
                fourthWindow.add(panel1,BorderLayout.NORTH);
                
                JPanel panel2 = new JPanel();
                label2 = new JLabel("How many dayes:");
                text = new JTextField(2);
                Button1 = new Button("ok");
                
                panel2.add(label2);
                panel2.add(text);
                
                Button1.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent ae){ 
                          JFrame fifthWindow = new JFrame();
                              fifthWindow.setSize(300,100);
                              fifthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                              fifthWindow.setTitle("List of all book");
                              fifthWindow.setLocationRelativeTo(null);
                          try {
                              String number = text.getText();
                              int num = Integer.parseInt(number);
                              label3 = new JLabel("price: "+ num*15);
                          } catch (Exception ex) {
                            label3 = new JLabel("you do not enter a number");
                          }
                          fifthWindow.add(label3);
                          fifthWindow.setVisible(true);
                          fifthWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
                    }});
                
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
                fourthWindow.add(panel2,BorderLayout.CENTER);
                fourthWindow.add(Button1,BorderLayout.SOUTH);
                //panel2.add(BorderFactory.createLineBorder(Color.black,1));
                fourthWindow.setVisible(true);
                
            }else if(JRB_searching.isSelected()){
                 JFrame fourthWindow = new JFrame();
                 fourthWindow.setSize(400,400);
                 fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 fourthWindow.setTitle("searching");
                 fourthWindow.setLocationRelativeTo(null);
                 fourthWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
               label1 = new JLabel("Enter the name of book:");
               text = new JTextField(20);
               Button1 = new Button("search");
               Books search = new Books(text.getText());
               
               fourthWindow.add(label1);
               fourthWindow.add(text);
               fourthWindow.add(Button1);
               
               Button1.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent ae){ 
                        try{
                            search.setSearch(text.getText());
                        }catch(FileNotFoundException e){
                            System.out.println("File not found");
                        }
                            JFrame fifthWindow = new JFrame();
                            fifthWindow.setSize(300,100);
                            fifthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            fifthWindow.setTitle("result of search");
                            fifthWindow.setLocationRelativeTo(null);
                              
                             label3 = new JLabel(search.toString());
                          
                            fifthWindow.add(label3);
                            fifthWindow.setVisible(true);
                            fifthWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
                    }});
               fourthWindow.setVisible(true);
            }else if(JRB_image.isSelected()){
                 JFrame fourthWindow = new JFrame();
                 fourthWindow.setSize(500,300);
                 fourthWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 fourthWindow.setTitle("image of most popular books");
                 fourthWindow.setLocationRelativeTo(null);
                 fourthWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
                 
                 ImageIcon image = new ImageIcon("C:/Users/arwao/Desktop/first.jpg");
                 label1 = new JLabel(image);
                 fourthWindow.add(label1);
                 
                 ImageIcon image2 = new ImageIcon("C:/Users/arwao/Desktop/sec.jpg");
                 label2 = new JLabel(image2);
                 fourthWindow.add(label2);
                 
                 ImageIcon image3 = new ImageIcon("C:/Users/arwao/Desktop/third.jpeg");
                 label3 = new JLabel(image3);
                 fourthWindow.add(label3);
                 
                 fourthWindow.setVisible(true);
            } 
        }
    
    
    }

   
    public static void main(String[] args) throws IOException {
        
        new FriendLibraries();

    }//end main methods
    
}//end class
