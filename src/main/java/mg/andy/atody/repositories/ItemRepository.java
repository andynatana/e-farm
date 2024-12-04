package mg.andy.atody.repositories;

import mg.andy.atody.models.Item;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ListCrudRepository<Item, Long> {
}
