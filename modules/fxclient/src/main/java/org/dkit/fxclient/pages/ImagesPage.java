package org.dkit.fxclient.pages;

import jakarta.inject.Singleton;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.dkit.fxclient.core.CanRender;

@Singleton
public class ImagesPage implements CanRender {

    @Override
    public Parent render() {
        var table = new TableView();
        var firstNameCol = new TableColumn<>("First Name");
        var lastNameCol = new TableColumn("Last Name");
        var emailCol = new TableColumn("Email");

        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        return table;
    }
}
