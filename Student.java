import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 ** Η κλάση Student παριστά ένα φοιτητή στο σύστημα του φοιτητολογίου.Η κλάση κληρονομεί την κλάση {Person}.
 */
public class Student extends Person
{
    private String studentId;
    private int Semester;

    //Constructor (not in use)
    public Student (String studentId,String PersonName,String PersonSurname, String PersonEmail, String PersonContactno, int Semester) {
        super ( PersonName,PersonSurname,PersonEmail,PersonContactno);
        this.studentId=studentId;
        this.Semester=Semester;
    }
    //Getters-Setters (Not in use)
    public String getstudentId ()
    {
        return studentId;
    }
    public void setstudentId (String studentId)
    {
        this.studentId = studentId;
    }

    public int getSemester ()
    {
        return Semester;
    }

    public void setSemester (int Semester)
    {
        this.Semester= Semester;
    }

    String info;

     static Path pStudent = Paths.get("C:\\Users\\Anna\\IdeaProjects\\UniSystemManager\\src\\student.txt");
     static Path pTemp = Paths.get("C:\\Users\\Anna\\IdeaProjects\\UniSystemManager\\src\\tmp.txt");
    File studentFile = new File(String.valueOf(pStudent));
    File temp = new File(String.valueOf(pTemp));

    Scanner input = new Scanner(System.in);

     Student(){}

    Student(String studentId, String studentName, String studentSurname, String contactNum, String email, int semester,String course){

        this.studentId = studentId;
        this.PersonName = studentName;
        this.PersonSurname = studentSurname;
        this.PersonContactno = contactNum;
        this.PersonEmail = email;
        this.Semester = semester;
        //this.course = course;
    }

    /**
     * Μέθοδος που αναζητά ένα  φοιτητή με κριτήριο τον αριθμό μητρώου του ο οποίος δίνεται ως είσοδος
     * αντλώντας την πληροφορία απευθείας από το αρχείο καταγραφής @param studentFile
     * Ταυτόχρονα γίνεται έλεγχος για σωστή εισαγωγή του ΑΜ καθώς και για την ύπαρξη του αρχείου.
     */

   void viewStudentInfo(){

        System.out.print("Enter Student ID to view his/her Student Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(studentFile);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String surn = in.next().trim();
                String cnum = in.next().trim();
                String mail = in.next().trim();
                String sem = in.next().trim();
                String courses = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    flag = 1;

                    System.out.println("Student ID: " + id);
                    System.out.println("Student Name: " + name);
                    System.out.println("Student Surname: " + surn);
                    System.out.println("Student Contact Number: " + cnum);
                    System.out.println("Student Email Adrress: " + mail);
                    System.out.println("Student Semester: " + sem);
                    System.out.println("Student Courses: " + courses);
                }
            }

