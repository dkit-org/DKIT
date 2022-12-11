package org.dkit.fxclient.core.routing;

import org.springframework.context.ApplicationEvent;

public class NavigationEvent extends ApplicationEvent {

	private Route route;

	public NavigationEvent(final String routeId) {
		super(routeId);
	}

	public NavigationEvent(final String routeId, Route route){
		super(routeId);
		this.route = route;
	}

	public String getRouteId(){
		return (String) this.source;
	}

	public Route getRoute(){
		return this.route;
	}

	public boolean containsRoute(){
		return !(this.route == null);
	}

}
