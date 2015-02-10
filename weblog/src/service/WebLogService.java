package service;

import dao.PostingDao;
import dao.PostingDaoMock;
import java.util.List;
import model.Posting;

public class WebLogService {

    private final PostingDao postingDao;

    public WebLogService() {
        postingDao = new PostingDaoMock();
    }

    public void addPosting(Posting p) {
        postingDao.create(p);
    }

    public List<Posting> getPostings() {
        return postingDao.findAll();
    }
    
    public void addComment(Long id, String content) {
        postingDao.find(id).addComment(content);
    }
}
