import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 ** Η κλάση Course παριστά ένα μάθημα στο σύστημα του φοιτητολογίου.
 */

public class Course {

    private String courseName;
    private String courseId;
    private String coursesemester;
    private String info;

    public Course (String CourseName)
    {
        this.courseName = CourseName;
    }


    //Getters and Setters not in use
    public String getcourseId ()
    {
        return courseId;
    }

    public void setcourseId (String courseId)
    {
        this.courseId = courseId;
    }

    public String getcourseName ()
    {
        return courseName;
    }

    public void setcourseName (String courseName)
    {
        this.courseName = courseName;
    }

    public String getcoursesemester ()
    {
        return coursesemester;
    }

    public void setcoursesemester (String coursesemester)
    {
        this.coursesemester = coursesemester;
    }

    Path pCourse = Paths.get("C:\\Users\\Anna\\IdeaProjects\\UniSystemManager\\src\\course.txt");
    Path pTemp = Paths.get("C:\\Users\\Anna\\IdeaProjects\\UniSystemManager\\src\\tmp.txt");
    File coursefile = new File(String.valueOf(pCourse));
    File temp = new File(String.valueOf(pTemp));

    Scanner input = new Scanner(System.in);

    Course() {}

    Course(String courseId, String  courseName ,String coursesemester) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursesemester = coursesemester;
    }

    /**
     * Μέθοδος εγγραφής νέου μαθήματος
     * Η εγγραφή γίνεται απευθείας στο αρχείο καταγραφής course.txt
     *
     */

    void createCourse() {

        System.out.println("Enter Course Name: ");
        courseName = input.nextLine();
        System.out.println("Enter Course ID: ");
        courseId = input.nextLine();
        System.out.println("Enter Semester: ");
        coursesemester = input.nextLine();

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(coursefile, true)))){
            out.println("\n" + courseId + " " + courseName + " " + coursesemester);
        } catch(IOException e){
            System.out.println("File Not Found!");
        }

        System.out.println("Course Created.");
    }

    /**
     * Μέθοδος που εμφανίζει τις εγγραφές των μαθημάτων (κωδικός, ονομασία, εξάμηνο)
     */

    void viewCourse() {
        System.out.println("COURSE ID \t\t COURSE NAME \t\t SEMESTER");
        System.out.println("=========================================");
        try(Scanner in = new Scanner(coursefile)){
            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String semester = in.nextLine();
                System.out.println(id + " \t\t " + name + " \t\t\t " +semester + "\n");
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found!");
        }
    }

    /**
     * Μέθοδος που τροποποιεί την εγγραφή ενός μαθήματος
     */

    void modifyCourse() {

        System.out.print("Enter Course ID to modify its Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(coursefile);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String semester = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    System.out.print("Enter Course Name to modify: ");
                    String textName = input.nextLine();

                    System.out.print("Enter Course ID to modify: ");
                    String textId = input.nextLine();

                    System.out.print("Enter Course Cemester to modify: ");
                    String textsemester = input.nextLine();

                    write.println(textId + " " + textName + " " + textsemester);
                    flag = 1;
                    System.out.println("Course Modification completed.");
                } else{
                    write.println(id + " " + name + " " + semester + " " );
                }
            }

            if (flag == 0){
                System.out.println("The course record of the entered ID isn't available.");
            }
            write.close();
            in.close();


        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }

        try {
            Scanner in = new Scanner(temp);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(coursefile, false)));

            while(in.hasNextLine()){
                write.println(in.nextLine());
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }
    }

    /**
     * Μέθοδος που διαγράφει την εγγραφή ενός μαθήματος
     */

    void deleteCourse(){

        System.out.print("Enter Course ID to delete its Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(coursefile);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String semester = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    flag = 1;
                    System.out.println("Course Deleted.");
                } else{
                    write.println(id + " " + name + " " + semester);
                }
            }

            if (flag == 0){
                System.out.println("The course record of the entered ID isn't available.");
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }

        try {
            Scanner in = new Scanner(temp);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(coursefile, false)));

            while(in.hasNextLine()){
                write.println(in.nextLine());
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }
    }
}
