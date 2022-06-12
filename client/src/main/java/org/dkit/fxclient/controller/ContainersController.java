package org.dkit.fxclient.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.dkit.fxclient.constants.SelectionType;
import org.dkit.fxclient.event.SelectionEvent;
import org.dkit.fxclient.model.Container;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class ContainersController implements Initializable {


    //private final ContainerService containerService;
    private final ApplicationEventPublisher eventPublisher;

    private TableView<Container> tableView;
    public VBox containersRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableView = new TableView<Container>();
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        var idCol = new TableColumn<Container, Long>("Id");
        var imageNameCol = new TableColumn<Container, String>("Image Name");
        var imageIdCol = new TableColumn<Container, String>("Image Id");

        this.tableView.getColumns().addAll(idCol, imageIdCol, imageNameCol);
        //this.tableView.getItems().addAll(this.containerService.getContainers());

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        imageNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        imageIdCol.setCellValueFactory(new PropertyValueFactory<>("imageId"));

        this.tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, preValue, newValue) -> {
            var count = this.tableView.getSelectionModel().getSelectedItems().size();
            if (count > 1 ){
                this.eventPublisher.publishEvent(new SelectionEvent(SelectionType.MULTIPLE_CONTAINERS));
            }else if (count == 1 ){
                this.eventPublisher.publishEvent(new SelectionEvent(SelectionType.SINGLE_CONTAINER));
            }
        });

        this.containersRoot.getChildren().add(this.tableView);
    }
}
