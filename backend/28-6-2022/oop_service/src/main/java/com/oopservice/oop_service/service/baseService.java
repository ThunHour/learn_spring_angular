package com.oopservice.oop_service.service;

import java.io.Serializable;

public interface baseService <DResponse,DResponseList,TKey extends Serializable,TEntity> {

    // TEntity == DTO
    // DResponse==model or object
    // DResponseList== listmodel
    DResponseList getAll();
    TEntity getById(TKey id);
    DResponse create(TEntity model);
    DResponse update(TKey id,TEntity model);
    DResponse delete(TKey id);
}
