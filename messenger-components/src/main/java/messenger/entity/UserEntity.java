package messenger.entity;

import messenger.util.EmailAddress;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserEntity implements Serializable, User {
    private static final long serialVersionUID = 1284979737196653356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private EmailAddress emailAddress;

    protected UserEntity() {}

    public UserEntity(String nickName, String password, EmailAddress emailAddress) {
        this.nickName = nickName;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserEntity))
            return false;

        UserEntity user = (UserEntity) o;

        return getId().equals(user.getId());
    }
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }
}
