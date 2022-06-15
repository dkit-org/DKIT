package org.dkit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public abstract class Group<T> {

    private Set<T> list = new HashSet<>();

    @Getter
    private final String id;

    @Getter
    @Setter
    private final String name;

    public void add(T obj) {
        this.list.add(obj);
    }

    public void add(T... objs) {
        this.list.addAll(Arrays.asList(objs));
    }

    public void remove(T obj) {
        this.list.remove(obj);
    }

    public Collection<T> get(){
        return this.list.parallelStream().toList();
    }

}
