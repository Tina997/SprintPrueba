package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;

public class contadorFinPresenter implements contadorFinContract.Presenter {

    public static String TAG = contadorFinPresenter.class.getSimpleName();

    private WeakReference<contadorFinContract.View> view;
    private contadorFinViewModel viewModel;
    private contadorFinContract.Model model;
    private contadorFinContract.Router router;

    public contadorFinPresenter(contadorFinState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<contadorFinContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(contadorFinContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(contadorFinContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        IniToFinState state = router.getDataFromCounterScreen();
        if (state != null) {
            viewModel.data = state.getCuenta()+"";
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void onResetButtonClicked() {
        IniToFinState iniToFinState = new IniToFinState();
        iniToFinState.resetCuenta();
        router.passDataToNextScreen(iniToFinState);
        router.navigateToNextScreen();
    }


}
