package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.AppMediator;
import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;

public class ContadorScreen {

    public static void configure(ContadorContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ContadorState state = mediator.getContadorState();
        IniToFinState iniToFinState = mediator.getIniToFinState();
        //int cuenta = mediator.getCuenta();

        ContadorContract.Router router = new ContadorRouter(mediator);
        ContadorContract.Presenter presenter = new ContadorPresenter(state,iniToFinState);
        ContadorContract.Model model = new ContadorModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
