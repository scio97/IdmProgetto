package dao;

import entity.StandardString;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardStringDaoInterface extends DAOInterface<StandardString>{

    public StandardString findById(int id);
}
