package org.dkit.fxclient.core.routing;

public interface Route{
	int getId();
	String getName();
	<T> T getView();
}
