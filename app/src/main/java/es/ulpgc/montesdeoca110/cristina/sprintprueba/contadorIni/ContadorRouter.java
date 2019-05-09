package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.AppMediator;
import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;
import es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin.contadorFinActivity;

public class ContadorRouter implements ContadorContract.Router {

    public static String TAG = ContadorRouter.class.getSimpleName();

    private AppMediator mediator;

    public ContadorRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, contadorFinActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(IniToFinState state, ContadorState contadorState) {
        mediator.setContadorState(contadorState);
        mediator.setIniToFinState(state);
    }

    @Override
    public ContadorState getDataFromPreviousScreen() {
        ContadorState state = mediator.getContadorState();
        return state;
    }
}
