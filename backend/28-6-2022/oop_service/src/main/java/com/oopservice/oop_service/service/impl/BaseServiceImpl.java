package com.oopservice.oop_service.service.impl;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.oopservice.oop_service.service.baseService;

@Service
public abstract class BaseServiceImpl<DResponse, DResponseList, TKey extends Serializable, TEntity>
        implements baseService<DResponse, DResponseList, TKey, TEntity> {
            
    protected abstract JpaRepository<TEntity, TKey> getBaseRepository();

    protected abstract DResponse newResponse();

    @Override
    public TEntity getById(TKey id) {
        Optional<TEntity> optionalResult = getBaseRepository().findById(id);
        // DResponse response=newResponse();
        if (!optionalResult.isEmpty()) {
            return optionalResult.get();
        }
        return null;
        
    }

    @Override
    public DResponse create(TEntity model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DResponse delete(TKey id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DResponseList getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DResponse update(TKey id, TEntity model) {
        // TODO Auto-generated method stub
        return null;
    }

}
