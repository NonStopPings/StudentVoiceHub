package com.demin.studentvoicehub05;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import static com.google.firebase.storage.FirebaseStorage.getInstance;

public class BuyAndSellForStudent extends AppCompatActivity {

    LinearLayoutManager mLayoutManager;
    SharedPreferences mSharedPref;
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    FirebaseRecyclerAdapter<Model_BuyAndSell,ViewHolder_BuyAndSell> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Model_BuyAndSell> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_and_sell_for_student);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Buy n Sell");

        mSharedPref = getSharedPreferences("SortSettings",MODE_PRIVATE);
        String mSorting = mSharedPref.getString("Sort","newest");
        if(mSorting.equals("newest")){
            mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setReverseLayout(true);
            mLayoutManager.setStackFromEnd(true);
        }else if(mSorting.equals("oldest")){
            mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setReverseLayout(false);
            mLayoutManager.setStackFromEnd(false);
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Buy And Sell Data");
        showData();
    }


    private void showData(){
        options = new FirebaseRecyclerOptions.Builder<Model_BuyAndSell>().setQuery(mRef,Model_BuyAndSell.class).build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model_BuyAndSell, ViewHolder_BuyAndSell>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder_BuyAndSell holder_buyAndSell, int position, @NonNull Model_BuyAndSell model_buyAndSell) {
                holder_buyAndSell.setDetails(getApplicationContext(),model_buyAndSell.getTitle(),model_buyAndSell.getDescription(),model_buyAndSell.getImage()
                        ,model_buyAndSell.getEmail(),model_buyAndSell.getPrice(),model_buyAndSell.getCampus());
            }

            @NonNull
            @Override
            public ViewHolder_BuyAndSell onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
                View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_buy_and_sell,viewGroup, false);
                ViewHolder_BuyAndSell viewHolder_buyAndSell = new ViewHolder_BuyAndSell(itemView);
                viewHolder_buyAndSell.setOnClickListener(new ViewHolder_BuyAndSell.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String mTitle = getItem(position).getTitle();
                        String mDesc = getItem(position).getDescription();
                        String mEmail = getItem(position).getEmail();
                        String mPrice = getItem(position).getPrice();
                        String mCampus = getItem(position).getCampus();
                        String mImage = getItem(position).getImage();

                        Intent intent = new Intent(view.getContext(), PostBuyAndSell.class);
                        intent.putExtra("title",mTitle);
                        intent.putExtra("description",mDesc);
                        intent.putExtra("email",mEmail);
                        intent.putExtra("price",mPrice);
                        intent.putExtra("campus",mCampus);
                        intent.putExtra("image",mImage);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                    }
                });
                return viewHolder_buyAndSell;
            }
        };
        mRecyclerView.setLayoutManager(mLayoutManager);
        firebaseRecyclerAdapter.startListening();
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    private void firebaseSearch(String searchText){

        String query = searchText.toLowerCase();

        Query firebaseSearchQuery = mRef.orderByChild("search").startAt(query).endAt(query + "\uf8ff");

        options = new FirebaseRecyclerOptions.Builder<Model_BuyAndSell>().setQuery(firebaseSearchQuery,Model_BuyAndSell.class).build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model_BuyAndSell, ViewHolder_BuyAndSell>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder_BuyAndSell holder_buyAndSell, int position, @NonNull Model_BuyAndSell model_buyAndSell) {
                holder_buyAndSell.setDetails(getApplicationContext(),model_buyAndSell.getTitle(),model_buyAndSell.getDescription(),model_buyAndSell.getImage()
                        ,model_buyAndSell.getEmail(),model_buyAndSell.getPrice(),model_buyAndSell.getCampus());
            }

            @NonNull
            @Override
            public ViewHolder_BuyAndSell onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_buy_and_sell,viewGroup, false);
                ViewHolder_BuyAndSell viewHolder_buyAndSell = new ViewHolder_BuyAndSell(itemView);
                viewHolder_buyAndSell.setOnClickListener(new ViewHolder_BuyAndSell.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String mTitle = getItem(position).getTitle();
                        String mDesc = getItem(position).getDescription();
                        String mEmail = getItem(position).getEmail();
                        String mPrice = getItem(position).getPrice();
                        String mCampus = getItem(position).getCampus();
                        String mImage = getItem(position).getImage();

                        Intent intent = new Intent(view.getContext(), PostBuyAndSell.class);
                        intent.putExtra("title",mTitle);
                        intent.putExtra("description",mDesc);
                        intent.putExtra("email",mEmail);
                        intent.putExtra("price",mPrice);
                        intent.putExtra("campus",mCampus);
                        intent.putExtra("image",mImage);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                    }
                });
                return viewHolder_buyAndSell;
            }
        };
        mRecyclerView.setLayoutManager(mLayoutManager);
        firebaseRecyclerAdapter.startListening();
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseRecyclerAdapter != null){
            firebaseRecyclerAdapter.startListening();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override                       /*(String s)*/
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                return false;
            }

            @Override                        /*(String s)*/
            public boolean onQueryTextChange(String newText) {
                firebaseSearch(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_sort){
            showSortDialog();
            return true;
        }

        if(id == R.id.action_add){
            startActivity(new Intent(BuyAndSellForStudent.this,AddPostBuyAndSell.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showSortDialog() {

        String[] sortOptions = {"Newest","Oldest"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sort by")
                .setIcon(R.drawable.ic_action_sort)
                .setItems(sortOptions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0){
                            SharedPreferences.Editor editor = mSharedPref.edit();
                            editor.putString("Sort","newest");
                            editor.apply();
                            recreate();
                        }else if(which == 1){
                            SharedPreferences.Editor editor = mSharedPref.edit();
                            editor.putString("Sort","oldest");
                            editor.apply();
                            recreate();
                        }
                    }
                });
        builder.show();
    }
}
