package com.proyecto.bicing;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by alex on 21/02/2017.
 */

public class ConnectFirebase extends Application{

        private Firebase ref;

        public Firebase getRef() {
            return ref;
        }

        public void setRef(Firebase ref) {
            this.ref = ref;
        }

        @Override
        public void onCreate() {
            super.onCreate();

            super.onCreate();
            Firebase.setAndroidContext(this);

            ref = new Firebase("https://todooos-9ef4d.firebaseio.com/");
        }

}
