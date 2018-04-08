package jpmc.virtusa.com.jpmc;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by fallaye on 4/7/18.
 */

public class Transaction extends RealmObject {

    @Required
    private String mDate, mDesc, mAmount;

    public Transaction() {
    }

    public Transaction(String mDate, String mDesc, String mAmount) {
        this.mDate = mDate;
        this.mDesc = mDesc;
        this.mAmount = mAmount;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmDesc() {
        return mDesc;
    }

    public String getmAmount() {
        return mAmount;
    }
}
