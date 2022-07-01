package org.dkit.domain;

import lombok.*;

import java.util.Set;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Network {
    private final String id;
    private final String name;
}
