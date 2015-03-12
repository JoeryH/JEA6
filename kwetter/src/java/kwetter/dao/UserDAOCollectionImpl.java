package kwetter.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import kwetter.domain.User;

//@Stateless
public class UserDAOCollectionImpl implements UserDAO {
    
    DataStorageBean dsb = new DataStorageBean();
    
    public UserDAOCollectionImpl() {
    }

    @Override
    public int count() {
        return dsb.count();
    }

    @Override
    public void create(User user) {
        dsb.create(user);
    }

    @Override
    public void edit(User user) {
       dsb.edit(user);
    }

    @Override
    public List<User> findAll() {
        return dsb.findAll();
    }

    @Override
    public void remove(User user) {
        dsb.remove(user);
    }

    @Override
    public User find(Long id) {
        return dsb.find(id);
    }   
}
