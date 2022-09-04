package org.dkit.fxclient.constants;

public enum Screen {
    // Stages
    ACTIONS("Actions"),
    // Scenes
    LOGIN("Login"),
    DASHBOARD("Dashboard");

    private final String value;

    Screen(final String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("/screens/%sScreen.fxml", this.value);
    }

}
