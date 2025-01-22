package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record DemoRequest(
    @NotBlank(message = "Name is required") String name, String description, String status) {}
