package org.dkit.fxclient.eventlistener;

import org.dkit.fxclient.common.ViewLoader;
import org.springframework.stereotype.Component;

@Component
public class ActionEventListener {

    private final ViewLoader viewLoader;

    public ActionEventListener(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

}
