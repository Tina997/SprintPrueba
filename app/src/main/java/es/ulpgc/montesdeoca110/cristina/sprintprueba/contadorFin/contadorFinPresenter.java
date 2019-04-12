package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin;

import android.util.Log;

import java.lang.ref.WeakReference;

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
        contadorFinState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
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
        router.navigateToNextScreen();
    }


}
