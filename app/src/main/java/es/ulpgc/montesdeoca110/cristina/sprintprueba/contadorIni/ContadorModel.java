package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni;


import android.arch.lifecycle.ViewModel;

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

    @Override
    public void updateContador(ContadorViewModel viewModel) {
        if(viewModel.contador!=9) {
            viewModel.contador++;
        }else{
            viewModel.contador=0;
        }
        this.cuenta = viewModel.contador +"";
    }

}
