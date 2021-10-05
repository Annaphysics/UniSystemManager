import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Η κλάση Tutor παριστά ένα καθηγητή στο σύστημα του φοιτητολογίου.Η κλάση κληρονομεί την κλαση {Person}.
 */

public class Tutor extends Person
{

    private String tutorId;
    private String specialty;
    public Tutor (String tutorId,String PersonName, String PersonSurname, String PersonEmail, String PersonContactno,String specialty)
    {
        super(PersonName, PersonSurname, PersonEmail, PersonContactno);
        this.tutorId=tutorId;
        this.specialty=specialty;
    }

    //Getters-Setters (not in use)
    public String gettutorId ()
    {
        return tutorId;
    }

    public void settutorId (String tutorId)
    {
        this.tutorId = tutorId;
    }

    public String getspecialty ()
    {
        return specialty;
    }

    public void setspecialty (String specialty)
    {
        this.specialty = specialty;
    }

    String info;

    /**
     *  Αρχείο καταγραφής των στοιχείων των Καθηγητών του Φοιτητολογίου
     */

    public static Path pTutor = Paths.get("C:\\Users\\Anna\\IdeaProjects\\UniSystemManager\\src\\tutor.txt");
    public static Path pTemp = Paths.get("C:\\Users\\Anna\\IdeaProjects\\UniSystemManager\\src\\tmp.txt");
    File tutorFile = new File(String.valueOf(pTutor));
    File temp = new File(String.valueOf(pTemp));

    Scanner input = new Scanner(System.in);
    Tutor(){}

    Tutor(String tutorName,String tutorSurname, String tutorId, String contactNum, String email, String specialty,String course){
        this.tutorId = tutorId;
        this.PersonName = tutorName;
        this.PersonSurname = tutorSurname;
        this.PersonContactno = contactNum;
        this.PersonEmail = email;
        this.specialty = specialty;
    }

     public void viewAllTutor(){

        try(Scanner in = new Scanner(tutorFile)){
            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String surname = in.next().trim();
                String cnum = in.next().trim();
                String mail = in.next().trim();
                String special = in.next().trim();
                String courses = in.nextLine();

                System.out.println("Tutor ID: " + id);
                System.out.println("Tutor Name: " + name);
                System.out.println("Tutor Surname: " + surname);
                System.out.println("Tutor Contact Number: " + cnum);
                System.out.println("Tutor Email Adrress: " + mail);
                System.out.println("Tutor Specialty: " + special);
                System.out.println("Tutor Courses: " + courses);
                System.out.println("\n");
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found!");
        }
    }
    /**
     * Μέθοδος που τροποποιεί την εγγραφή ενός καθηγητή  με κριτήριο τον κωδικό του που δίνεται ως είσοδος
     * αντλώντας την πληροφορία απευθείας από το αρχείο καταγραφής tutor.txt
     * Επίσης:
     * γίνεται έλεγχος για σωστή εισαγωγή του κωδικού καθώς και για την ύπαρξη του αρχείου και
     *  "άδειασμα" του προσωρινού αρχείου tmp από τις εγγραφές προκειμένου να χρησιμοποιηθεί σε άλλη διεργασία
     *  και εμφάνιση της τροποποιημένης εγγραφής
     */

    void modifyTutorInfo(){

        System.out.print("Enter Tutor ID to modify his/her Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(tutorFile);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String surname =  in.next().trim();
                String cnum = in.next().trim();
                String mail = in.next().trim();
                String special = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    System.out.println("Enter Tutor ID: ");
                    tutorId = input.nextLine();

                    System.out.println("Enter Tutor Name: ");
                    PersonName = input.nextLine();

                    System.out.println("Enter Tutor SurName: ");
                    PersonSurname = input.nextLine();

                    System.out.println("Enter Tutor Contact Number: ");
                    PersonContactno = input.nextLine();

                    System.out.println("Enter Tutor Email Address: ");
                    PersonEmail = input.nextLine();

                    System.out.println("Enter Tutor Specialty: ");
                    specialty = input.nextLine();

                    write.println(tutorId + " " +  PersonName + " " + PersonSurname + " " + PersonContactno + " " + PersonEmail + " " + specialty);
                    flag = 1;
                    System.out.println("Tutor Record Modification completed.");
                } else{
                    write.println(id + " " + name + " " + surname + " " + cnum + " " + mail + " " + special);
                }
            }

            if (flag == 0){
                System.out.println("The Tutor record of the entered ID isn't available.");
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }


