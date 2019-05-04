package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.AppMediator;
import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;
import es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni.ContadorActivity;

public class contadorFinRouter implements contadorFinContract.Router {

    public static String TAG = contadorFinRouter.class.getSimpleName();

    private AppMediator mediator;

    public contadorFinRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ContadorActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(contadorFinState state) {
        mediator.setcontadorFinState(state);
    }

    @Override
    public contadorFinState getDataFromPreviousScreen() {
        contadorFinState state = mediator.getcontadorFinState();
        return state;
    }
}
