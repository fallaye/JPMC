package jpmc.virtusa.com.jpmc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class HomeActivity extends AppCompatActivity {
    Context context;
    Realm realm;
    ArrayList<Transaction> transactionArrayList;
    MyAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        RealmHelper helper = new RealmHelper(realm);
        helper.saveAll();
        transactionArrayList = helper.retrieve();

        adapter=new MyAdapter(this, transactionArrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("date", transactionArrayList.get(position).getmDate());
                        bundle.putString("desc", transactionArrayList.get(position).getmDesc());
                        bundle.putString("amount", transactionArrayList.get(position).getmAmount());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );

    }

    private void displayTransactions() {

    }

}
