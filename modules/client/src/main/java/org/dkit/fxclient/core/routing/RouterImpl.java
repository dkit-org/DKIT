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
	private Stage primaryStage;
	private Scene primaryScene;

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
		// routing
	}

	public void addRoute(int routeId, Route route){
		this.routes.put(routeId, route);
	}


	private  <T> T loadView(final String path){
		try {
			var url = new ClassPathResource(path).getURL();
			var loader = new FXMLLoader(url);
			loader.setControllerFactory(this.applicationContext::getBean);
			return loader.<T>load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onApplicationEvent(NavigationEvent event) {
		LOG.debug("event: NavigationEvent(routeId: {}, containsRoute: {})", event.getRouteId(), event.containsRoute());
		if(this.routes.containsKey(event.getRouteId())){
			LOG.trace("route with id {} is already registered. navigate to route  ...", event.getRouteId());
			this.navigate(event.getRouteId());
		}else if(event.containsRoute()){
			this.addRoute(event.getRouteId(), event.getRoute());
			LOG.trace("register route: {}", event.getRoute().toString());
			this.navigate(event.getRouteId());
			LOG.trace("navigate to created route: {}", event.getRoute().toString());
		}else {
			LOG.error("navigation is not possible");
		}
	}
}
