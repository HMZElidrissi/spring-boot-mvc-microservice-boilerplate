package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity;

import java.time.LocalDateTime;
import lombok.*;

@Builder
public record DemoResponse(
    Long id,
    String name,
    String description,
    String status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {}
