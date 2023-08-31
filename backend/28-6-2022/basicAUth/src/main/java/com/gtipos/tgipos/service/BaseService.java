package com.gtipos.tgipos.service;

import java.io.Serializable;

public interface BaseService<DResponse, DResponseList, TKey extends Serializable, TEntity> {
    DResponseList getAll();

    TEntity getById(TKey id);

    DResponse create(TEntity model);

    DResponse update(TKey id, TEntity model);

    DResponse delete(TKey id);
}
