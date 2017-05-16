package jansteczko.hiitbodyweightexercise.presenter;

import android.support.annotation.NonNull;

public abstract class BasePresenter<M, V> {

    protected M model;
    protected V view;

    public void setModel(M model) {
        resetState();
        this.model = model;
        if (setupDone()) {
            updateView();
        }
    }

    protected void resetState() {
    }

    public void bindView(@NonNull V view) {
        this.view = view;
        if (setupDone()) {
            updateView();
        }
    }

    public void unbindView() {
        this.view = null;
    }

    public abstract void updateView();

    protected V getView() {
        if (view == null) {
            return null;
        } else {
            return view;
        }
    }

    protected boolean setupDone() {
        return getView() != null && model != null;
    }

}
