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


    public ArrayList<Transaction> retrieve(){

        ArrayList<Transaction> arrayListTransactions =
                new ArrayList<>();
        /*RealmResults<Transaction> transactionRealmResults =
                realm.where(Transaction.class).findAll();

        for (Transaction transaction :
                transactionRealmResults) {


            arrayListTransactions.add(transaction);
        }
*/
        Transaction transaction1 =
                new Transaction("01/01/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction2 =
                new Transaction("01/20/2018", "DOLLAR TREE SMYRNA GA", "$30");
        Transaction transaction3 =
                new Transaction("2/01/2018", "COSTCO WHSE #0631 ATLANTA GA ", "$50");
        Transaction transaction4 =
                new Transaction("2/11/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction5 =
                new Transaction("2/11/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction6 =
                new Transaction("3/01/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction7 =
                new Transaction("3/05/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction8 =
                new Transaction("4/01/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction9 =
                new Transaction("4/02/2018", "WAFLE HOUSE ATLANTA GA", "$5");
        Transaction transaction10 =
                new Transaction("4/02/2018", "WAFLE HOUSE ATLANTA GA", "$5");

        arrayListTransactions.add(transaction1);
        arrayListTransactions.add(transaction2);
        arrayListTransactions.add(transaction4);
        arrayListTransactions.add(transaction5);
        arrayListTransactions.add(transaction6);
        arrayListTransactions.add(transaction7);
        arrayListTransactions.add(transaction8);
        arrayListTransactions.add(transaction9);
        arrayListTransactions.add(transaction10);

        return arrayListTransactions;
    }



}
