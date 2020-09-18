package pelijee.entities.orders;

import lombok.Getter;
import lombok.Setter;
import pelijee.entities.base.Auditable;
import pelijee.entities.web.RegisteredUser;

import javax.persistence.*;

@Entity
@Table(name = "orders_data_registered_user")
@Getter
@Setter
public class OrdersDataRegisteredUser extends Auditable {

    @EmbeddedId
    private OrdersDataRegisteredUserId id;

    @ManyToOne
    @MapsId("ordersDataId")
    @JoinColumn(name = "ordersData_id")
    private OrdersData  ordersData;

    @ManyToOne
    @MapsId("registeredUserId")
    @JoinColumn(name = "registeredUser_id")
    private RegisteredUser registeredUser;

    public OrdersDataRegisteredUser() {
    }

    public OrdersDataRegisteredUser(OrdersData ordersData, RegisteredUser registeredUser) {
        this.id = new OrdersDataRegisteredUserId(ordersData.getId(), registeredUser.getId());
        this.ordersData = ordersData;
        this.registeredUser = registeredUser;
    }
}
