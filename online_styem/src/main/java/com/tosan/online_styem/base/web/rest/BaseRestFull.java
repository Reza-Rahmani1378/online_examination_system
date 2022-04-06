package com.tosan.online_styem.base.web.rest;

import com.tosan.online_styem.base.BaseDTO;
import com.tosan.online_styem.base.BaseEntity;
import com.tosan.online_styem.base.mapper.BaseMapper;
import com.tosan.online_styem.base.service.BaseService;
import com.tosan.online_styem.exception.BadInputRunTimeException;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public class BaseRestFull<E extends BaseEntity<PK>, D extends BaseDTO<PK>, PK extends Serializable,
        S extends BaseService<E, PK>, M extends BaseMapper<E, D>> {


    private final S service;


    private final M mapper;


    public BaseRestFull(S service, M mapper) {
        this.service = service;
        this.mapper = mapper;
    }

//    @GetMapping
    @ApiOperation(value = "get all entity")
    public ResponseEntity<List<D>> getAll() {
        return ResponseEntity.ok(
                mapper.convertListEntitiesToListDTO(
                        service.findAllNotSecure()
                )
        );
    }


    //    @GetMapping("/{id}")
    public ResponseEntity<D> findById(PK id) {
        Optional<E> optionalE = service.findByIdNotSecure(id);

        /*if (optionalE.isPresent()) {

            return ResponseEntity.ok(
                    mapper.convertEntityToDTO(optionalE.get())
            );
        } else {
            return ResponseEntity.notFound().build();
        }*/


        /*Optional<D> d = optionalE.map(mapper::convertEntityToDTO);

        return ResponseEntity.ok(d.get());*/

        /*return optionalE.map(e -> ResponseEntity.ok(
                mapper.convertEntityToDTO(e)
        )).orElseGet(() -> ResponseEntity.notFound().build());

*/

        return optionalE.map(
                e -> ResponseEntity.ok(
                        mapper.convertEntityToDTO(e)
                )
        ).orElseThrow(() -> new BadInputRunTimeException("Entity Not found!"));
    }


    //    @DeleteMapping
    @ApiOperation(value = "delete by id")
    public ResponseEntity<Void> deleteById(PK id) {
        service.deleteByIdNotSecure(id);
        return ResponseEntity.ok().build();
    }

    //    @PostMapping
    @ApiOperation(value = "save new entity")
    public ResponseEntity<D> save(D d) {
        if (d.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        E entity = service.saveNotSecure(
                mapper.convertDTOToEntity(d)
        );

        return ResponseEntity.ok(
                mapper.convertEntityToDTO(entity)
        );
    }

    //    @PutMapping
    @ApiOperation(value = "update entity")
    public ResponseEntity<D> update(D d) {
        if (d.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        E entity = mapper.convertDTOToEntity(d);
        entity.setId(d.getId());
        E updateEntity = service.saveNotSecure(
                entity
        );

        return ResponseEntity.ok(
                mapper.convertEntityToDTO(updateEntity)
        );
    }


}
