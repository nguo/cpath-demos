package codepath.apps.navigation_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {
	private TextView tvFoo;
	private TextView tvGoo;
	private EditText etColor;
	private EditText etLabel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		tvFoo = (TextView) findViewById(R.id.tvFoo);
		tvGoo = (TextView) findViewById(R.id.tvGoo);
		etColor = (EditText) findViewById(R.id.etColor);
		etLabel = (EditText) findViewById(R.id.etLabel);

		tvFoo.setText(getIntent().getStringExtra(MainActivity.FOO_EXTRA));
		tvGoo.setText(getIntent().getStringExtra(MainActivity.GOO_EXTRA));
		Settings settings = (Settings) getIntent().getSerializableExtra(MainActivity.SETTINGS_EXTRA);
		etColor.setText(settings.color);
		etLabel.setText(settings.label);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	/** callback for save menu button */
	public void onSaveItems(MenuItem mi) {
		Settings settings = new Settings();
		settings.color = etColor.getText().toString();
		settings.label = etLabel.getText().toString();
		Intent data = new Intent();
		data.putExtra(MainActivity.FOO_EXTRA, tvFoo.getText().toString());
		data.putExtra(MainActivity.GOO_EXTRA, tvGoo.getText().toString());
		data.putExtra(MainActivity.SETTINGS_EXTRA, settings);
		setResult(RESULT_OK, data);
		finish();
	}
}