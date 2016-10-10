package me.tatarka.redux;

import android.util.Log;
import me.tatarka.redux.middleware.Middleware;

public class LogMiddleware<S> implements Middleware<S> {

    private final String tag;
    private final int priority;

    public LogMiddleware(String tag) {
        this(tag, Log.DEBUG);
    }

    public LogMiddleware(String tag, int priority) {
        this.tag = tag;
        this.priority = priority;
    }

    @Override
    public void create(Store<S> store) {
        
    }

    @Override
    public void dispatch(Next next, Object action) {
        Log.println(priority, tag, action.toString());
        next.next(action);
    }
}
