package org.dkit.engineclient.mapper;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class AbstractMapper<Type, EngineType> {
    public abstract EngineType mapToEngineType(Type type);
    public abstract Type mapFromEngineType(EngineType typeDTO);

    public List<EngineType> mapToEngineTypeList(List<Type> typeList){
        return typeList.stream().map(this::mapToEngineType).collect(Collectors.toList());
    }

    public List<Type> mapFromEngineType(List<EngineType> typeDTOList){
        return typeDTOList.stream().map(this::mapFromEngineType).collect(Collectors.toList());
    }
}
