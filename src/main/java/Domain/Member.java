package Domain;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Member {

    private Integer id;
    private String username;

    public Member(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
