package com.proyecto.bicing;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListaActivityFragment extends Fragment {

    private FirebaseListAdapter<Bici> adapter;
    TextView name,longitud,latitud,bike,type;

    public ListaActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View listaFragment =  inflater.inflate(R.layout.fragment_lista, container, false);

        ListView listParada = (ListView) listaFragment.findViewById(R.id.lista_Parada);

        ConnectFirebase app = (ConnectFirebase) getActivity().getApplication();
        Firebase ref = app.getRef();

        final Firebase stats = ref.child("stations");

        Log.d("STATIONS", stats.toString());

        adapter = new FirebaseListAdapter<Bici>(getActivity(), Bici.class, R.layout.fila_parada, stats) {
            @Override
            protected void populateView(View view, Bici bicis, int position) {

                name = (TextView) view.findViewById(R.id.streetName);
                name.setText(bicis.getStreetName());

                longitud = (TextView)view.findViewById(R.id.longitude);
                longitud.setText(bicis.getLongitude());

                latitud = (TextView)view.findViewById(R.id.latitude);
                latitud.setText(bicis.getLatitude());

                bike = (TextView)view.findViewById(R.id.bike);
                bike.setText(bicis.getBikes());

                type = (TextView)view.findViewById(R.id.type_Bikes);
                type.setText(bicis.getType());
            }
        };

        listParada.setAdapter(adapter);

    return listaFragment;
    }
}
