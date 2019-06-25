package Dao;

import Model.ShippingRegion;

import java.util.HashMap;
import java.util.List;

public interface ShippingDao {

    List<ShippingRegion> gerShippingRegions();

    HashMap<String, String> getShippingRegion(int shippingRegionId);

}
