package org.dani.medicbook;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.dani.medicbook.base.Patient;
import org.dani.medicbook.base.Visit;
import org.dani.medicbook.base.VisitasMedico;
import org.dani.medicbook.controller.MedicoAdapter;
import org.dani.medicbook.controller.ThreadGetList1;

import java.util.ArrayList;

public class ConsultsMedicActivity extends Fragment
{
    public ListView lista;
    public ArrayList<VisitasMedico> listado;
    public int id;
    public MedicoAdapter ma;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_consults_medic, container, false);

        listado = new ArrayList<VisitasMedico>();

        MainFragmentMedicActivity activity = (MainFragmentMedicActivity) getActivity();
        id = activity.medico;

        ThreadGetList1 tgl1 = new ThreadGetList1(this, id);
        tgl1.execute();

        lista = (ListView) rootView.findViewById(R.id.lista);
        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        this.getActivity().getMenuInflater().inflate(R.menu.lista, menu);
    }

    public ConsultsMedicActivity getConsults()
    {
        return this;
    }

    @Override

    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int itemSeleccionado = info.position;
        VisitasMedico vm = null;

        switch (item.getItemId())
        {
            case R.id.action_eliminar:
                AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
                builder.setMessage(R.string.areyousure)
                        .setPositiveButton(R.string.yes,
                                new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        int idVisita = listado.get(itemSeleccionado).getId();
                                        ThreadGetList1 tgl1 = new ThreadGetList1(getConsults(), idVisita, idVisita);
                                        tgl1.execute();
                                        Toast.makeText(getActivity(), R.string.successful, Toast.LENGTH_LONG).show();
                                        listado.remove(itemSeleccionado);
                                        ma.notifyDataSetChanged();
                                    }
                                })
                        .setNegativeButton(R.string.no,
                                new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        dialog.dismiss();
                                    }
                                });
                builder.create().show();
                break;

            default:
                break;
        }

        return false;
    }

    public void listar()
    {
        ma = new MedicoAdapter(getActivity(), listado, id);
        lista.setAdapter(ma);

        registerForContextMenu(lista);
    }
}