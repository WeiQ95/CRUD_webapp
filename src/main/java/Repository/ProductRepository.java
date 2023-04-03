package Repository;

import java.util.List;
import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.timelessfinds.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Optional<Product>  findById(Long id);
    
}
