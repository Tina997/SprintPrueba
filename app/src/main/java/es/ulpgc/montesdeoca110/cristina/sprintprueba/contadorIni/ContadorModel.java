package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni;


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
