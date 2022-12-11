package org.dkit.fxclient.core.routing;

import javafx.scene.Node;
import lombok.*;

import java.util.Optional;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
class DefaultRoute implements Route{

	@Getter
	private final String id;

	@Getter
	private final String name;

	@Getter
	private final Node view;

	@Getter
	@Setter
	private String title;

	@Setter
	private Route parentRoute;

	public Optional<Route> getParentRoute(){
		return Optional.ofNullable(parentRoute);
	}

	@Override
	public boolean isChildRoute() {
		return this.parentRoute != null;
	}
}
