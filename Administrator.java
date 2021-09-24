import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrator {
    String adname = "Anna";
    String adsurname = "Manolaki";
    String password = "a1234";

    Student student = new Student();
    Tutor tutor = new Tutor();
    Course course = new Course();
    Grade grade = new Grade();

    Scanner input = new Scanner(System.in);

    Administrator(){}

    /**
     *Το μενού της εφαρμογής
     *Έλεγχοι που πραγματοποιούνται:
     *    έλεγχος για εισαγωγή αριθμού εκτός επιλογών μενού
     *    έλεγχος για εισαγωγή οποιουδήποτε άλλου συνδυασμού ψηφίων εκτός αριθμού(int)
     */

    public void menu() {

        while (true) {
            System.out.println("========================================================\n");
            System.out.println("Welcome to Main Menu!\n");
            System.out.println("Please Select a choice from the following: \n");
            System.out.println("========================================================");
            System.out.println("Press 1 to View all Student Info");
            System.out.println("Press 2 to View all Tutor Info");
            System.out.println("Press 3 to View all Courses Info ");
            System.out.println("Press 4 for Tutor Management");
            System.out.println("Press 5 for Student Management");
            System.out.println("Press 6 for Course Management");
            System.out.println("Press 7 for Grade Management");
            System.out.println("Press 8 to Sign Out");
            System.out.println("========================================================");
            try {
                int choice = input.nextInt();
                if (choice == 1) {
                    viewStudent();
                    Pause();
                } else if (choice == 2) {
                    viewTutor();
                    Pause();
                } else if (choice == 3) {
                    viewCourse();
                    Pause();
                } else if (choice == 4) {
                    manageTutorInfo();
                    Pause();
                } else if (choice == 5) {
                    manageStudent();
                    Pause();
                } else if (choice == 6) {
                    manageCourse();
                    Pause();
                } else if (choice == 7) {
                    manageGrades();
                    Pause();
                } else if (choice == 8) {

                    System.out.println("Signing Out!\n\n");
                    break;

                } else {
                    System.out.println("You entered wrong input. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("You entered wrong input. Please try again.");

            }

        }
    }

    public void viewStudent ()
    {
        student.viewAllStudent();
    }
    public void viewTutor() {  tutor.viewAllTutor(); }
    public void viewCourse() { course.viewCourse();}

    /**
     *@manageTutorInfo Το υπομενού της εφαρμογής που διαχειρίζεται τις εγγραφές των Καθηγητών
     *Έλεγχοι που πραγματοποιούνται:
     *    έλεγχος για εισαγωγή αριθμού εκτός επιλογών μενού
     *    έλεγχος για εισαγωγή οποιουδήποτε άλλου συνδυασμού ψηφίων εκτός αριθμού(int)
     */

    public void manageTutorInfo() {
        while (true) {
            System.out.println("=========================================\n");
            System.out.println("Welcome to Tutor Management\n");
            System.out.println("=========================================\n");
            System.out.println("Press 1 to create a Tutor Info");
            System.out.println("Press 2 to modify a Tutor Info");
            System.out.println("Press 3 to delete a Tutor");
            System.out.println("Press 4 to add a course to a Tutor");
            System.out.println("Press 5 to View  Tutor Info");
            System.out.println("Press 6 to return to Main Menu");
            System.out.println("=========================================\n");

            try {
                int choice = input.nextInt();

                if (choice == 1) {
                    tutor.createTutor();
                    Pause();
                } else if (choice == 2) {
                    tutor.modifyTutorInfo();
                    Pause();
                } else if (choice == 3) {
                    tutor.deleteTutor();
                    Pause();
                } else if (choice == 4) {
                    tutor.addCourseToTutor();
                    Pause();
                } else if (choice == 5) {
                    tutor.viewTutorInfo();
                    Pause();
                } else if (choice == 6) {
                    break;
                } else {
                    System.out.println("You entered wrong input. Please try again.");
                }

            } catch (InputMismatchException | IOException e) {
                System.out.println("You entered wrong input. Please try again.");
                manageTutorInfo();
            }
        }
    }

    /**
     *@manageStudent Το υπομενού της εφαρμογής που διαχειρίζεται τις εγγραφές των Φοιτητών
     *Έλεγχοι που πραγματοποιούνται:
     *    έλεγχος για εισαγωγή αριθμού εκτός επιλογών μενού
     *    έλεγχος για εισαγωγή οποιουδήποτε άλλου συνδυασμού ψηφίων εκτός αριθμού(int)
     */

    public void manageStudent() {
        while (true) {
            System.out.println("=========================================\n");
            System.out.println("Student Management Menu\n");
            System.out.println("=========================================\n");
            System.out.println("Press 1 to create a Student Info");
            System.out.println("Press 2 to modify a Student Info");
            System.out.println("Press 3 to delete a Student Info");
            System.out.println("Press 4 to view a Student Info");
            System.out.println("Press 5 to view all Students Info");
            System.out.println("Press 6 to add a course to a Student");
            System.out.println("Press 7 to return to Main Menu");
            System.out.println("=========================================\n");
            try {
                int choice = input.nextInt();

                if (choice == 1) {
                    student.createStudent();
                    Pause ();
                } else if (choice == 2) {
                    student.modifyStudentInfo();
                    Pause ();
                } else if (choice == 3) {
                    student.deleteStudentInfo();
                    Pause ();
                } else if (choice == 4) {
                    student.viewStudentInfo();
                    Pause ();
                } else if (choice == 5) {
                    student.viewAllStudent();
                    Pause ();
                } else if (choice == 6) {
                    student.addCourseToStudent();
                    Pause ();

                } else if (choice == 7) {
                    break;
                } else {
                    System.out.println("You entered wrong input. Please try again.");
                }

            } catch (InputMismatchException | IOException e) {
                System.out.println("You entered wrong input. Please try again.");
                manageStudent();
            }
        }
    }

    /**
     *@manageCourse Το υπομενού της εφαρμογής που διαχειρίζεται τις εγγραφές των Μαθημάτων
     *Έλεγχοι που πραγματοποιούνται:
     *    έλεγχος για εισαγωγή αριθμού εκτός επιλογών μενού
     *    έλεγχος για εισαγωγή οποιουδήποτε άλλου συνδυασμού ψηφίων εκτός αριθμού(int)
     */

    public void manageCourse() {
        while (true) {
            System.out.println("=========================================\n");
            System.out.println("Welcome to Course Management\n");
            System.out.println("=========================================\n");
            System.out.println("Press 1 to create a course");
            System.out.println("Press 2 to modify a course");
            System.out.println("Press 3 to delete a course");
            System.out.println("Press 4 to return to Main Menu");
            System.out.println("=========================================\n");
            try {
                int choice = input.nextInt();

                if (choice == 1) {
                    course.createCourse();
                    Pause ();
                } else if (choice == 2) {
                    course.modifyCourse();
                    Pause ();
                } else if (choice == 3) {
                    Pause ();
                    course.deleteCourse();
                } else if (choice == 4) {
                    break;

                } else {
                    System.out.println("You entered wrong input. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("You entered wrong input. Please try again.");
                manageCourse();
            }
        }
    }

    /**
     *Το @manageGrades() υπομενού της εφαρμογής που διαχειρίζεται τους βαθμούς των Φοιτητών και τα βαθμολογικά στατιστικά στοιχεία
     * με βάση τον αριθμό μητρώου του φοιτητή και τον κωδικό μαθήματος.
     *Έλεγχοι που πραγματοποιούνται:
     *    έλεγχος για εισαγωγή αριθμού εκτός επιλογών μενού
     *    έλεγχος για εισαγωγή οποιουδήποτε άλλου συνδυασμού ψηφίων εκτός αριθμού(int)
     */

    public void manageGrades() {
        while (true) {
            System.out.println("=========================================\n");
            System.out.println("Welcome to Grades Management\n");
            System.out.println("=========================================\n");
            System.out.println("Press 1 to insert Student grade");
            System.out.println("Press 2 to view all Student grades");
            System.out.println("Press 3 to view average Student grades");
            System.out.println("Press 4 to view average Course grades");
            System.out.println("Press 5 to return to Main Menu");
            System.out.println("=========================================\n");
            // Να προσθέσω την επιλογή για διαγραφή και να αφαιρέσω το rename
            try {
                int choice = input.nextInt();

                if (choice == 1) {
                    grade.createGrade();
                    Pause();
                }  else if (choice == 2) {
                    grade.viewGrade();
                    Pause();
                } else if (choice == 3) {
                    grade.averstudent();
                    Pause();
                } else if (choice == 4) {
                    grade.avercourse();
                    Pause();
                } else if (choice == 5) {

                    break;

                } else {
                    System.out.println("You entered wrong input. Please try again.");
                }

            } catch (InputMismatchException | IOException e) {
                System.out.println("You entered wrong input. Please try again.");
                manageGrades();
            }
        }
    }

    /**
     *Μέθοδος παύσης της εκτέλεσης του προγράμματος μέχρι να πατηθεί Enter
     */

    public void Pause () {
        Scanner P = new Scanner(System.in);
        System.out.println("");
        System.out.printf("Press ENTER to continue.");
        P.nextLine ();
        System.out.println ("");
    }
}
