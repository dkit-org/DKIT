package org.dkit.fxclient.model;

public enum Status {
    Stopped("Stopped"),
    Running ("Running");
    private final String value;

    Status(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
