package Controller;

import Model.Tax;
import Service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tax")
public class TaxController {

    private TaxService taxService;

    @Autowired
    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tax> getAllTaxes() {
        return taxService.getAllTaxes();
    }

    @RequestMapping(value = "/{tax_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tax getTax(@PathVariable("tax_id") int taxId) {
        return taxService.getTax(taxId);
    }

}
