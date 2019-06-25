package Dao;

import Model.Tax;

import java.util.List;

public interface TaxDao {

    List<Tax> getAllTaxes();

    Tax getTax(int taxId);

}
