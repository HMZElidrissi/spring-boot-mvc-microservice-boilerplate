package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.repository;

import ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.domain.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {}
