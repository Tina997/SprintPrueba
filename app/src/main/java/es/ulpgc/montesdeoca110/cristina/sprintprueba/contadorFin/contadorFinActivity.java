package es.ulpgc.montesdeoca110.cristina.sprintprueba.contadorFin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.sprintprueba.R;

public class contadorFinActivity
        extends AppCompatActivity implements contadorFinContract.View {

    public static String TAG = contadorFinActivity.class.getSimpleName();

    private contadorFinContract.Presenter presenter;
    Button resetButton;
    TextView contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_fin);
        contador = findViewById(R.id.contador);
        resetButton=findViewById(R.id.buttonReset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onResetButtonClicked();
            }
        });
        resetButton.setText("Reset");
        // do the setup
        contadorFinScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(contadorFinContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(contadorFinViewModel viewModel) {
        ((TextView) findViewById(R.id.contador)).setText(viewModel.data);
    }
}
