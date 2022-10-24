package org.dkit.fxclient.core.routing;

import java.util.Optional;

public interface Route{
	int getId();
	String getName();
	<T> T getView();
	Optional<Route> getParentRoute();
	boolean isChildRoute();
}
