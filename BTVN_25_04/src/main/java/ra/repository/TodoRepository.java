package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo , Long> {
}
