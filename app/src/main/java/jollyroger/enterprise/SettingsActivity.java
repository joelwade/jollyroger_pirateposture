package jollyroger.enterprise;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static jollyroger.enterprise.R.id.settings_toolbar;

/**
 * Created by Mark on 07/04/2016.
 */

public class SettingsActivity extends AppCompatActivity {
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(settings_toolbar);
        setSupportActionBar(toolbar);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.action_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                settingsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(settingsIntent);
                return true;

            case R.id.credits:
                Intent creditsIntent = new Intent(this, CreditsActivity.class);
                creditsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(creditsIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void ChangeToBlue(View view) {
        findViewById(R.id.settings_toolbar).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    public void ChangeToPink(View view) {
        findViewById(R.id.settings_toolbar).setBackgroundColor(getResources().getColor(R.color.my_pink));
    }

    public void ChangeToOrange(View view) {
        findViewById(R.id.settings_toolbar).setBackgroundColor(getResources().getColor(R.color.my_orange));
    }
}
