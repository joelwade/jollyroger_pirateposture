package database;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

/**
 * Created by p4068830 on 19/04/16.
 */

public class PatientActivity extends Activity {

    //I'm not even sure what this file is for?? Broken atm regardless.

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);  this gives error, fix.

        //get reference to handler
        DatabaseHandler db = new DatabaseHandler();

        //Log.db("Database: ", "Inserting values..");
        //db.addPatient(new Patient());

        log.d("Database: ", "Reading all contacts..");
        List<Patient> list = db.getAllPatients();
        for(Patient pt: list)
        {
            String log = "ID: " + pt.getPatientID()
                            + "FirstName: " + pt.getFirstName()
                            + "SurName: " + pt.getSurName()
                            + "DoB: " + pt.getDoB()
                            + "Gender: " + pt.getGender();
            Log.d("Database: ", log);
        }
    }
}
