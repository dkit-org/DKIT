package org.dkit.fxclient.controller;

import com.github.dockerjava.api.model.Image;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.dkit.api.ImageService;
import org.dkit.fxclient.constants.SelectionType;
import org.dkit.fxclient.event.SelectionEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class ImagesController implements Initializable {


    private final ApplicationEventPublisher eventPublisher;
    private final ImageService imageService;
    private TableView<Image> tableView;
    public VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableView = new TableView<>();
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        var imageIdCol = new TableColumn<Image, String>("Image Id");
        var imageNameCol = new TableColumn<Image, String>("Image Name");

        this.tableView.getColumns().addAll(imageIdCol, imageNameCol);
        this.tableView.getItems().addAll(this.imageService.getImages());

        imageIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        imageNameCol.setCellValueFactory(new PropertyValueFactory<>("parentId"));

        this.tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, preValue, newValue) -> {
            var count = this.tableView.getSelectionModel().getSelectedItems().size();
            if (count > 1 ){
                this.eventPublisher.publishEvent(new SelectionEvent(SelectionType.MULTIPLE_CONTAINERS));
            }else if (count == 1 ){
                this.eventPublisher.publishEvent(new SelectionEvent(SelectionType.SINGLE_CONTAINER));
            }
        });

        this.vBox.getChildren().add(this.tableView);
    }
}
