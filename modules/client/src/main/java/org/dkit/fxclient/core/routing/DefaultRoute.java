package org.dkit.fxclient.core.routing;

import javafx.scene.Node;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
class DefaultRoute implements Route{

	@Getter
	private final int id;

	@Getter
	private final String name;

	@Getter
	private final Node view;

	@Getter
	@Setter
	private String title;
}
