package es.ulpgc.montesdeoca110.cristina.sprintprueba;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class ContadorModel implements ContadorContract.Model {

    public static String TAG = ContadorModel.class.getSimpleName();

    private String cuenta;
    public ContadorModel(int cuenta) {
        this.cuenta = ""+cuenta;
    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return cuenta;
    }
}
