package database;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

/**
 * Created by p4068830 on 19/04/16.
 */
public class PatientActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //get reference to handler
        DatabaseHandler db = new DatabaseHandler(this);

        //Log.db("Database: ", "Inserting values..");
        //db.addPatient(new patients());

        log.d("Database: ", "Reading all contacts..");
        List<patients> list = db.getAll();
        for(patients pt: list)
        {
            String log = "ID: " + pt.getPatientsID()
                            + "FirstName: " + pt.getFirstName()
                            + "SurName: " + pt.getSurName()
                            + "DoB: " + pt.getDoB()
                            + "Gender: " + pt.getGender()
            Log.d("Database: ", log);
        }
    }
}
