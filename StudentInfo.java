
/**
 * Write a description of class StudentMark here.
 *
 * @author (your name)
 * @version (a version number or a date)

*/


import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StudentInfo{
    
    
    public static void seeTotalMark(Student[] studentArray) {
     System.out.println("list of student with total mark:" +   "\n");
       for(int i=0;i<studentArray.length;i++) {
        
            System.out.println("Full Name" + ": " + studentArray[i].getfirstName() + " " + studentArray[i].getlastName() + " assessmsent marks are:" + studentArray[i].getMark1() + "," + studentArray[i].getMark2() + "," + studentArray[i].getMark3() + " " + "  and total Marks: " +  studentArray[i].getTotalMarks()      );
        }
    }
    
    public static void checkThreshold(Student[] studentArray) {
      Scanner myObj = new Scanner(System.in);
              System.out.println("Enter threshold to select student: ");
                   int filterCount=0;
               int threshold = myObj.nextInt();  
                         Student[] filterArray = new Student[58];
               for(int j=0;j<studentArray.length;j++) {
                
                   if(Double.parseDouble(studentArray[j].getTotalMarks())<threshold)
                   {
                      Student fStudent = 
                    new Student(
                    studentArray[j].getfirstName(),
                    studentArray[j].getlastName(),
                    studentArray[j].getId(),
                    studentArray[j].getMark1(),
                    studentArray[j].getMark2(),
                    studentArray[j].getMark3(),
                   studentArray[j].getTotalMarks()
                    );
                    filterArray[filterCount] =fStudent ;
                    filterCount++;
                    }
                }
                       if(filterArray[0] == null) {
                System.out.println("No Student with the marks less than given threshold");
                }
                  else {
               
               
            for(int l=0;l<filterArray.length;l++) {
            
                if(filterArray[l] !=null) {
                
                 System.out.println("Full Name" + ": " + filterArray[l].getfirstName() + " " + filterArray[l].getlastName() + " and total Marks: " +  filterArray[l].getTotalMarks()      );
              }
            
        }
                   
                }
               
    }
    
    public static void highestLowestCalculate(Student[] studentArray) {
         ArrayList<Student> list = new ArrayList<Student>();
         for(int k=0;k<studentArray.length;k++) {
                  list.add(new Student(
                    studentArray[k].getfirstName(),
                    studentArray[k].getlastName(),
                    studentArray[k].getId(),
                    studentArray[k].getMark1(),
                    studentArray[k].getMark2(),
                    studentArray[k].getMark3(),
                    studentArray[k].getTotalMarks()
                    ));
            }
            
                    int display=0;
                         System.out.println("lowest scoring students are:");
         list.sort((o1, o2)
                  -> o1.getTotalMarks().compareTo(
                      o2.getTotalMarks()));
                      
             for(int m=0;m<list.size();m++) {
                        
                          
                          if(m<10) {
                           
                            
                            
                              System.out.println(list.get(m).getfirstName() + " " + list.get(m).getlastName() + " " +list.get(m).getTotalMarks());
                            
                            }
                            if(m>= list.size()-10) {
                                
                                if(display==0) {
                                        System.out.print(System.lineSeparator());
                                
                                        System.out.println("Highest scoring students are marks:");
                                    
                                    }
                                display++;
                                
                                
                              System.out.println(list.get(m).getfirstName() + " " + list.get(m).getlastName() + " " +list.get(m).getTotalMarks());
                            
                            }
                          
                          
                        }          
                      
    }
    
      public static void seeData(Student[] studentArray, String data,int size) {  
          
              
       
String [] extract = data.split(",");
double totalMark=0;
String tempFirstName="",tempLastName="",id="",a1="",a2="",a3="";


for(int i=0;i<extract.length;i++)  {
if(extract[i].isEmpty()) {
    extract[i]="0.0";
}



if(i==0)  {
tempLastName=extract[i];
}
else if (i==1) {
tempFirstName=extract[i];
}
else if(i==2) {
id=extract[i];
}
else if(i==3) {
    
a1=extract[i];
}
else if(i==4) {
a2=extract[i];
}
else if(i==5) {
a3=extract[i];
}

}

for (int i=3;i<extract.length;i++) {

  double temp;
  try {
    temp = Double.parseDouble(extract[i]);
    }
    catch (NumberFormatException e) {
   temp = 0;
}
 totalMark = totalMark + temp  ; 
   

}

Student studentk = new Student(tempFirstName,tempLastName,id,a1,a2,a3,String.valueOf(totalMark));
if(size>-1)   {
studentArray[size] = studentk;
}        
        
}


public static void choiceMenu(int choice,Student[] studentArray) {

       switch (choice) {
                
                case 1:
                     seeTotalMark(studentArray);
                     
                     
               Scanner scan = new Scanner(System.in);
        System.out.print("Enter your choice: ");
      
          choice = scan.nextInt();
          
       
            choiceMenu(choice,studentArray); 
                     
                     break;
                     
                     case 2:
                        checkThreshold(studentArray);
                               scan = new Scanner(System.in);
        System.out.print("Enter your choice: ");
      
          choice = scan.nextInt();
          
       
            choiceMenu(choice,studentArray); 
                   scan = new Scanner(System.in);
        System.out.print("Enter your choice: ");
      
          choice = scan.nextInt();
          
       
            choiceMenu(choice,studentArray); 
                        break;
                        
                        case 3:
                            highestLowestCalculate(studentArray);
                                   scan = new Scanner(System.in);
                      System.out.print("Enter your choice: ");
                  choice = scan.nextInt();
            choiceMenu(choice,studentArray); 
                            break;
                
                }
    
}
    
    public static void main(String[] args) throws FileNotFoundException {
    
        int userChoice = 0;
        int lineNumber=0;
         Student[] studentArray = new Student[58];
        
        File file = new File(
            "/Users/enfniyinnovations/Desktop/exampleFile.csv"); 
      BufferedReader reader= null;
      String line="";
        String [] student={};
        int arrCount=0;
       
       try {
           reader  = new BufferedReader(new FileReader(file));
           
           reader.readLine();
             reader.readLine();
           while((line = reader.readLine())!= null) {
             
             student = line.split("\n");
          
             for(String k:student){
                 
                    seeData(studentArray,k,arrCount);
                      arrCount++;
                    
                 
                }
            }     
        }
        catch(Exception e) 
        {
        e.printStackTrace();
        }
        finally {
           
            try{
             reader.close();
             // student array save data operation now
  
             System.out.println("Press 1 to see all student info " + "\n" + "Press 2 to filter by threshold" + "\n" + "Press 3 to  see top 10 highest and lowest student" + "\n");
             
          
                 int choice=0;
               Scanner scan = new Scanner(System.in);
        System.out.print("Enter your choice: ");
      
          choice = scan.nextInt();
          
       
            choiceMenu(choice,studentArray);     
                   
           
        
  
             
            } 
            catch(IOException e)  {
            e.printStackTrace();
            }
            
        }
    
        
     
    
    }
}
class  Student {
    
    public String firstName, lastName,id,mark1,mark2,mark3;
public String totalMarks;


public   Student(String firstName,String lastName,String id,String mark1,String mark2,String mark3, String totalMarks ) {
    super();
this.firstName=firstName;
this.lastName=lastName;
this.totalMarks=totalMarks;
this.mark1=mark1;
this.mark2=mark2;
this.mark3=mark3;
this.id=id;
}

public String getId() {
return id;
}

public String getMark1() {
return mark1;
}

public String getMark2() {
return mark2;
}

public String getMark3() {
return mark3;
}

public String getfirstName() {
return firstName;
}

public String getlastName() {
return lastName;
}

public String getTotalMarks() {
return totalMarks;
}
    
    
    
    }






















