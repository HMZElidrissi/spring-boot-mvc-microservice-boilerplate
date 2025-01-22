package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity.DemoRequest;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.entity.DemoResponse;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.dto.response.PageResponse;
import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.service.DemoService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demos")
@RequiredArgsConstructor
@Tag(name = "Demo API")
public class DemoController {

  private final DemoService demoService;

  @GetMapping
  @Operation(summary = "Get all entities")
  public PageResponse<DemoResponse> findAll(Pageable pageable) {
    return demoService.findAll(pageable);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get entity by ID")
  public DemoResponse findById(@PathVariable Long id) {
    return demoService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Create new entity")
  public DemoResponse create(@Valid @RequestBody DemoRequest request) {
    return demoService.create(request);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update existing entity")
  public DemoResponse update(@PathVariable Long id, @Valid @RequestBody DemoRequest request) {
    return demoService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Delete entity")
  public void delete(@PathVariable Long id) {
    demoService.delete(id);
  }
}
