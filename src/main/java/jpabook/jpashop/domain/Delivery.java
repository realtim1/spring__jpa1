package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

    @Embedded // 내장 타입
    private Address address;

    @Enumerated(EnumType.STRING) //ORDINAL 은 순서로 들어가기 때문에 아예 사용 금지
    private DeliveryStatus status; // Ready, COMP;

}
