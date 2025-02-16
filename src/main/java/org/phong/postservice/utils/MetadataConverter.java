package org.phong.postservice.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.phong.postservice.dtos.share.MetadataInterface;
import org.phong.postservice.enums.BusinessErrorEnum;
import org.phong.postservice.exceptions.MetadataConvertedFailedException;

public class MetadataConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T extends MetadataInterface> T convertMetadata(JsonNode jsonNode, Class<T> targetClass) {
        try {
            return objectMapper.convertValue(jsonNode, targetClass);
        } catch (Exception e) {

            System.err.println("Error converting metadata: " + e.getMessage());

            throw new MetadataConvertedFailedException(BusinessErrorEnum.CONVERT_ERROR.getMessage());
        }
    }

    public static <T extends MetadataInterface> JsonNode convertMetadataToJsonNode(T metadata) {
        try {
            return objectMapper.valueToTree(metadata);
        } catch (Exception e) {
            System.err.println("Error converting metadata to JSON node: " + e.getMessage());

            throw new MetadataConvertedFailedException(BusinessErrorEnum.CONVERT_ERROR.getMessage());
        }
    }

    public  static <T extends MetadataInterface> boolean isMatchWithMetadata(JsonNode jsonNode, Class<T> targetClass) {
        try {
            T metadata = objectMapper.convertValue(jsonNode, targetClass);

            return metadata != null;
        } catch (Exception e) {

            System.err.println("Error converting metadata: " + e.getMessage());

            return false;
        }
    }
}
