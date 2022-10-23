package org.dkit.fxclient.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class ToolBarController {
    public Button copyBtn;
    public Button pasteBtn;
    public Button deleteBtn;
    public Button editBtn;
    public TextField search;

	public void copyHandler(ActionEvent actionEvent) {
        System.out.println("copy");
    }

    public void cutHandler(ActionEvent actionEvent) {
    }

    public void pasteHandler(ActionEvent actionEvent) {
    }

    public void activateSingleContainerActions() {
        this.removeSelection();
        this.copyBtn.setDisable(false);
        this.editBtn.setDisable(false);
        this.deleteBtn.setDisable(false);
    }

    public void activateMultipleContainersActions() {
        this.removeSelection();
        this.deleteBtn.setDisable(false);
    }

    public void activateSingleImageActions() {
    }

    public void activateMultipleImagesActions() {
    }

    public void removeSelection() {
        this.copyBtn.setDisable(true);
        this.editBtn.setDisable(true);
        this.deleteBtn.setDisable(true);
    }
}
