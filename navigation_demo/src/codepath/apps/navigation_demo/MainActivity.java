package codepath.apps.navigation_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static final String FOO_EXTRA = "foo";
	public static final String GOO_EXTRA = "goo";
	public static final String SETTINGS_EXTRA = "settings";
	public static final int REQUEST_CODE = 11;

	private Settings settings;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		settings = new Settings();
		settings.color = "red";
		settings.label = "blue";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		return true;
	}

	/** settings menu callback */
	public void onSettingsClick(MenuItem mi) {
		Toast.makeText(this, "Settings Launched", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(this, SecondActivity.class);
		i.putExtra(FOO_EXTRA, "bar");
		i.putExtra(GOO_EXTRA, "bar");
		i.putExtra(SETTINGS_EXTRA, settings);
		startActivityForResult(i, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			settings = (Settings) data.getSerializableExtra(SETTINGS_EXTRA);
			Toast.makeText(this, "Saved "+settings.color+", "+settings.label, Toast.LENGTH_SHORT).show();
		}
	}
}
