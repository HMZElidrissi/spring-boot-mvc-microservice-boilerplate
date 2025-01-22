package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.service;

import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity.DemoRequest;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity.DemoResponse;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;

public interface DemoService {
  PageResponse<DemoResponse> findAll(Pageable pageable);

  DemoResponse findById(Long id);

  DemoResponse create(DemoRequest request);

  DemoResponse update(Long id, DemoRequest request);

  void delete(Long id);
}
