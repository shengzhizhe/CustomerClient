package org.client.com.cargoaddress.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.client.com.cargoaddress.model.ADD;
import org.client.com.cargoaddress.model.CargoAddressModel;
import org.client.com.cargoaddress.model.UPDATE;
import org.client.com.server.CustomerInterface;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ld
 * @name 收货地址
 * @table
 * @remarks
 */
@Api(value = "cargoaddress", description = "收货地址")
@RestController
@RequestMapping("/cargoaddress")
public class CargoAddressController {

    @Autowired
    private CustomerInterface customerInterface;

    @ApiOperation(value = "根据账户获取收货地址",
            response = ResponseResult.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/cargoaddress/{id}", method = RequestMethod.GET)
    public ResponseResult<List<CargoAddressModel>> getByAccId(@PathVariable("id") String id) {
        return customerInterface.crgoaddress_findByAccId(id);
    }

    @ApiOperation(value = "新增收货地址",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/cargoaddress",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<CargoAddressModel> save(@Validated(value = ADD.class) @RequestBody CargoAddressModel model,
                                                  BindingResult bindingResult) {
        ResponseResult<CargoAddressModel> result = new ResponseResult<>();

        if (bindingResult.hasErrors()) {
            result.setSuccess(false);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        return customerInterface.crgoaddress_add(model);
    }

    @ApiOperation(value = "根据id修改收货地址",
            response = ResponseResult.class,
            httpMethod = "PUT",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/cargoaddress",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<CargoAddressModel> update(@Validated(value = UPDATE.class) @RequestBody CargoAddressModel model,
                                                    BindingResult bindingResult) {
        ResponseResult<CargoAddressModel> result = new ResponseResult<>();

        if (bindingResult.hasErrors()) {
            result.setSuccess(false);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        return customerInterface.crgoaddress_update(model);
    }

    @ApiOperation(value = "根据id删除收货地址",
            response = ResponseResult.class,
            httpMethod = "DELETE",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/cargoaddress/{id}", method = RequestMethod.DELETE)
    public ResponseResult<CargoAddressModel> delById(@PathVariable("id") String id) {
        return customerInterface.crgoaddress_delById(id);
    }
}
