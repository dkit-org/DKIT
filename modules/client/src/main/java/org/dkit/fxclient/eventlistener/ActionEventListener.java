package org.dkit.fxclient.eventlistener;

import org.dkit.fxclient.core.ViewLoader;
import org.springframework.stereotype.Component;

@Component
public class ActionEventListener {

    private final ViewLoader viewLoader;

    public ActionEventListener(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

}
