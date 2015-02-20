package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Posting;

public class PostingDaoMock implements PostingDao {

    private HashMap<Long, Posting> postings;
    private Long nextId;

    public PostingDaoMock() {
        initWeblog();
    }

    public final void initWeblog() {

        postings = new HashMap<>();
        Posting posting1 = new Posting(1L, "Title 1", "Content 1");
        posting1.addComment("comment1");
        posting1.addComment("comment2");
        postings.put(1L, posting1);
        postings.put(2L, new Posting(2L, "Title 2", "Content 2"));
        postings.put(3L, new Posting(3L, "Title 3", "Content 3"));
        nextId = 4L;
    }

    @Override
    public void create(Posting p) {
        if (p == null) {
            throw new IllegalArgumentException("Posting is null");
        }
        p.setId(nextId);
        postings.put(nextId++, p);
    }

    @Override
    public List<Posting> findAll() {
        return new ArrayList(postings.values());
    }

     @Override
    public Posting find(Long id) {
        if (!postings.containsKey(id)) {
            throw new IllegalArgumentException("Id no found" + id);
        }
        return postings.get(id);
    }

    @Override
    public void delete(Long id) {
        postings.remove(id);
    }
}
