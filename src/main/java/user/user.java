package user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class user {
    @Id
    private String id;

    private String name;
    private String surname;
    private String age;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }
}

