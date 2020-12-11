package mongotopostgres;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository<MongoEntity, Long> {
    MongoEntity findByCode(int code);

    MongoEntity findByText(String text);
}
