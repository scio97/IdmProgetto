package com.marcoarcarisi.demo.service;

import com.marcoarcarisi.demo.dao.TreniCreatiDAO;
import com.marcoarcarisi.demo.entity.TreniCreati;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TreniCreatiService {

    @Autowired
    private TreniCreatiDAO treniCreatiDAO;


    public void insertTrenoCreato(TreniCreati elemento){
        try {
            treniCreatiDAO.create(elemento);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteStringa(int id){
        try {
            treniCreatiDAO.delete(treniCreatiDAO.findById(id));
        } catch (Exception e) {
            throw e;
        }
    }

    public TreniCreati findById(int id){
        try {
            TreniCreati temp= treniCreatiDAO.findById(id);
            return temp;
        } catch (Exception e) {
            throw e;
        }
    }

}