            if (flag == 0){
                System.out.println("The Student record of the entered ID isn't available.");
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }
    }

    /**
     * Μέθοδος που διαγράφει έναν φοιτητή με κριτήριο τον αριθμό μητρώου του που δίνεται ως είσοδος
     *  απευθείας από το αρχείο καταγραφής studentFile
     *  Ταυτόχρονα γίνεται έλεγχος για σωστή εισαγωγή του ΑΜ καθώς και για την ύπαρξη του αρχείου και
     *  "άδειασμα" του προσωρινού αρχείου tmp από τις εγγραφές προκειμένου να χρησιμοποιηθεί σε άλλη διεργασία.
     */

    void deleteStudentInfo(){

        System.out.print("Enter Student ID to Delete his/her Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(studentFile);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String surn = in.next().trim();
                String cnum = in.next().trim();
                String mail = in.next().trim();
                String sem = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    flag = 1;
                    System.out.println("Student Record Deleted.");
                } else{
                    write.println(id + " " + name + " " + surn + " " + cnum + " " + mail + " " + sem);
                }
            }

            if (flag == 0){
                System.out.println("The Student record of the entered ID isn't available.");
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }

        try {

            Scanner in = new Scanner(temp);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(studentFile, false)));

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
     * Μέθοδος που τροποποιεί την εγγραφή ενός φοιτητή με κριτήριο τον αριθμό μητρώου του που δίνεται ως είσοδος
     * αντλώντας την πληροφορία απευθείας από το αρχείο καταγραφής @param studentFile
     * Επίσης:
     * γίνεται έλεγχος για σωστή εισαγωγή του ΑΜ καθώς και για την ύπαρξη του αρχείου και
     *  "άδειασμα" του προσωρινού αρχείου tmp από τις εγγραφές προκειμένου να χρησιμοποιηθεί σε άλλη διεργασία
     *  και εμφάνιση της τροποποιημένης εγγραφής
     */

     void modifyStudentInfo(){

        System.out.print("Enter Student ID to modify his/her Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(studentFile);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String surn = in.next().trim();
                String cnum = in.next().trim();
                String mail = in.next().trim();
                String sem = in.next().trim();
                String courses = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    System.out.print("Enter Student ID to modify: ");
                    this.studentId = input.nextLine();

                    System.out.print("\nEnter Student Name to modify: ");
                    this.PersonName = input.nextLine();

                    System.out.print("\nEnter Student Surname to modify: ");
                    this.PersonSurname = input.nextLine();

                    System.out.print("\nEnter Student Contact Number to modify: ");
                    this.PersonContactno = input.nextLine();

                    System.out.print("\nEnter Student Email Address to modify: ");
                    this.PersonEmail = input.nextLine();

                    System.out.print("\nEnter Student Semester to modify: ");
                    this.Semester = Integer.parseInt(input.nextLine());

                    write.println(studentId + " " + PersonName + " " + PersonSurname + " " + PersonContactno + " " + PersonEmail + " " + Semester);
                    flag = 1;
                    System.out.println("Student Record Modification completed.");
                } else{
                    write.println(id + " " + name + " " + surn +" " + cnum + " " + mail + " " + sem);
                }
            }

            if (flag == 0){
                System.out.println("The Student record of the entered ID isn't available.");
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }


        try {
            Scanner in = new Scanner(temp);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(studentFile, false)));

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
     * Μέθοδος εισαγωγής στοιχείων ενός φοιτητή
     * Η εγγραφή γίνεται απευθείας στο αρχείο καταγραφής
     *
     */

    public void createStudent(){

        System.out.print("Enter Student ID: ");
        this.studentId = input.nextLine();

        System.out.print("\nEnter Student Name: ");
        this.PersonName = input.nextLine();

        System.out.print("\nEnter Student Surname: ");
        this.PersonSurname = input.nextLine();

        System.out.print("\nEnter Student Contact Number: ");
        this.PersonContactno = input.nextLine();

        System.out.print("\nEnter Student Email Address: ");
        this.PersonEmail = input.nextLine();

        System.out.print("\nEnter Student Semester: ");
        this.Semester = Integer.parseInt(input.nextLine());

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(studentFile, true)))){
            out.println("\n" + studentId + " " + PersonName + " " + PersonSurname + " " + PersonContactno + " " + PersonEmail + " " + Semester);
        } catch(IOException e){
            System.out.println("File Not Found!");
        }

        System.out.println("Student Record Created.");

    }

   void viewAllStudent() {
        System.out.println("Student ID: " + "|" +" Student Name: " +  "|" + " Student Surname: " +  "|" + " Student Contact Number: " +  "|" + " Student Email Adrress: " +  "|" + " Student Semester: "+  "|" + " Student Courses: "  );
        System.out.println("============================================================================================================================");
        try(Scanner in = new Scanner(studentFile)){
            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String surn = in.next().trim();
                String cnum = in.next().trim();
                String mail = in.next().trim();
                String sem = in.next().trim();
                String courses = in.nextLine();

                System.out.println(" " + id + "     " + name + "             " + surn + "            " + cnum + "             " + mail + "           " + sem + "                     " + courses);

                /* ---------------------------a different output form
                System.out.println("Student Name: " + name);
                System.out.println("Student Surname: " + surn);
                System.out.println("Student Contact Number: " + cnum);
                System.out.println("Student Email Adrress: " + mail);
                System.out.println("Student Semester: " + sem);
                System.out.println("Student Course: " + course);
                System.out.println("\n"); */
            }
        } catch(FileNotFoundException e)
        {
            System.out.println("File Not Found!");
        }
    }

    /**
     * Μέθοδος ανάθεσης μαθήματος σε φοιτητή με βάση τον ΑΜ του.
     * Γίνεται αναζήτηση στο αρχείο καταγραφής βάσει το ΑΜ,η εγγραφή καταχωρείται σε Arraylist στην οποία προστίθεται
     * το νέο μάθημα και στη συνέχεια επαναγράφεται στο αρχείο.
     *
     */

    public void addCourseToStudent() throws IOException {
        String splitBy = " ";

        BufferedReader bufReader = new BufferedReader(new FileReader(String.valueOf(pStudent)));
        ArrayList<String> listOfLines = new ArrayList<>();
        System.out.println("Input Student ID");
        Scanner sc = new Scanner(System.in);
        String studid = sc.next();
        System.out.println("Input Course");
        Scanner sc1 = new Scanner(System.in);
        String course = sc1.next();
        String line = null;
        try {
            line = bufReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String oldline = null;
        while (line != null) {
            String[] b = line.split(splitBy);
            if (b[0].equals(studid)) {
                oldline = line;
                listOfLines.add(line + " " + course);

            }
            try {

                line = bufReader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String newline = null;
        for (String s : listOfLines) {
            String p = System.lineSeparator();
            newline = s + p;
            System.out.println(newline);
        }
        replacefin(oldline, newline);
        replacefiles();
        erasetmp();
        EmptyLines();
        ReverseFiles();
        erasetmp();
    }

    /**
     * Μέθοδος ανάθεσης για το άδειασμα του προσωρινού αρχείου εγγραφών

     */

    void erasetmp() throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(String.valueOf(pTemp));
        writer.print("");

        writer.close();
    }

    /**
     * Μέθοδος που αντικαθιστά τη νέα εγγραφή στο προσωρινό αρχείο
     */

    void replacefin(String stringToReplace, String replaceWith) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(String.valueOf(pStudent)));
        BufferedWriter tmp = new BufferedWriter(new FileWriter(String.valueOf(pTemp)));

        String line;

        while ((line = in.readLine()) != null) {
            if (line.contains(stringToReplace))
                line = line.replace(stringToReplace, replaceWith);
            tmp.write(line);
            tmp.newLine();
        }
        in.close();
        tmp.close();
    }

    /**
     * Μέθοδος με την οποία γίνεται εγγραφή του προσωρινού αρχείου στο αρχείο καταγραφής
     */

    void replacefiles() {
        File source = new File(String.valueOf(pTemp));
        File dest = new File(String.valueOf(pStudent));

        try {
            FileInputStream fis = new FileInputStream(source);

            FileOutputStream fos = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {

                fos.write(buffer, 0, length);
            }
        } catch (Exception e1) {
            System.out.println("Can't write student.txt file ");
        }
    }

    /**
     * Μέθοδος με την οποία διαγράφονται οι κενές γραμμές που πιθανόν να έχουν δημιουργηθεί
     * στο αρχείο καταγραφής
     */

    public static void  EmptyLines() throws FileNotFoundException {

        Scanner file;
        PrintWriter writer;
        file = new Scanner(new File(String.valueOf(pStudent)));
        writer = new PrintWriter(String.valueOf(pTemp));

        while (file.hasNext()) {
            String line = file.nextLine();
            if (!line.isEmpty()) {
                writer.write(line);
                writer.write("\n");
            }
        }

        file.close();
        writer.close();
    }

    /**
     * Μέθοδος με την οποία αντικαθίσταται το διαμορφωμένο αρχείο στο οποίο έχουν διαγραφεί
     * οι κενές γραμμές με το αρχικό αρχείο καταγραφής.
     */

    public static void ReverseFiles()
    {
        File source = new File(String.valueOf(pTemp));
        File dest = new File(String.valueOf(pStudent));

        try {
                FileInputStream fis = new FileInputStream(source);

                FileOutputStream fos = new FileOutputStream(dest);

                byte[] buffer = new byte[1024];
                int length;

                 while ((length = fis.read(buffer)) > 0)
                     {

                          fos.write(buffer, 0, length);

                     }
            }
                catch (Exception e)
                {
                    System.out.println("Reverse failure" );

                }
    }

}