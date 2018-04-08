package jpmc.virtusa.com.jpmc;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by fallaye on 4/7/18.
 * Class responsible for all database operations
 */

public class RealmHelper {

    Realm realm;

    public RealmHelper(Realm realm){
        this.realm = realm;
    }

    public void save(final Transaction transaction)
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Transaction tr=realm.copyToRealm(transaction);
            }
        });
    }

    public void saveAll() {

        Transaction transaction1 =
                new Transaction("01/01/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction2 =
                new Transaction("01/20/2018", "DOLLAR TREE SMYRNA GA", "$30");
        Transaction transaction3 =
                new Transaction("2/01/2018", "COSTCO WHSE #0631", "$50");
        Transaction transaction4 =
                new Transaction("2/11/2018", "NETFLIX.COM", "$5");
        Transaction transaction5 =
                new Transaction("2/11/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction6 =
                new Transaction("3/01/2018", " PATXIS PIZZA", "$5");
        Transaction transaction7 =
                new Transaction("3/05/2018", "ALL STAR FAST FOOD", "$5");
        Transaction transaction8 =
                new Transaction("4/01/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction9 =
                new Transaction("4/02/2018", "HAAFIZ FOOD MART", "$5");
        Transaction transaction10 =
                new Transaction("4/02/2018", "UBER TRIP UZYBA ", "$5");

        save(transaction1); save(transaction2);
        save(transaction3); save(transaction4);
        save(transaction5); save(transaction6);
        save(transaction7); save(transaction8);
        save(transaction9); save(transaction10);
    }

    public ArrayList<Transaction> retrieve(){

        ArrayList<Transaction> arrayListTransactions =
                new ArrayList<>();
        RealmResults<Transaction> transactionRealmResults =
                realm.where(Transaction.class).findAll();

        for (Transaction transaction :
                transactionRealmResults) {
            arrayListTransactions.add(transaction);
        }
        return arrayListTransactions;
    }
}
