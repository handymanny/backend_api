package DataAccess;

import Dao.TaxDao;
import Model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxDataAccess implements TaxDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaxDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tax> getAllTaxes() {
        final String sql = "{CALL catalog_get_taxes()}";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int taxId = Integer.valueOf(resultSet.getString("tax_id"));
            String taxType = resultSet.getString("tax_type");
            double taxPercentage = Double.valueOf(resultSet.getString("tax_percentage"));
            return new Tax(taxId, taxType, taxPercentage);
        });
    }

    @Override
    public Tax getTax(int taxId) {
        final String sql = "{CALL catalog_get_tax_details(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{taxId}, (resultSet, i) -> {
            int taxId_t = Integer.valueOf(resultSet.getString("tax_id"));
            String taxType = resultSet.getString("tax_type");
            double taxPercentage = Double.valueOf(resultSet.getString("tax_percentage"));
            return new Tax(taxId, taxType, taxPercentage);
        });
    }
}
