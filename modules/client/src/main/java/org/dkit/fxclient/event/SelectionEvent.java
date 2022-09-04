package org.dkit.fxclient.event;

import lombok.Getter;
import org.dkit.fxclient.constants.SelectionType;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class SelectionEvent extends ApplicationEvent {

    @Getter
    private List<String> containerIDs;

    public SelectionType getSelectionType(){
        return (SelectionType) this.source;
    }

    public SelectionEvent(SelectionType selectionType) {
        super(selectionType);
    }


    public SelectionEvent(SelectionType selectionType, List<String> containerIDs) {
        super(selectionType);
        this.containerIDs = containerIDs;
    }
}
