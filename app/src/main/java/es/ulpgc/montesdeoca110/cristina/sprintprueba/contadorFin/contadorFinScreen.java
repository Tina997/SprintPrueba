package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.AppMediator;
import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;


public class contadorFinScreen {

    public static void configure(contadorFinContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        contadorFinState state = mediator.getcontadorFinState();
        IniToFinState iniToFinState = mediator.getIniToFinState();
        int cuenta = iniToFinState.getCuenta();
        contadorFinContract.Router router = new contadorFinRouter(mediator);
        contadorFinContract.Presenter presenter = new contadorFinPresenter(state);
        contadorFinContract.Model model = new contadorFinModel(cuenta);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
