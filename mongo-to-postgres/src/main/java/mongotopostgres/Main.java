package mongotopostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private MongoRepo mongoRepo;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(213231);
        List<MongoEntity> list = new ArrayList<>() {{
            add(new MongoEntity());
            add(new MongoEntity());
        }};
        for (int i = 0; i < list.size(); i++) {
            var x = list.get(i);
            x.setId(String.valueOf(i).concat("qwe"));
            x.setCode(123);
            x.setText("new txt");
        }
        for (MongoEntity mongoEntity : list) {
            mongoRepo.save(mongoEntity);
        }

        for (MongoEntity mongoEntity : mongoRepo.findAll()) {
            System.out.println("code" + mongoEntity.getCode());
        }
        System.out.println("-------------------------------");
        int counter = 0;
        if (mongoRepo.findByText("0text") != null)
            counter++;
        if (mongoRepo.findByText("1text") != null)
            counter++;
        if (mongoRepo.findByCode(0) != null)
            counter++;
        if (mongoRepo.findByCode(33) != null)
            counter++;
        if (counter == 4)
            System.out.println("+");
        else System.out.println(counter);

        mongoRepo.deleteAll();
    }
}
