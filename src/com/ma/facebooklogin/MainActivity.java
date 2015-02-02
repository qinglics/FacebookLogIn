package com.ma.facebooklogin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.AppEventsLogger;


public class MainActivity extends FragmentActivity {

  private Fragment mainFragment = null;

  @Override
  protected void onPause() {
    super.onPause();

    // Logs 'app deactivate' App Event.
    AppEventsLogger.deactivateApp(this);
  }


  @Override
  protected void onResume() {
    super.onResume();

    // Logs 'install' and 'app activate' App Events.
    AppEventsLogger.activateApp(this);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState == null) {
      // Add the fragment on initial activity setup
      mainFragment = new MainFragment();
      getSupportFragmentManager().beginTransaction().add(android.R.id.content, mainFragment)
          .commit();
    } else {
      // Or set the fragment from restored state info
      mainFragment =
          (MainFragment) getSupportFragmentManager().findFragmentById(android.R.id.content);
    }
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
