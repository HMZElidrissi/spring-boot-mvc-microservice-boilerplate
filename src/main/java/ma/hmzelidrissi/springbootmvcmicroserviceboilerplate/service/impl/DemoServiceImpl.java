package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.domain.DemoEntity;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity.DemoRequest;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity.DemoResponse;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.response.PageResponse;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.exception.ResourceNotFoundException;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.mapper.DemoMapper;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.repository.DemoRepository;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.service.DemoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

  private final DemoRepository repository;
  private final DemoMapper demoMapper;

  @Override
  public PageResponse<DemoResponse> findAll(Pageable pageable) {
    Page<DemoEntity> page = repository.findAll(pageable);
    List<DemoResponse> content = page.getContent().stream().map(demoMapper::toResponse).toList();
    return PageResponse.of(content, page);
  }

  @Override
  public DemoResponse findById(Long id) {
    return repository
        .findById(id)
        .map(demoMapper::toResponse)
        .orElseThrow(() -> new ResourceNotFoundException("Entity not found with id: " + id));
  }

  @Transactional
  @Override
  public DemoResponse create(DemoRequest request) {
    DemoEntity entity = demoMapper.toEntity(request);
    return demoMapper.toResponse(repository.save(entity));
  }

  @Transactional
  @Override
  public DemoResponse update(Long id, DemoRequest request) {
    DemoEntity entity =
        repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Entity not found with id: " + id));

    demoMapper.updateEntity(request, entity);
    return demoMapper.toResponse(repository.save(entity));
  }

  @Transactional
  @Override
  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("Entity not found with id: " + id);
    }
    repository.deleteById(id);
  }
}
