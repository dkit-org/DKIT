package org.dkit.fxclient.core.routing;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dkit.fxclient.ApplicationContextUtils;
import org.dkit.fxclient.constants.Routes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class RouterImpl implements Router, ApplicationListener<NavigationEvent> {

	private static final Logger LOG = LogManager.getLogger(RouterImpl.class);

	private final ApplicationContext applicationContext;
	private final Map<Integer, Route> routes = new HashMap<>();
	private final Stage primaryStage;
	private final Scene primaryScene;

	public RouterImpl(final Stage primaryStage, final Routes defaultRoute) {
		this.applicationContext = ApplicationContextUtils.getBean(ApplicationContext.class);
		this.primaryStage = primaryStage;

		// create primary scene
		LOG.trace("creating primary scene ...");
		this.primaryScene = new Scene(null);
		this.primaryStage.setScene(this.primaryScene);
		// navigate to default page
	}

	public void navigate(int routeId){
		//this.primaryScene
	}

	public void registerRoute(int routeId, Route route){
		LOG.trace("register route with route id: {}", routeId);
		this.routes.put(routeId, route);
	}

	public void registerChildRoute(int routeId, Route route){
		if(route.getParentRoute().isEmpty()){
			LOG.trace("could no register child route {}. child route must contain parent route to ba registered", routeId);
			return;
		}

		LOG.trace("register child route({}) for the route({})", routeId, route.getParentRoute().get().getId());
		this.routes.put(routeId, route);
	}
	public void unregisterRoute(int routeId){
		LOG.trace("unregister route with route id: {}", routeId);
		this.routes.remove(routeId);
	}


	private  <T> T loadView(final String path){
		try {
			LOG.trace("loading FXML view '{}'", path);
			var url = new ClassPathResource(path).getURL();
			var loader = new FXMLLoader(url);
			loader.setControllerFactory(this.applicationContext::getBean);
			return loader.<T>load();
		} catch (IOException e) {
			LOG.error("could not load FXML view '{}'", path);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onApplicationEvent(NavigationEvent event) {
		LOG.debug("event: NavigationEvent(routeId: {}, containsRoute: {})", event.getRouteId(), event.containsRoute());

		// if the route already registered. no need to registered it again.
		// just navigate to it.
		if(this.routes.containsKey(event.getRouteId())){
			LOG.trace("route with id {} is already registered. navigate to route  ...", event.getRouteId());
			this.navigate(event.getRouteId());
		}

		// check if the navigation event contains a route to register it
		else if(event.containsRoute()){

			// register child route
			if(event.getRoute().isChildRoute()){
				LOG.trace("register route: {}", event.getRoute().toString());
				this.registerRoute(event.getRouteId(), event.getRoute());
				LOG.trace("navigate to created route: {}", event.getRoute().toString());
				this.navigate(event.getRouteId());
			}

			// register parent route
			else{
				LOG.trace("register child route: {}", event.getRoute().toString());
				this.registerChildRoute(event.getRouteId(), event.getRoute());
				LOG.trace("navigate to created route: {}", event.getRoute().toString());
				this.navigate(event.getRouteId());
			}

		}else {
			LOG.error("navigation is not possible");
		}
	}
}
