package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;

public class ContadorPresenter implements ContadorContract.Presenter {

    public static String TAG = ContadorPresenter.class.getSimpleName();

    private WeakReference<ContadorContract.View> view;
    private ContadorViewModel viewModel;
    private ContadorState state;
    private ContadorContract.Model model;
    private ContadorContract.Router router;
    IniToFinState iniToFinState;
    public ContadorPresenter(ContadorState state, IniToFinState iniToFinState) {
        this.state = state;
        viewModel = state;
        this.iniToFinState = iniToFinState;
    }

    @Override
    public void injectView(WeakReference<ContadorContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ContadorContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ContadorContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        ContadorState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData(viewModel.data);

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayContadorData(viewModel);

    }

    @Override
    public void updateContadorData() {
        model.updateContador(viewModel);
        iniToFinState.aumentarContador();
        view.get().displayContadorData(viewModel);

    }

    @Override
    public void onResetButtonClicked() {
        viewModel.contador = 0;
        router.passDataToNextScreen(iniToFinState, state);
        router.navigateToNextScreen();
    }


}
