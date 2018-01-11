package com.example.showseverywhere.ui.login.interactor;

import com.example.showseverywhere.data.db.model.Usuario;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.data.db.repository.ArtistaRepository;
import com.example.showseverywhere.data.db.repository.PropietarioRepository;
import com.example.showseverywhere.data.db.repository.UsuarioEstandarRepository;
import com.example.showseverywhere.ui.utils.TextUtils;

import java.util.ArrayList;

/**
 * Created by carlos on 11/01/18.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private OnPeticionFinalizada listener;

    public interface OnPeticionFinalizada {
        void onExito();
        void onNombreUsuarioVacio();
        void onContrasenaVacia();
        void credencialesIncorrectos();
    }

    public LoginInteractorImpl(OnPeticionFinalizada listener) {
        this.listener = listener;
    }

    @Override
    public void verificarCredenciales(String nombreUsuario, String contrasena) {
        if (!TextUtils.verificarCampoLleno(nombreUsuario)) {
            listener.onNombreUsuarioVacio();
        } else if (!TextUtils.verificarCampoLleno(contrasena)) {
            listener.onContrasenaVacia();
        } else if (comprobarUsuarioYContrasena(nombreUsuario, contrasena)) {
            listener.onExito();
        } else {
            listener.credencialesIncorrectos();
        }
    }

    private boolean comprobarUsuarioYContrasena(String nombreUsuario, String contrasena) {
        ArrayList<UsuarioEstandar> usuarios = UsuarioEstandarRepository.getInstance().getUsuariosEstandar();

        for (UsuarioEstandar tmp : usuarios) {
            if (tmp.getNick().equals(nombreUsuario) && tmp.getPassword().equals(contrasena))
                return true;
        }

        return false;
    }
}
