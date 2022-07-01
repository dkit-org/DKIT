package org.dkit.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class Application {


    private Set<Container> list = new HashSet<>();

    @Getter
    private final String id;

    @Getter
    @Setter
    private final String name;
    public void addContainer(Container container) {
        this.list.add(container);
    }

    public void addContainer(Container... containers) {
        this.list.addAll(Arrays.asList(containers));
    }

    public void removeContainer(Container container) {
        this.list.remove(container);
    }

    public Collection<Container> getAllContainers(){
        return this.list.parallelStream().toList();
    }
}
