package org.phong.postservice.dtos.share;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoMetadata implements MetadataInterface {
    @NotNull
    @URL
    private String videoUrl;

    private Integer duration;
    private String resolution;
    private String thumbnailUrl;
}
