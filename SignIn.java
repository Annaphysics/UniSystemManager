import java.util.Scanner;

/**
 *Μενού εισαγωγής στοιχείων ταυτοποίησης του Administrator.
 * Έλεγχος των στοιχείων ταυτοποίησης.
 */

public class SignIn
{
    Scanner input = new Scanner(System.in);
    Administrator admin = new Administrator();

    SignIn()
    {
        CheckUp();
    }

    void CheckUp()
    {
        System.out.println("========================================================");
        System.out.println("WELCOME TO UNIVERSITY MANAGEMENT SYSTEM");
        System.out.println("========================================================");
        System.out.println("Press ENTER to continue......");
        input.nextLine();

        boolean flag = true;
        //ABC:
        while (flag)
        {
            System.out.println("Please SignIn to continue!\n");
            System.out.println("Enter Admin Name");
            String adname = input.nextLine();
            System.out.println("Enter Admin SurName");
            String adsurname = input.nextLine();
            System.out.println("Enter Password");
            String password = input.nextLine();


            if (admin.adname.equalsIgnoreCase(adname) && admin.adsurname.equalsIgnoreCase(adsurname) && admin.password.equals(password))
            {
                admin.menu();
                flag = false;

                System.out.println("PROJECT: UNIVERSITY MANAGEMENT SYSTEM");
                System.out.println("AUTHOR: ANNA MANOLAKI");
            }
            else
            {
                System.out.println("Invalid Details or Password.");
                System.out.println("Please Try Again");
            }
        }
    }
}