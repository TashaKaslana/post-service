package org.phong.postservice.dtos.share;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogMetadata implements MetadataInterface {
    private String title;
    private String summary;
    private Integer wordCount;
    private String bannerImageUrl;
}
