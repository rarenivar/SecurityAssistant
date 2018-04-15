package com.rarenivar.securityassistant.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class DecisionRulesRepository {

    private PermissionsDao permissionsDao;
    private LiveData<List<Permissions>> permissions;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public DecisionRulesRepository(Application application) {
        DecisionRulesDatabase db = DecisionRulesDatabase.getDatabase(application);
        permissionsDao = db.permissionsDao();
        permissions = permissionsDao.getAllPermissions();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Permissions>> getAllPermissions() {
        return permissions;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    public void insert (Permissions permission) {
        new insertAsyncTask(permissionsDao).execute(permission);
    }

    private static class insertAsyncTask extends AsyncTask<Permissions, Void, Void> {

        private PermissionsDao asyncTaskDao;

        insertAsyncTask(PermissionsDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Permissions... params) {
            asyncTaskDao.insertPermission(params[0]);
            return null;
        }
    }

}
