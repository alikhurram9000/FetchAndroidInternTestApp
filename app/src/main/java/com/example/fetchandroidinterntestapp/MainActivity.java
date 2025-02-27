package com.example.fetchandroidinterntestapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fetchandroidinterntestapp.adapters.GroupAdapter;
import com.example.fetchandroidinterntestapp.models.Group;
import com.example.fetchandroidinterntestapp.models.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog;
import dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface;

public class MainActivity extends AppCompatActivity {

    private final String API_URL = "https://fetch-hiring.s3.amazonaws.com/hiring.json";
    private final List<Group> groupList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GroupAdapter groupAdapter;
    private RequestQueue requestQueue;
    private Button fetchButton;
    private FloatingActionButton surpriseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.itemsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        groupAdapter = new GroupAdapter(this, groupList);
        recyclerView.setAdapter(groupAdapter);

        fetchButton = findViewById(R.id.fetch_button);
        surpriseButton = findViewById(R.id.surprise_button);


        requestQueue = Volley.newRequestQueue(this);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });

        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetMaterialDialog mBottomSheetDialog = new BottomSheetMaterialDialog.Builder(MainActivity.this)
                        .setTitle("Thank you for the opportunity!")
                        .setMessage("Hope I move forward to the next round!")
                        .setAnimation(R.raw.heart_anim)
                        .setCancelable(true)
                        .setPositiveButton("Close", new BottomSheetMaterialDialog.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .build();
                mBottomSheetDialog.show();
            }
        });
    }

    private void fetchData() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                API_URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Item> items = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                int listId = jsonObject.getInt("listId");
                                String name = jsonObject.optString("name", "").trim();
                                if (!name.isEmpty() && !name.equalsIgnoreCase("null")) {
                                    items.add(new Item(id, name, listId));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Map<Integer, List<Item>> groupedMap = new HashMap<>();
                        for (Item item : items) {
                            int listId = item.getListId();
                            if (!groupedMap.containsKey(listId)) {
                                groupedMap.put(listId, new ArrayList<Item>());
                            }
                            groupedMap.get(listId).add(item);
                        }

                        List<Integer> keys = new ArrayList<>(groupedMap.keySet());
                        Collections.sort(keys);

                        List<Group> groups = new ArrayList<>();
                        for (Integer key : keys) {
                            List<Item> groupItems = groupedMap.get(key);
                            groupItems.sort(new Comparator<Item>() {
                                @Override
                                public int compare(Item o1, Item o2) {
                                    return Integer.compare(o1.getId(), o2.getId());
                                }
                            });
                            groups.add(new Group(key, groupItems));
                        }

                        groupList.clear();
                        groupList.addAll(groups);
                        groupAdapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "API call failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);
    }
}
