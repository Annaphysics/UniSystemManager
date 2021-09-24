import java.util.ArrayList;
/**
 *Η κλάση Person παριστά ένα άτομο και περιλαμβάνει τα κοινά στοιχεία φοιτητών και καθηγητών τα οποία κληρονομούνται από τις αντίστοιχες κλάσεις
 *
 */

public class Person
{
    protected String PersonName;
    protected String PersonSurname;
    protected String PersonEmail;
    protected String PersonContactno;
    protected ArrayList <Course> Courses;



    public Person(String PersonName, String PersonSurname, String PersonEmail, String PersonContactno)
    {
        this.PersonName = PersonName;
        this.PersonSurname = PersonSurname;
        this.PersonEmail = PersonEmail;
        this.PersonContactno = PersonContactno;
        Courses = new ArrayList();
    }
    public Person() {
    }
    //getters & setters
    public String getPersonName ()
    {
        return PersonName;
    }

    public void setPersonName (String PersonName)
    {
        this.PersonName = PersonName;
    }

    public String getPersonSurname ()
    {
        return PersonSurname;
    }

    public void setPersonSurname (String PersonSurname)
    {
        this.PersonSurname= PersonSurname;
    }

    public String getPersonEmail ()
    {
        return PersonEmail;
    }

    public void setPersonEmail (String Email)
    {
        this.PersonEmail = Email;
    }

    public String getPersonContactno ()
    {
        return PersonContactno;
    }

    public void setPersonContactno (String Phone)
    {
        this.PersonContactno = Phone;
    }


    public ArrayList<Course> getCourses ()
    {
        return Courses;
    }

    public void setCourses(ArrayList<Course>Courses)
    {
        this.Courses =Courses;
    }

}