package com.tim.scientific.portal.back.db.models;

import com.fasterxml.jackson.databind.JsonNode;
import com.tim.scientific.portal.back.dto.ContentTypeEnum;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "contents")
@TypeDef(
        name = "jsonb-node",
        typeClass = JsonNodeBinaryType.class
)
@Getter
@Setter
public class Content {

    @Id
    @GeneratedValue()
    private UUID contentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type")
    private ContentTypeEnum contentType;

    private String name;

    private String description;

    @Type( type = "jsonb-node" )
    @Column(columnDefinition = "jsonb")
    private JsonNode value;

    @ManyToOne()
    @JoinColumn(name = "modules_objects_id")
    private com.tim.scientific.portal.back.db.models.ModulesObject modulesObject;
}