package org.binaracademy.orderservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Orders")
public class OrderEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "user_id")
    private UserEntity userDetails;

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "schedule_id")
    private ScheduleEntity scheduleDetails;

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "film_code")
    private FilmEntity filmDetails;
}
