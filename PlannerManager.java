
import java.util.Scanner;
public class PlannerManager {
    public static void main(String[] args) {
        Planner planner = new Planner();
        Planner backupPlan = null;
        String selection = "";
        Scanner sc = new Scanner(System.in);
        
        while (!selection.equals("Q")) {
        mainMenu(); 
        System.out.print("Enter a selection: ");
        selection = sc.nextLine();
        switch (selection) {
        case "A":
        	try {
        		System.out.println("Enter course name: ");
        		String name = sc.nextLine();
        		System.out.println("Enter department: ");
                String department = sc.nextLine();
                System.out.println("Enter course code: ");
                String strCode = sc.nextLine();
                int code = Integer.parseInt(strCode);
                System.out.println("Enter course section: ");
                String strSection = sc.nextLine();
                byte section = Byte.parseByte(strSection);
                System.out.println("Enter instructor: ");
                String instructor = sc.nextLine();
                System.out.println("Enter position: ");
                int position = sc.nextInt();
                
                Course course = new Course(name, department, code, section, instructor);
                planner.addCourse(course, position);
                System.out.println(department + " " + code + "." + section + " succesfully added to planner");
                break;
            }catch(Exception e) {
                System.out.println("Invalid value, Back to the main menu");
                break;
                }
                case "G":
                System.out.println("Enter position: ");
        	    	int position = sc.nextInt();
                    Course course = planner.getCourse(position);
        	    	String st1 = String.format("No.", "Course Name",
                    "Department", "Code", "Section", "Instructor");
        	    	
        	    	String st2 = "";
                    st2 += String.format("\"%-21s%-26s%19s%06d\"",position, course.getName(),
                    course.getDepartment(), course.getCode(), "0" + course.getSection(), course.getInstructor());
                    System.out.println(st1+st2);
                    break;
                    case "S":
                    System.out.println(planner.size());
                    break;
                case "R": 
        	    	  System.out.println("Enter position: ");
        	    	  position = sc.nextInt();
        	    	  course = planner.getCourse(position);
        	    	  String department = course.getDepartment();
        	    	  int code = course.getCode();
        	    	  byte section = course.getSection();
        	
        	    	  try {
        	    		  planner.removeCourse(position);
        	    	  }catch (Exception e) {
        	    		  System.out.println("Back to the main menu");
        	    		  break;
        	    		  }
        	    	  System.out.printf(department, code, section);
        	    	  break;
        	    	    case "P":
                        planner.printAllCourses();
                        break;
        	    		  case "F": 
        	    			  System.out.println("Enter department code: ");
        	    			  String st = sc.nextLine();
        	    			  Planner.filter(planner, st);
        	    			  break;
        	    		    case "B": 
        	    			  try {
        	    			  backupPlan = (Planner) planner.clone();
        	    			  } catch (Exception e) {
								
							}
        	    			    case "L": 
        	    				  try {
        	    					  System.out.print("Enter course name: ");
        	    					  String name = sc.nextLine();
        	    					  System.out.print("Enter department: ");
        	    					  department = sc.nextLine();
        	    					  System.out.print("Enter course code: ");
        	    					  String strCode = sc.nextLine();
        	    					  code = Integer.parseInt(strCode);
        	    					  System.out.print("Enter course section: ");
        	    					  String strSection = sc.nextLine();
        	    					  section = Byte.parseByte(strSection);
        	    					  System.out.print("Enter instructor: ");
        	    					  String instructor = sc.nextLine();

        	    					  course = new Course(name, department, code, section, instructor);
        	    					  planner.exists(course);
        	    				  } catch (Exception e) {
        	    					  System.out.println("Invalid value, Back to the main menu");
        	    				  }
        	    				  break;
        						}
        						}
    }
    public static void mainMenu() {
    	String menu = "(A) Add Course\n(G) Get Course\n(R) Remove Course\n"
    	+ "(P) Print Courses in Planner\n(F) Filter by Department Code\n"
    	+ "(L) Look For Course\n(S) Size\n(B) Backup\n(PB) Print Courses in Backup\n"
    	+ "(RB) Revert to Backup\n(Q) Quit\n";
    	System.out.println(menu);
    	}
    }
    


               



























































/* 
import java.util.Scanner;
public class PlannerManager extends Planner {
    public static void main(String[]args){
        Planner planner = new Planner();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a selection : ");
        String selection = sc.nextLine();
        try{
            switch(selection){
                case "A" :
                System.out.println("Enter course name : ");
                String courseName = sc.nextLine();
                System.out.println("Enter department : ");
                String department = sc.nextLine();
                System.out.println("Enter course code : ");
                int code = sc.nextInt();
                /*  
                try{
                    setCode(code);
                }catch(Exception e){
                    System.out.println(e);
                }
                
                System.out.println("Enter course section : ");
                byte section = sc.nextByte();
                System.out.println("Enter instructor : ");
                String instructor = sc.nextLine();
                System.out.println("Enter postion : ");
                int position = sc.nextInt();
            }
        }
        catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }
}
*/

