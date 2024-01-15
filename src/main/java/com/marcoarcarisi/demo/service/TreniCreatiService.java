package com.marcoarcarisi.demo.service;

import com.marcoarcarisi.demo.dao.TreniCreatiDAO;
import com.marcoarcarisi.demo.entity.TreniCreati;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public void deleteTreno(int id){
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

    public List<TreniCreati> getTreniByUtente(String username) {
        try {
            return treniCreatiDAO.getTreniByUtente(username);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<TreniCreati> getTreni() {
        try {
            List<TreniCreati> s=treniCreatiDAO.retrieve();
            return s;
        } catch (Exception e) {
            throw e;
        }
    }
}