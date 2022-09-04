package org.dkit.entity;

import lombok.*;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Network {
    private final String id;
    private final String name;
}
