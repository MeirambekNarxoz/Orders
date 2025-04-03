package Make_Orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import Make_Orders.client.UserDTO;  // Import UserDTO from the Make_Orders.client package

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String begin_date;
    private String end_date;
    @Column(name = "user_id")
    private Long userId;
    @Transient
    private UserDTO user;
}
