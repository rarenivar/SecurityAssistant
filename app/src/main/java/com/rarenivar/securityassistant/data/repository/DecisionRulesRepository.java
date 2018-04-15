package com.rarenivar.securityassistant.data.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.rarenivar.securityassistant.data.dao.PermissionDao;
import com.rarenivar.securityassistant.data.database.DecisionRulesDatabase;
import com.rarenivar.securityassistant.data.entity.Permission;

import java.util.List;

public class DecisionRulesRepository {

    private PermissionDao permissionDao;
    private LiveData<List<Permission>> permissions;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public DecisionRulesRepository(Application application) {
        DecisionRulesDatabase db = DecisionRulesDatabase.getDatabase(application);
        permissionDao = db.permissionsDao();
        permissions = permissionDao.getAllPermissions();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Permission>> getAllPermissions() {
        return permissions;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    public void insert (Permission permission) {
        new insertAsyncTask(permissionDao).execute(permission);
    }

    private static class insertAsyncTask extends AsyncTask<Permission, Void, Void> {

        private PermissionDao asyncTaskDao;

        insertAsyncTask(PermissionDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Permission... params) {
            asyncTaskDao.insertPermission(params[0]);
            return null;
        }
    }

}
