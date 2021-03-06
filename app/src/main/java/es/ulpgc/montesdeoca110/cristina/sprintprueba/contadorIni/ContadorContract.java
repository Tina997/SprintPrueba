package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;

interface ContadorContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ContadorViewModel viewModel);

        void displayContadorData(ContadorViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void updateContadorData();

        void onResetButtonClicked();
    }

    interface Model {
        String fetchData(String cuenta);

        void updateContador(ContadorViewModel viewModel);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(IniToFinState state,ContadorState contadorState);

        ContadorState getDataFromPreviousScreen();
    }
}
