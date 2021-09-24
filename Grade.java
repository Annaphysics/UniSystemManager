import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Η κλάση Grade παριστά την βαθμολογία σε ένα μάθημα του προγράμματος σπουδών ενός φοιτητή.
 * Στην κλάση περιέχονται και οι μέθοδοι επεξεργασίας των στοιχείων του φοιτητή
 */

public class Grade  {
     String Student_AM;
     String GrCourseId;
     Double Grade;

    Path pGrade = Paths.get("C:\\Users\\Anna\\IdeaProjects\\UniSystemManager\\src\\Grade.txt");
    Path pTemp = Paths.get("C:\\Users\\Anna\\IdeaProjects\\UniSystemManager\\src\\tmp.txt");
    File GradesFile = new File(String.valueOf(pGrade));
    File temp = new File(String.valueOf(pTemp));



    public String getStudent_AM() {
        return Student_AM;
    }

    public void setStudent_AM(String Student_AM) {
        this.Student_AM = Student_AM;
    }

    public String getGrCourseID() {
        return GrCourseId;
    }

    public void setGrCourseId(String GrCourseId) {
        this.GrCourseId = GrCourseId;
    }

    public double getGrade() {
        return Grade;
    }

    public void setGrade(double Grade) {
        this.Grade = Grade;
    }

    Scanner input = new Scanner(System.in);
    String info;

    Grade() {
        // Empty Constructor
    }

    public Grade(String Student_AM, String GrCourseId, Double Grade) {
        this.Student_AM = Student_AM;
        this.GrCourseId = GrCourseId;
        this.Grade = Grade;
    }

    /**
     * Μέθοδος που καταχωρεί τη βαθμολογία φοιτητή στο αρχείο grade.txt
     * Έλεγχος για την ύπαρξη του αρχείου
     */

    void createGrade() {

        System.out.print("Enter Student ID: ");
        Student_AM = input.nextLine();
        System.out.print("Enter Course ID: ");
        GrCourseId = input.nextLine();
        System.out.print("Enter Grade: ");
        Grade = input.nextDouble();

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(GradesFile, true)))) {
            out.println("\n"+ Student_AM + " " + GrCourseId + " " + Grade);
        } catch (IOException e) {
            System.out.println("File Not Found!");
        }

        System.out.println("Grade Created.");
    }

    /**
     * Μέθοδος εμφάνισης βαθμολογίας ανά φοιτητή και μάθημα από το αρχείο grade.txt
     * Έλεγχος για την ύπαρξη του αρχείου
     */

    void viewGrade() {
        System.out.println("STUDENT AM " + "|" + "  COURSE NAME " + "|" + "  GRADE");
        System.out.println("===========================================");
        try (Scanner in = new Scanner(GradesFile)) {
            while (in.hasNextLine()) {
                String am = in.next();
                String cname = in.next().trim();
                String grade = in.nextLine();

                System.out.println(am + " \t\t " + cname + " \t\t" + grade);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    }

    /**
     * Μέθοδος που υπολογίζει το μέσο όρο της βαθμολογίας φοιτητή με είσοδο του ΑΜ
     * Έλεγχος για την ύπαρξη του αρχείου
     * Έλεγχος για την ύπαρξη του ΑΜ
     */

    void averstudent() throws IOException {
        double i = 0;
        int j = 0;
        double sum = 0;
        double mo =0;
        String splitBy = " ";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(String.valueOf(pGrade)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Student ID\n");
        String tmpId = input.nextLine();
        System.out.println("Οι βαθμοί του φοιτητή με αριθμό μητρώου " + tmpId + "  είναι:");
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] b = line.split(splitBy);

            if (b[0].equals(tmpId)) {
                System.out.println(b[2]);
                i = Double.parseDouble(b[2]);
                sum = sum + i;
                j = j + 1;
                mo = (double) sum/j;
            }
        }
        System.out.println("O μέσος όρος των μαθημάτων του φοιτητή με  αριθμό μητρώου " + " " + tmpId + " είναι: " + mo);
        br.close();
    }

    /**
     * Μέθοδος που υπολογίζει το μέσο όρο της βαθμολογίας σε μάθημα  με είσοδο του κωδικού μαθήματος
     * Έλεγχος για την ύπαρξη του αρχείου
     * Έλεγχος για την ύπαρξη του ΑΜ
     */

    void avercourse() throws IOException {
        double i = 0;
        int j = 0;
        double sum = 0;
        double mo =0;
        String splitBy = " ";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(String.valueOf(pGrade)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course ID\n");
        String tmpId = input.nextLine();
        System.out.println("Ο μέσος όρος την βαθμολογίας του μαθήματος με κωδικό  " + tmpId + "  είναι:");
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] b = line.split(splitBy);
            if (b[1].equals(tmpId)) {
                System.out.println(b[2]);
                i = Double.parseDouble(b[2]);
                sum = sum + i;
                j = j + 1;
                mo = (double) sum/j;
            }
        }
        System.out.println("O μέσος όρος του μαθήματος με κωδικό  " + " " + tmpId + " είναι: " +mo);
        br.close();
    }
}

