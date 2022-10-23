package org.dkit.fxclient.constants;

public enum Routes {
	SIGNUP,
	LOGIN,
	DASHBOARD,
	CONTAINER,
	IMAGE;

	public String toPath(){
		return "screens/" + this.name().toLowerCase() + ".fxml";
	}
}
