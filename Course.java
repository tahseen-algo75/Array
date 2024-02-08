
public class Course implements Cloneable {
    private String name;
    private String department;
    private int code;
    private byte section;
    private String instructor;

    public Course(){}
    
    public Course(String name, String department, int code, byte section, String instructor){
        this.name = name;
        this.department = department;
        this.code = code;
        this.section = section;
        this.instructor = instructor;
    }
    /* @return
     * It returns the name of the course as a String value.
     */
    public String getName(){
        return name;
    }
    /* @return
     * It returns the name of the department as a String value.
    */
    public String getDepartment(){
        return department;
    }
    /* @return
     * It returns the name of the code as an integer value.
    */
    public int getCode(){
        return code;
    } 
    /* @return
     * It returns the name of the section as a byte value.
    */
    public byte getSection(){
        return section;
    }
    /* @return
     * It returns the name of the instructor as a String value.
    */
    public String getInstructor(){
        return instructor;
    }
    /* @param name
     * It can set a new Course name.
    */
    public void setName(String name){
        this.name = name;
    }
    /* @param department
     * It can set a new department name.
    */
    public void setDepartment(String department){
        this.department = department;
    }
    /* 
    @param code
    if the code is negative then it throws an IllegalArgumentException.
    It can set a new code value.
    */
    public void setCode(int code) {
        this.code = code;
        if(code < 0) throw new IllegalArgumentException("Invalid code..");
    }
    /*@param section
    if the section is negative then it throws an IllegalArgumentException. 
    It can set a new section value.
     */
    public void setSection(byte section) {
        this.section = section;
        if(section < 0) throw new IllegalArgumentException("Invalid section..");
    }
    /* @param department
     * It can set the new instructor of the course.
    */
    public void setInstructor(String instructor){
        this.instructor = instructor;
    }
    /* @ return
     * It creates and return the copy of the course object
     */
    public Object clone(){     
        Course newCourse = new Course(this.name, this.department, this.code, this.section, this.instructor);
        return newCourse;
    }
    /*
     * @return
     * It will compare the instace of an object and will return a boolean value
     * based on the comparison
     */
    public boolean equals(Object obj){
        if(obj instanceof Course){
            Course c = (Course)obj;
            return this.code == c.code && this.section == c.section && this.name.equals(c.name) && 
            this.department.equals(c.department) && this.instructor.equals(c.instructor);
        }
        return false;
    }
}








  










