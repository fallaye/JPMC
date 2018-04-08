package jpmc.virtusa.com.jpmc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fallaye on 4/7/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.TransactionViewHolder>{

    Context context;
    ArrayList<Transaction> transactionsList;

    public MyAdapter(Context context, ArrayList<Transaction> transactionsList){
        this.context = context;
        this.transactionsList = transactionsList;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.transaction_container, null);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        Transaction transaction = transactionsList.get(position);
        holder.tvDate.setText(transaction.getmDate());
        holder.tvDesc.setText(transaction.getmDesc());
        holder.tvAmount.setText(transaction.getmAmount());
    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder{
        TextView tvDate, tvDesc, tvAmount;

        public TransactionViewHolder(View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvAmount = itemView.findViewById(R.id.tvAmount);
        }
    }
}
