package database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p4068830 on 19/04/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    //Database Name
    private static final String Database_Posturedb = "Posture.db";

    //Patients table name
    private static final String Table_Patients = "Patients";

    //Appointments table name
    private static final String Table_Appointments = "Appointment";

    // Patients Table Columns names
    private static final String PT_ID = "_id";
    private static final String PT_FIRSTNAME = "FirstName";
    private static final String PT_SURNAME = "Surname";
    private static final String PT_DOB = "DoB";
    private static final String PT_GENDER = "Gender";

    //
    private static final String AP_ID = "_id";
    private static final String AP_PATIENTID = "PatientID";
    private static final String AP_APPOINTMENTNO = "AppointmentNo";
    private static final String AP_APPOINTMENTDATE = "AppointmentDate";
    private static final String AP_PATIENTIMAGE = "PatientImage";
    private static final String AP_DIAGNOSTIC = "Diagnostic";

    public DatabaseHandler(context context)
    {
        super(context, Database_Posturedb, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_PATIENTS_TABLE = "CREATE TABLE "
            + Table_Patients
            + "(" PT_ID
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PT_FIRSTNAME
            + " TEXT NOT NULL, "
            + PT_SURNAME
            + " TEXT NOT NULL, "
            + PT_DOB
            + " TEXT NOT NULL, "
            + PT_GENDER
            + " TEXT NOT NULL, " + ") ";

        String CREATE_APPOINTMENTS_TABLE = "CREATE TABLE "
            + Table_Appointments
            + "(" AP_ID
            + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + AP_PATIENTID
            + " TEXT NOT NULL , "
            + AP_APPOINTMENTNO
            + " TEXT NOT NULL , "
            + AP_APPOINTMENTDATE
            + " TEXT NOT NULL , "
            + AP_PATIENTIMAGE
            + " TEXT NOT NULL , "
            + AP_DIAGNOSTIC
            + " TEXT NOT NULL, "
            + " FOREIGN KEY ("+AP_PATIENTID+") REFERENCES " + Table_Patients + "("+PatientID+"));";
        db.execSQL(CREATE_PATIENTS_TABLE);
        db.execSQL(CREATE_APPOINTMENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldNum, int newNum)
    {
        //Drop older table if exists and create fresh
        db.execSQL("Drop table if exists " + Table_Patients);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Appointments);
        onCreate(db);
    }

    void addPatient(Patients patients)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PT_ID, patients.getPatientsID());
        values.put(PT_FIRSTNAME, patients.getFirstName());
        values.put(PT_SURNAME, patients.getSurName());
        values.put(PT_DOB, patients.getDoB());
        values.put(PT_GENDER, patients.getGender());
        db.insert(Table_Patients, null, values);
        db.close(); //closing database connection
    }

    void addAppointment(Appointment appointment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AP_ID, appointment.getAppointmentID());
        values.put(AP_PATIENTID, appointment.getPatientID());
        values.put(AP_APPOINTMENTNO, appointment.getAppointmentNo());
        values.put(AP_APPOINTMENTDATE, appointment.getAppointmentDate());
        values.put(AP_PATIENTIMAGE, appointment.getPatientImage());
        values.put(AP_DIAGNOSTIC, appointment.getDiagnostic());
        db.insert(Table_Appointments, null, values);
        db.close();
    }

    public void removeAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + Table_Patients);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Appointments);
        onCreate(db);
    }

    public List<Patients> getAll()
    {
        List<Patients> list = new ArrayList<Patients>();
        String selectQuery = "SELECT * FROM " + Table_Patients; //* means everything
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                Patients patients = new Patients(cursor.getString(1), cursor.getString(2));
                list.add(patients);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public List<Appointment> getAll()
    {
        List<Appointment> list = new ArrayList<Appointment>();
        String selectQuery = "SELECT * FROM " + Table_Appointments;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                Appointment appointment = new Appointment(cursor.getString(1), cursor.getString(2));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
