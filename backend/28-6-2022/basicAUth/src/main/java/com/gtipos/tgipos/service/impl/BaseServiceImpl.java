package com.gtipos.tgipos.service.impl;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.gtipos.tgipos.service.BaseService;

@Service
public abstract class BaseServiceImpl<DResponse, DResponseList, TKey extends Serializable, TEntity>
        implements BaseService<DResponse, DResponseList, TKey, TEntity> {

    protected abstract JpaRepository<TEntity, TKey> getBaseRepository();

    protected abstract DResponse newRespond();

    @Override
    public DResponseList getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TEntity getById(TKey id) {

        Optional<TEntity> optionalResult = getBaseRepository().findById(id);
        // DResponse response = newRespond();
        if (optionalResult.isEmpty()) {
            return null;
        }

        return optionalResult.get();
    }

    @Override
    public DResponse create(TEntity model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DResponse update(TKey id, TEntity model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DResponse delete(TKey id) {
        // TODO Auto-generated method stub
        return null;
    }

}
