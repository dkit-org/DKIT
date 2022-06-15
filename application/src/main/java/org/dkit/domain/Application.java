package org.dkit.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Application {
    @Getter
    private final String id;
    @Getter
    @Setter
    private final String name;
    private ImageGroup imageGroup;
    private ContainerGroup containerGroup;
}
