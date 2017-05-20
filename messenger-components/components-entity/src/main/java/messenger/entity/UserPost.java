package messenger.entity;

import javax.persistence.*;

@Entity
public class UserPost {
    @Id
    private Long id;
    @Column(nullable = false)
    private Long timeCreated;
    @Column(length = 1024, nullable = false)
    private String postText;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userprofile_id")
    private UserProfile author;
}
