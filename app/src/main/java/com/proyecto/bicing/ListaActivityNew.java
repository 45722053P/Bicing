package com.proyecto.bicing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

public class ListaActivityNew extends AppCompatActivity {

    private FirebaseListAdapter<Bici> adapter;
    TextView name,longitud,latitud,bike,type;
    ListView listParada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_new);

        listParada = (ListView) findViewById(R.id.lista_parada);

        MyApp app = (MyApp)this.getApplication();
        Firebase ref = app.getRef();

        final Firebase stats = ref.child("stations");

        Log.d("STATIONS", stats.toString());

        adapter = new FirebaseListAdapter<Bici>(this, Bici.class, R.layout.fila_parada, stats) {
            @Override
            protected void populateView(View view, Bici bicis, int position) {

                name = (TextView) view.findViewById(R.id.streetName);
                name.setText(bicis.getStreetName());

                longitud = (TextView)view.findViewById(R.id.longitude);
                longitud.setText(bicis.getLongitude());

                latitud = (TextView)view.findViewById(R.id.latitude);
                latitud.setText(bicis.getLatitude());

                bike = (TextView)view.findViewById(R.id.bike);
                bike.setText("Bicis libres: " + bicis.getBikes());

                type = (TextView)view.findViewById(R.id.type_Bikes);
                type.setText("Tipo Bici: " + bicis.getType());


            }
        };

        listParada.setAdapter(adapter);

    }
}
