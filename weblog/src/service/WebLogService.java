package service;

import dao.PostingDao;
import dao.PostingDaoMock;
import java.util.List;
import model.Posting;

public class WebLogService {

    private final PostingDao postingDao;
    private final static WebLogService instance = new WebLogService();

    private WebLogService() {
        postingDao = new PostingDaoMock();
    }
    
    public static WebLogService instance() {
        return instance;
    }

    public void addPosting(Posting p) {
        postingDao.create(p);
    }
    
    public Posting getPosting(Long id) {
        return postingDao.find(id);
    }

    public List<Posting> getPostings() {
        return postingDao.findAll();
    }
    
    public void addComment(Long id, String content) {
        postingDao.find(id).addComment(content);
    }
    
    public void deletePosting(Long id) {
        postingDao.delete(id);
    }
}
