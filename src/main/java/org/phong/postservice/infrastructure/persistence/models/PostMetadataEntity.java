package org.phong.postservice.infrastructure.persistence.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_metadata")
public class PostMetadataEntity extends BaseEntity {
    @Id
    @Column(nullable = false)
    private UUID id;

    private String key;

    private String value;

    @OneToOne
    @MapsId
    private PostEntity post;
}
