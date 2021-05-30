package com.example.arcoreimage;

import android.util.Log;

import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.sceneform.ux.ArFragment;

public class CustomARFragment extends ArFragment {
    @Override
    protected Config getSessionConfiguration(Session session) {
        getPlaneDiscoveryController().setInstructionView(null);
        Config config = new Config(session);
        config.setUpdateMode(Config.UpdateMode.LATEST_CAMERA_IMAGE);
        session.configure(config);
        getArSceneView().setupSession(session);

        if ((((MainActivity) getActivity()).setupAugmentedImagesDB(config, session)))
            Log.d("arcoreimg_db", "success");
        else
            Log.e("arcoreimg_db","faliure setting up db");

        return config;
    }
}