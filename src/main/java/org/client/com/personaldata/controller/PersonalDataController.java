package org.client.com.personaldata.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.client.com.personaldata.model.PersonalDataModel;
import org.client.com.server.CustomerInterface;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author ld
 * @name 个人资料
 * @table
 * @remarks
 */
@Api(value = "personalData", description = "个人资料")
@RestController
@RequestMapping("/personalData")
public class PersonalDataController {

    @Autowired
    private CustomerInterface customerInterface;

    @ApiOperation(value = "获取个人资料",
            response = ResponseResult.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/personalData/account/{account}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<PersonalDataModel> init(@PathVariable("account") String account) {
        return customerInterface.personaldata_getByAccount(account);
    }

    @ApiOperation(value = "修改个人资料",
            response = ResponseResult.class,
            httpMethod = "PUT",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/personalData", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<PersonalDataModel> update(@RequestBody PersonalDataModel model,
                                                    BindingResult bindingResult) {
        ResponseResult<PersonalDataModel> result = new ResponseResult<>();

        if (bindingResult.hasErrors()) {
            result.setSuccess(false);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        if (model.getUuid() == null || model.getUuid().trim().equals(""))
            return customerInterface.personaldata_add(model);
        else
            return customerInterface.personaldata_update(model);
    }
}
