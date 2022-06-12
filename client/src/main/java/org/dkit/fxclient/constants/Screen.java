package org.dkit.fxclient.constants;

public enum Screen {
    LOGIN("Login"),
    DASHBOARD("Dashboard"),

    // dialogs
    ACTIONS("Actions");

    private final String value;

    Screen(final String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("/screens/%sScreen.fxml", this.value);
    }
}
