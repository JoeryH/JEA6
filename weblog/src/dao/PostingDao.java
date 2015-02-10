package dao;

import java.util.List;
import model.Posting;

public interface PostingDao {

    void create(Posting p);

    List<Posting> findAll();

    Posting find(Long id);
}
