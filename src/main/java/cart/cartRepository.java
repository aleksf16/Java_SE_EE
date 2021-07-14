package cart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cartRepository extends MongoRepository<cart, String> {

}
