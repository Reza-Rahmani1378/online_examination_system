package com.tosan.online_styem.base.mapper;

import java.util.List;

public interface BaseMapper<E , D> {

    E convertDTOToEntity(D d);

    D convertEntityToDTO(E e);

    List<E> convertListDTOToListEntities(List<D> dList);

    List<D> convertListEntitiesToListDTO(List<E> eList);
}
