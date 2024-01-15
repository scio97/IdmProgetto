package com.marcoarcarisi.demo.service;


import com.marcoarcarisi.demo.dao.StandardStringDAO;
import com.marcoarcarisi.demo.entity.StandardString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class StandardStringService{

    @Autowired
    private StandardStringDAO standardStringDAO;


    public List<StandardString> getListaStandardStrings() {
        try {
            List<StandardString> s=standardStringDAO.retrieve();
            return s;
        } catch (Exception e) {
            throw e;
        }
    }


    public List<String> getListaString() {
        try {
            List<StandardString> s=standardStringDAO.retrieve();
            List<String> temp = new ArrayList<>();
            for(int i=0; i<s.size(); i++){
                temp.add(s.get(i).getValore());
            }
            return temp;
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateStringa(int id,String stringa){
        try {
            StandardString temp = standardStringDAO.findById(id);
            temp.setValore(stringa);
            standardStringDAO.update(temp);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteStringa(int id){
        try {
            standardStringDAO.delete(standardStringDAO.findById(id));
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertStringa(StandardString elemento){
        try {
            standardStringDAO.create(elemento);
        } catch (Exception e) {
            throw e;
        }
    }

    public StandardString findById(int id){
        try {
            StandardString temp= standardStringDAO.findById(id);
            return temp;
        } catch (Exception e) {
            throw e;
        }
    }
}
