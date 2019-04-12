package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorIni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.R;

public class ContadorActivity
        extends AppCompatActivity implements ContadorContract.View {

    public static String TAG = ContadorActivity.class.getSimpleName();

    private ContadorContract.Presenter presenter;

    Button incButton, resetButton;
    TextView contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        getSupportActionBar().setTitle("Contador");

        incButton = findViewById(R.id.button);
        contador = findViewById(R.id.contador);
        resetButton=findViewById(R.id.buttonReset);
        incButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateContadorData();
            }
        });
        incButton.setText("Incrementar");

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onResetButtonClicked();
            }
        });
        resetButton.setText("Reset");
        // do the setup
        ContadorScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ContadorContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ContadorViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.contador)).setText(viewModel.data);
    }

    @Override
    public void displayContadorData(ContadorViewModel viewModel) {
        String data = viewModel.contador + "";
        contador.setText(data);
    }
}
