package database;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import jollyroger.enterprise.R;

/**
 * Created by p4068830 on 27/04/16.
 */
public class AppointmentActivity
{
    //@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //get reference to handler
        DatabaseHandler db = new DatabaseHandler(this);

        //Log.db("Database: ", "Inserting values..");
        //db.addPatient(new Patient());

        log.d("Database: ", "Reading all contacts..");
        List<Appointment> list = db.getAllApointments();
        for(Appointment ap: list)
        {
            String log = "ID: " + ap.getAppointmentID()
                    + "PatientID: " + ap.getPatientID()
                    + "AppointmentNo: " + ap.getAppointmentNo()
                    + "AppointmentDate: " + ap.getAppointmentDate()
                    + "PatientImage: " + ap.getPatientImage()
                    + "Diagnostic: " + ap.getDiagnostic();
            Log.d("Database: ", log);
        }
    }
}
