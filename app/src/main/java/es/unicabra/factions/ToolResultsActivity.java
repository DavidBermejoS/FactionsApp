package es.unicabra.factions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.unicabra.factions.controllers.AdapterResultsScreen;
import es.unicabra.factions.pojos.values.Values;
import android.os.Bundle;

/**
 * <b>ToolResultsActivity</b>
 * This class contains the activity relative to the results screen.
 * @author David Bermejo Simón.
 */
public class ToolResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_results);
        Values resultValues = (Values) getIntent().getSerializableExtra("Values");
        RecyclerView recyclerView = findViewById(R.id.toolRecyclerView);
        AdapterResultsScreen adapter = new AdapterResultsScreen(resultValues);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
