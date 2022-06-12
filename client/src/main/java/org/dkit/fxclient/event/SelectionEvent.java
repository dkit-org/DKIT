package org.dkit.fxclient.event;

import org.dkit.fxclient.constants.SelectionType;
import org.springframework.context.ApplicationEvent;

public class SelectionEvent extends ApplicationEvent {


    public SelectionType getSelectionType(){
        return (SelectionType) this.source;
    }

    public SelectionEvent(SelectionType selectionType) {
        super(selectionType);
    }
}
