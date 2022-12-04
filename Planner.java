package Homework1;
/*
 * @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
public class Planner implements Cloneable{
	final static int MAX_COURSES = 50;
    int totalCourses;
    Course [] courses; 
    
    public Planner(){
        courses = new Course[MAX_COURSES];
    }
    public int size(){    
        return totalCourses;
    }
    public boolean exists(Course course){
        for(int i = 0; i < totalCourses; i++){
            if(courses[i].equals(course)){
                return true;
            }
        }
        return false;
    }
    public Object clone() throws java.lang.CloneNotSupportedException {  
        Planner planner;
        planner = (Planner) super.clone();
        planner.courses = (Course[])courses.clone();
        return planner;
    }
    public Course getCourse(int position){
        if(position > totalCourses) throw new IllegalArgumentException("Invalid positon");
        if(position < 1) throw new IllegalArgumentException("Invalid position");
        return courses[position-1];
    }
    public void printAllCourses(){
        System.out.println(this);
    }
    public void addCourse(Course newCourse, int position) throws FullPlannerException {
        if(totalCourses == MAX_COURSES) throw new FullPlannerException("The Planner is full");
        position = position-1;
        if(position >= totalCourses + 1) throw new IllegalArgumentException("Invalid position.");
        if(position < 0) throw new IllegalArgumentException("Invalid position");
        
        if(position != totalCourses + 1){
            for(int i = totalCourses; i > position; i--){
                courses[i] = courses[i-1];
            }
        }
        courses[position] = newCourse;
        totalCourses++;
    }
    public void addCourse(Course newCourse) throws FullPlannerException{
        addCourse(newCourse, size()+1);
     }
    public void removeCourse(int position){
        if(position > totalCourses) throw new IllegalArgumentException("Invalid position");
        if(position < 1) throw new IllegalArgumentException("Invalid position");

        if(position == totalCourses){
        courses[totalCourses-1] = null;
        totalCourses--;
        }else{
            for(int i = position; i < totalCourses; i++){
                courses[i-1] = courses[i];
            }
            totalCourses--;
        }
    }
    public static void filter(Planner planner, String department){
        System.out.printf("No. ", "CourseName", "Department", "Code", "Section","Instructor" );
        
        for(int i = 0; i < planner.size(); i++){
        	Course course = planner.getCourse(i);
        	if (course.getDepartment().equals(department)) {
        		System.out.printf(course.getName(), course.getDepartment(), course.getCode(), 
                + course.getSection(), course.getInstructor());
            }
        }
    }
    public String toString(){
        String st1 = String.format("No.","Name","Department","Code","Section","Instructor" );
        int i = 0;
        while(i<size()) {
            Course course = courses[i];
            String st2 = String.format("%-21s%-26s%19s%06d", course.getName(),
            course.getDepartment(), course.getCode(), + course.getSection(), course.getInstructor());
            i++;
            return st1+st2;
           }
        return "";
   }
}       


    



    


   
    
    
    


   

    

