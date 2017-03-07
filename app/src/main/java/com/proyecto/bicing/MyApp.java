package com.proyecto.bicing;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by alex on 21/02/2017.
 */

public class MyApp extends Application {

        private Firebase ref;

        public Firebase getRef() {
            return ref;
        }

        @Override
        public void onCreate() {
            super.onCreate();

            super.onCreate();
            Firebase.setAndroidContext(this);
            Firebase.getDefaultConfig().setPersistenceEnabled(true);

            ref = new Firebase("https://todooos-9ef4d.firebaseio.com/");
        }

}
