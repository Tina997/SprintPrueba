package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.IniToFinState;

interface contadorFinContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(contadorFinViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void onResetButtonClicked();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(contadorFinState state);

        contadorFinState getDataFromPreviousScreen();

        IniToFinState getDataFromCounterScreen();
    }
}
