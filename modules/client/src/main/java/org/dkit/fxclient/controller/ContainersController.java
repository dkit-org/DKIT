package org.dkit.fxclient.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.dkit.api.ContainerService;
import org.dkit.fxclient.constants.SelectionType;
import org.dkit.fxclient.dto.ContainerDTO;
import org.dkit.fxclient.dto.mapper.ContainerDTOMapper;
import org.dkit.fxclient.event.SelectionEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class ContainersController implements Initializable {


    //private final ContainerService containerService;
    private final ApplicationEventPublisher eventPublisher;
    private final ContainerService containerService;
    private final ContainerDTOMapper containerDTOMapper;

    private TableView<ContainerDTO> tableView;
    public VBox containersRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableView = new TableView<ContainerDTO>();
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        var idCol = new TableColumn<ContainerDTO, String>("Container Id");
        var imageNameCol = new TableColumn<ContainerDTO, String>("Container Name");

        this.tableView.getColumns().addAll(idCol, imageNameCol);
        this.tableView.getItems().addAll(this.getContainers());

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        imageNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        this.tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, preValue, newValue) -> {
            var count = this.tableView.getSelectionModel().getSelectedItems().size();
            if (count == 1 ){
                this.eventPublisher.publishEvent(new SelectionEvent(SelectionType.SINGLE_CONTAINER));
            }else if (count > 1 ){
                this.eventPublisher.publishEvent(new SelectionEvent(SelectionType.MULTIPLE_CONTAINERS));
            }
        });

        this.containersRoot.getChildren().add(this.tableView);
    }

    List<ContainerDTO> getContainers(){
        return this.containerDTOMapper.mapToDTOList(this.containerService.getContainers());
    }
}
