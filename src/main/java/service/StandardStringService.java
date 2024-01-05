package service;

import dao.StandardStringDAO;
import entity.StandardString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class StandardStringService {
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


    public List<String> getListaStrings() {
        try {
            List<StandardString> s=standardStringDAO.retrieve();
            List<String> temp = new ArrayList<>();
            for(int i=0; i<s.size(); i++){
                temp.add(s.get(i).getValue());
            }
            return temp;
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateStringa(int id,String stringa){
        try {
            StandardString temp = standardStringDAO.findById(id);
            temp.setValue(stringa);
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
