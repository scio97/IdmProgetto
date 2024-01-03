package dao;

import entity.StandardString;

public interface StandardStringDaoInterface extends DAOInterface<StandardString>{

    public StandardString findById(int id);
}