        try {
            Scanner in = new Scanner(temp);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(tutorFile, false)));

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
     * Μέθοδος που διαγράφει έναν καθηγητη με κριτήριο τον κωδικό  του που δίνεται ως είσοδος
     *  απευθείας από το αρχείο καταγραφής tutor.txt
     *  Ταυτόχρονα γίνεται έλεγχος για σωστή εισαγωγή του κωδικού καθώς και για την ύπαρξη του αρχείου και
     *  "άδειασμα" του προσωρινού αρχείου tmp από τις εγγραφές προκειμένου να χρησιμοποιηθεί σε άλλη διεργασία.
     */

    void deleteTutor(){
        System.out.print("Enter Tutor ID to delete his/her Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(tutorFile);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String surname =  in.next().trim();
                String cnum = in.next().trim();
                String mail = in.next().trim();
                String special = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    flag = 1;
                    System.out.println("Tutor Deleted successfully.");
                } else{
                    write.println(id + " " + name + " " + surname  +" " + cnum + " " + mail + " " + special);
                }
            }

            if (flag == 0){
                System.out.println("The Tutor record of the entered ID isn't available.");
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }

        try {
            Scanner in = new Scanner(temp);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(tutorFile, false)));

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
     * Μέθοδος εισαγωγής στοιχείων ενός καθηγητή
     * Η εγγραφή γίνεται απευθείας στο αρχείο καταγραφής
     *
     */

    void createTutor(){

        System.out.println("Enter Tutor ID: ");
        tutorId = input.nextLine();

        System.out.println("Enter Tutor Name: ");
        PersonName = input.nextLine();

        System.out.println("Enter Tutor SurName: ");
        PersonSurname = input.nextLine();

        System.out.println("Enter Tutor Contact Number: ");
        PersonContactno = input.nextLine();

        System.out.println("Enter Tutor Email Address: ");
        PersonEmail = input.nextLine();

        System.out.println("Enter Tutor Specialty: ");
        specialty = input.nextLine();

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(tutorFile, true)))){
            out.println("\n"+ tutorId + " " +  PersonName + " " + PersonSurname + " " + PersonContactno + " " + PersonEmail + " " + specialty);
        } catch(IOException e){
            System.out.println("File Not Found!");
        }

        System.out.println("Tutor Record Created.");

    }

    /**
     * Μέθοδος ανάθεσης μαθήματος σε φοιτητή με βάση τον κωδικό του.
     * Γίνεται αναζήτηση στο αρχείο καταγραφής βάσει του κωδικού του,η εγγραφή καταχωρείται σε Arraylist στην οποία προστίθεται
     * το νέο μάθημα και στη συνέχεια επαναγράφεται στο αρχείο.
     *
     */

void addCourseToTutor() throws IOException {
    String splitBy = " ";

    BufferedReader bufReader = new BufferedReader(new FileReader(String.valueOf(pTutor)));

    ArrayList<String> listOfLines = new ArrayList<>();
    System.out.println("Input Tutor ID");
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
     * Μέθοδος ανάθεσης για το άδεισμα του προσωρινού αρχείου εγγραφών
     */

    static void erasetmp() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(String.valueOf(pTemp))) {
            writer.print(" ");

            //writer.close();
        }
    }

       /**
     * Μέθοδος που αντικαθιστά τη νέα εγγραφή στο προσωρινό αρχείο
     */

    static void replacefin(String stringToReplace, String replaceWith) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(String.valueOf(pTutor)));
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
     * δηλ του διαμορφωμένου tmp.txt στο tutor.txt
     */

     public static void replacefiles()  {
        File source = new File(String.valueOf(pTemp));
        File dest = new File(String.valueOf(pTutor));

        try {
            FileInputStream fis = new FileInputStream(source);

            FileOutputStream fos = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {

                fos.write(buffer, 0, length);

            }
        } catch (Exception e) {
            System.out.println("replace failure");

        }
    }

    /**
     * Μέθοδος με την οποία διαγράφονται οι κενές γραμμές που πιθανόν να έχουν δημιουργηθεί
     * στο αρχείο καταγραφής
     */

    public static void  EmptyLines() throws FileNotFoundException {

            Scanner file;
            PrintWriter writer;
            file = new Scanner(new File(String.valueOf(pTutor)));
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

        public static void ReverseFiles(){
            File source = new File(String.valueOf(pTemp));
            File dest = new File(String.valueOf(pTutor));

            try {
                FileInputStream fis = new FileInputStream(source);

                FileOutputStream fos = new FileOutputStream(dest);

                byte[] buffer = new byte[1024];
                int length;

                while ((length = fis.read(buffer)) > 0) {

                    fos.write(buffer, 0, length);

                }
            } catch (Exception e) {
                System.out.println("Reverse failure" );

            }
        }

    /**
     * Μέθοδος που αναζητά ένα  καθηγητή με κριτήριο τον κωδικό του ο οποίος δίνεται ως είσοδος
     * αντλώντας την πληροφορία απευθείας από το αρχείο καταγραφής tutor.txt
     * Ταυτόχρονα γίνεται έλεγχος για σωστή εισαγωγή του ΑΜ καθώς και για την ύπαρξη του αρχείου.
     */

    void viewTutorInfo(){

        System.out.print("Enter Tutor ID to view his/her Student Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(pTutor);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.next().trim();
                String surn = in.next().trim();
                String cnum = in.next().trim();
                String mail = in.next().trim();
                String special = in.next().trim();
                String courses = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    flag = 1;

                    System.out.println("Tutor ID: " + id);
                    System.out.println("Tutor  Name: " + name);
                    System.out.println("Tutor Surname: " + surn);
                    System.out.println("Tutor Contact Number: " + cnum);
                    System.out.println("Tutor Email Adrress: " + mail);
                    System.out.println("Tutor Specialty: " + special);
                    System.out.println("Tutor Courses: " + courses);
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
    }
