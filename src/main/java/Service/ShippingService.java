package Service;

import Dao.ShippingDao;
import Model.ShippingRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ShippingService {

    private ShippingDao shippingDao;

    @Autowired
    public ShippingService(ShippingDao shippingDao) {
        this.shippingDao = shippingDao;
    }

    public List<ShippingRegion> gerShippingRegions() {
        return shippingDao.gerShippingRegions();
    }

    public HashMap<String, String> getShippingRegion(int shippingRegionId) {
        return shippingDao.getShippingRegion(shippingRegionId);
    }

}
