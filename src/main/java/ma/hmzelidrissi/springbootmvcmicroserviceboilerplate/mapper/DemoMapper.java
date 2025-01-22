package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.mapper;

import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.domain.DemoEntity;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity.DemoRequest;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity.DemoResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DemoMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  DemoEntity toEntity(DemoRequest request);

  DemoResponse toResponse(DemoEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  void updateEntity(DemoRequest request, @MappingTarget DemoEntity entity);
}
