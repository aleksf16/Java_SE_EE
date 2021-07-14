package item;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemRepository  extends MongoRepository<item, String> {

}
