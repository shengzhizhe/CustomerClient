package org.client.com.personaldata.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.client.com.personaldata.model.PersonalDataModel;
import org.client.com.personaldata.model.Update;
import org.client.com.server.PersonalDataInterface;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    private PersonalDataInterface dataInterface;

    @ApiOperation(value = "获取个人资料",
            response = ResponseResult.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/personalData/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<PersonalDataModel> init(@PathVariable("id") String id) {
        return dataInterface.getById(id);
    }

    @ApiOperation(value = "修改个人资料",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/personalData", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<PersonalDataModel> update(@Validated(value = Update.class) @RequestBody PersonalDataModel model,
                                                    BindingResult bindingResult) {
        ResponseResult<PersonalDataModel> result = new ResponseResult<>();

        if (bindingResult.hasErrors()) {
            result.setSuccess(false);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        if (model.getUuid() == null || model.getUuid().trim().equals(""))
            return dataInterface.add(model);
        else
            return dataInterface.update(model);
    }
}
