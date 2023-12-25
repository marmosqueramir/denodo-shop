package com.denodo.challenge.jpa;


import com.denodo.challenge.exceptions.ModelException;

import javax.management.InstanceNotFoundException;
import java.io.Serializable;
import java.util.List;

public interface GenericEntityDao<T, P extends Serializable> {

    public T create(T t) throws ModelException;

    public void flush();

    public void clear();

    public void detach(T obj);

    public T findOne(P id);

    public T update(T t);

    public void delete(T t);

    public void deleteNoMerge(T t);

    public void deleteById(P id) throws InstanceNotFoundException;

    public List<T> findAll();

}
