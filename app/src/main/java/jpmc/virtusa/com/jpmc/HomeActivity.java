package jpmc.virtusa.com.jpmc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.transitionseverywhere.ArcMotion;
import com.transitionseverywhere.Explode;
import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.extra.Scale;

import java.util.ArrayList;

import io.realm.Realm;

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
                        overridePendingTransition(R.anim.rotate_out,R.anim.rotate_in);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );

        final ViewGroup transitionsContainer = (ViewGroup) findViewById(R.id.transitions_container);
        final TextView text = (TextView) transitionsContainer.findViewById(R.id.text);
        final Button button = (Button) transitionsContainer.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            boolean visible;

            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                text.setVisibility(visible ? View.VISIBLE : View.GONE);


            }

        });

    }

    private void displayTransactions() {

    }

}
