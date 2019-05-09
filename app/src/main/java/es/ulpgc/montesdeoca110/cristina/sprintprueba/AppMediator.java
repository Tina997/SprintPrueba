package es.ulpgc.montesdeoca110.cristina.sprintprueba;

import android.app.Application;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin.contadorFinState;
import es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni.ContadorState;

public class AppMediator extends Application {
    private ContadorState contadorState;
    private contadorFinState contadorFinState;
    private IniToFinState iniToFinState;
    @Override
    public void onCreate() {
        super.onCreate();

        contadorState = new ContadorState();
        contadorFinState = new contadorFinState();
        iniToFinState = new IniToFinState();
    }

    public IniToFinState getIniToFinState() {
        return iniToFinState;
    }
    public void setIniToFinState(IniToFinState state){
        this.iniToFinState = state;
    }

    public ContadorState getContadorState() {
        return contadorState;
    }

    public void setContadorState(ContadorState state) {
        this.contadorState = state;

    }

    public contadorFinState getcontadorFinState() {
        return contadorFinState;
    }

    public void setcontadorFinState(es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin.contadorFinState state) {
        this.contadorFinState = state;
    }
}
