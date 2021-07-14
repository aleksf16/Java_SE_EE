package cart;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class cart {

    @Id
    private String id;

    private String userId;
    private String userName;
    private String userSurname;
    private String age;



    private String[] itemsId;


    private int count;


    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public String[] getItemsId() {
        return itemsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setItemId(String[] itemId) {
        this.itemsId = itemId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

