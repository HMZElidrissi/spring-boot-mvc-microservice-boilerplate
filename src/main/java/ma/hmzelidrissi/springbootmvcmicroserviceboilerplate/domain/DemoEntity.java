package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "entities")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(length = 50)
  @Builder.Default
  private String status = "ACTIVE";

  @CreationTimestamp private LocalDateTime createdAt;

  @UpdateTimestamp private LocalDateTime updatedAt;
}
