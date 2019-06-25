package Controller;

import Model.ShippingRegion;
import Service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/shipping/regions")
public class ShippingController {

    private ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShippingRegion> gerShippingRegions() {
        return shippingService.gerShippingRegions();
    }

    @RequestMapping(value = "/{shipping_region_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, String> getShippingRegion(@PathVariable("shipping_region_id") int shippingRegionId) {
        return shippingService.getShippingRegion(shippingRegionId);
    }
}
