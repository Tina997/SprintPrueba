package es.ulpgc.montesdeoca110.cristina.sprintprueba;

public class IniToFinState {
    int contadorIniToFin;
    public IniToFinState(){
        contadorIniToFin = 0;
    }

    public int getCuenta() {
        return contadorIniToFin;
    }
    public void aumentarContador(){
        contadorIniToFin++;
    }

    public void resetCuenta() {
        contadorIniToFin = 0;
    }
}
