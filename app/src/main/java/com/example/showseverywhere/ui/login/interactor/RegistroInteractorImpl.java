package com.example.showseverywhere.ui.login.interactor;

import com.example.showseverywhere.data.db.model.Provincia;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.data.db.repository.ProvinciaRepository;
import com.example.showseverywhere.data.db.repository.UsuarioEstandarRepository;
import com.example.showseverywhere.ui.utils.TextUtils;

import java.util.ArrayList;

/**
 * Created by carlos on 11/01/18.
 */

public class RegistroInteractorImpl implements RegistroInteractor {
    private OnPeticionFinalizada listener;

    public interface OnPeticionFinalizada {
        void onExitoObtenerProvincias(ArrayList<String> provincias);
        void campoObligatorioVacio();
        void onExitoRegistro();
        void contrasenaMalFormada();
        void emailMalFormado();
    }

    public RegistroInteractorImpl(OnPeticionFinalizada listener) {
        this.listener = listener;
    }

    @Override
    public void obtenerProvincias() {
        ArrayList<Provincia> provincias = ProvinciaRepository.getInstance().getProvincias();
        ArrayList<String> nombreProvincias = new ArrayList<>();

        for (Provincia tmp : provincias) {
            nombreProvincias.add(tmp.getProvincia());
        }

        listener.onExitoObtenerProvincias(nombreProvincias);
    }

    @Override
    public void verificarDatosRegistroUsuarioEstandar(String nombreUsuario, String contrasena, String email, String provincia) {
        if (!TextUtils.verificarCampoLleno(nombreUsuario) || !TextUtils.verificarCampoLleno(contrasena) || !TextUtils.verificarCampoLleno(email)) {
            listener.campoObligatorioVacio();
        } else if (!TextUtils.verificarContrasenaBienFormada(contrasena)) {
            listener.contrasenaMalFormada();
        } else if (!TextUtils.verificarEmailBienFormado(email)) {
            listener.emailMalFormado();
        } else {
            ArrayList<Provincia> provincias = ProvinciaRepository.getInstance().getProvincias();
            Provincia provinciaCompleta = null;

            for (Provincia tmp : provincias) {
                if (tmp.getProvincia() == provincia)
                    provinciaCompleta = tmp;
            }

            UsuarioEstandarRepository.getInstance().getUsuariosEstandar().add(new UsuarioEstandar(nombreUsuario, null, null, contrasena, provinciaCompleta, email));
            listener.onExitoRegistro();
        }
    }
}
