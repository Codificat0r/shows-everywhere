package com.example.showseverywhere.ui.amigos;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

import com.example.showseverywhere.R;

/**
 * Created by carlos on 9/01/18.
 */

public class ActionModeCallback implements ActionMode.Callback {
    private OnActionModeSuceso callback;

    public ActionModeCallback(OnActionModeSuceso onActionModeSuceso) {
        this.callback = onActionModeSuceso;
    }

    public interface OnActionModeSuceso {
        void borrarPulsado();
        void actionModeDestruido();
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        menu.add(R.string.action_mode_amigos_borrar);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getTitle().equals("Borrar") || item.getTitle().equals("Delete"))
            callback.borrarPulsado();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        callback.actionModeDestruido();
    }
}
