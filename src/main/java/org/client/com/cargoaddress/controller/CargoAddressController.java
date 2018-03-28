package org.client.com.cargoaddress.controller;

import org.client.com.cargoaddress.model.CargoAddressModel;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ld
 * @name 收货地址
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/cargoaddress")
public class CargoAddressController {

    @RequestMapping(value = "/cargoaddress/{id}", method = RequestMethod.GET)
    public ResponseResult<CargoAddressModel> address(@PathVariable("id") String id) {
        return null;
    }
}
