package com.example.chie.notifitest0429;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by chie on 2017/04/29.
 */

public class MyFirebaseInstanceIdservice extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseIdservice";
    private String token;
    private String uid = "EXAMPLE";

    @Override
    public void onTokenRefresh() {
        token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "RefreshedToken = " + token);

        //トークンの値をサーバーへ送信
        submit(token);
    }

    private void submit(String token) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Log.d(TAG, "getInstance");
        DatabaseReference refToken = database.getReference("/fcmTokens");
        Log.d(TAG, "getReference");
        refToken.child(token).setValue(uid);
        //refToken.setValue("HashMap");
        Log.d(TAG, "setValue");


        //database.getReference("/fcmTokens").child(token).setValue(uid);


    }

}
