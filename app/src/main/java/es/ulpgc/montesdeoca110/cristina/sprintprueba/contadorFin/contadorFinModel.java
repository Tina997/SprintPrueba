package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;

public class contadorFinModel implements contadorFinContract.Model {

    public static String TAG = contadorFinModel.class.getSimpleName();

    private String cuenta;
    public contadorFinModel() {

    }


    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        this.cuenta = String.valueOf(0);
        return cuenta;
    }
}
