package no.fript.fript.onboarding.gymtype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import no.fript.fript.R;

public final class GymTypeActivity extends AppCompatActivity {

    private ArrayAdapter<String> gymTypePreferences;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gym_type);
        initializeListView();
    }

    private void initializeListView() {
        final ListView listView = (ListView) findViewById(R.id.gym_type_list_view);
        gymTypePreferences = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(gymTypePreferences);
        gymTypePreferences.add("foo");
        gymTypePreferences.add("foo");
        gymTypePreferences.add("foo");
    }
}
