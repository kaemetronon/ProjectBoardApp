package mongotopostgres;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "F6FieldHelper")
public class MongoEntity {
    @Id
    private String id;

    @Field(value = "code")
    private int code;

    @Field(value = "text")
    private String text;
}
