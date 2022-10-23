package org.dkit.fxclient.core.routing;

import org.springframework.context.ApplicationEvent;

public class NavigationEvent extends ApplicationEvent {

	private Route route;

	public NavigationEvent(int routeId) {
		super(routeId);
	}

	public NavigationEvent(int routeId, Route route){
		super(routeId);
		this.route = route;
	}

	public int getRouteId(){
		return (int) this.source;
	}

	public Route getRoute(){
		return this.route;
	}

	public boolean containsRoute(){
		return !(this.route == null);
	}

}
