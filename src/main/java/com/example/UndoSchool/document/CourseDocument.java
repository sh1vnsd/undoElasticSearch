package com.example.UndoSchool.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "courses")
public class CourseDocument {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text, analyzer = "english")
    private String title;

    @Field(type = FieldType.Keyword, name = "title_raw", ignoreAbove = 256)
    private String titleRaw;

    @Field(type = FieldType.Text, analyzer = "english")
    private String description;


    @Field(type = FieldType.Keyword, name = "description_raw", ignoreAbove = 512)
    private String descriptionRaw;

    @Field(type = FieldType.Keyword)
    private String category;


    @Field(type = FieldType.Keyword)
    private String type;


    @Field(type = FieldType.Keyword)
    private String gradeRange;


    @Field(type = FieldType.Integer)
    private Integer minAge;

    @Field(type = FieldType.Integer)
    private Integer maxAge;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime nextSessionDate;
}
