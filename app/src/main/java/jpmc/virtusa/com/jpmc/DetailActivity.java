package jpmc.virtusa.com.jpmc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    String mDate, mDesc, mAmount;
    Bundle bundle;
    TextView tvDate, tvDesc, tvAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDate = findViewById(R.id.tvDate);
        tvDesc = findViewById(R.id.tvDesc);
        tvAmount = findViewById(R.id.tvAmount);

        bundle = getIntent().getExtras();
        mDate = bundle.getString("date");
        mDesc = bundle.getString("desc");
        mAmount = bundle.getString("amount");

        tvDate.setText("DATE:          " + mDate);
        tvDesc.setText("DESCRIPTION:   " + mDesc);
        tvAmount.setText("AMOUNT:      " + mAmount);



    }
}
