package com.msa.BestBookMS.persistence;

import com.msa.BestBookMS.domain.model.BestBook;
import com.msa.BestBookMS.domain.model.vo.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestBookRepository extends MongoRepository<BestBook,String> {
    public BestBook findBestBookByItem(Item item);
}
