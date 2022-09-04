package org.dkit.fxclient.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper<Type, TypeDTO> {
    public abstract TypeDTO mapToDTO(Type type);
    public abstract Type mapFromDTO(TypeDTO typeDTO);

    public List<TypeDTO> mapToDTOList(List<Type> typeList){
        return typeList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<Type> mapFromDTOList(List<TypeDTO> typeDTOList){
        return typeDTOList.stream().map(this::mapFromDTO).collect(Collectors.toList());
    }
}
