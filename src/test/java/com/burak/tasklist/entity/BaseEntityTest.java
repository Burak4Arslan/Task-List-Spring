package com.burak.tasklist.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseEntityTest {

    BaseEntity baseEntity;

    @Before
    public void setUp(){
        baseEntity = new BaseEntity();
        baseEntity.setId(3L);
    }

    @Test
    public void getId() {
        Long id =  3L;
        assertEquals(id,baseEntity.getId());
    }

    @Test
    public void setId() {
        Long idValue = 3L;
        baseEntity.setId(idValue);

        assertEquals(idValue,baseEntity.getId());
    }
}