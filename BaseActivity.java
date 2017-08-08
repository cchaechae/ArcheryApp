package cryjin.archeryapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by chaelimseo on 8/6/17.
 */

public class BaseActivity extends AppCompatActivity{


    private ProgressDialog progressDialog;

    public void showProgressDialog(){
        if(progressDialog==null){
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Wait for it .....");
        }
        progressDialog.show();
    }


    public void hideProgressDialog(){
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.hide();
        }
    }

    public String getUid(){
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

}
