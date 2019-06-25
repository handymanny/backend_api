package Service;

import Dao.TaxDao;
import Model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService {

    private TaxDao taxDao;

    @Autowired
    public TaxService(TaxDao taxDao) {
        this.taxDao = taxDao;
    }

    public List<Tax> getAllTaxes() {
        return taxDao.getAllTaxes();
    }

    public Tax getTax(int taxId) {
        return taxDao.getTax(taxId);
    }
}
