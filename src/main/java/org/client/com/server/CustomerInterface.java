package org.client.com.server;

import feign.Body;
import feign.Headers;
import feign.RequestLine;
import org.client.com.cargoaddress.model.CargoAddressModel;
import org.client.com.personaldata.model.PersonalDataModel;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ld
 * @name 客户远程接口类
 * @table
 * @remarks
 */
public interface CustomerInterface {

    /*****************************************************个人资料*************************************************************/

    @RequestLine("GET /personaldata/{id}")
    ResponseResult<PersonalDataModel> personaldata_getById(@PathVariable("id") String id);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /personaldata")
    @Body("model={model}")
    ResponseResult<PersonalDataModel> personaldata_add(@RequestBody PersonalDataModel model);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("PUT /personaldata")
    @Body("model={model}")
    ResponseResult<PersonalDataModel> personaldata_update(@RequestBody PersonalDataModel model);

    /*****************************************************收货地址*************************************************************/

    @RequestLine("GET /crgoaddress/{id}")
    ResponseResult<List<CargoAddressModel>> crgoaddress_findByAccId(@PathVariable("id") String id);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /crgoaddress")
    @Body("model={model}")
    ResponseResult<CargoAddressModel> crgoaddress_add(@RequestBody CargoAddressModel model);

    @RequestLine("DELETE /crgoaddress/{id}")
    ResponseResult<CargoAddressModel> crgoaddress_delById(@PathVariable("id") String id);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("PUT /crgoaddress")
    @Body("model={model}")
    ResponseResult<CargoAddressModel> crgoaddress_update(@RequestBody CargoAddressModel model);

}
