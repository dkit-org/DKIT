package org.dkit.fxclient.constants;

public enum View {
    SETTINGS("Settings"),
    IMAGES("Images"),
    CONTAINERS("Containers");

    private final String value;

    View(final String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("/widgets/%sWidget.fxml", this.value);
    }
}
