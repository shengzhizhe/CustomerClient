package org.client.com.server;

import feign.Body;
import feign.Headers;
import feign.RequestLine;
import org.client.com.personaldata.model.PersonalDataModel;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface PersonalDataInterface {

    @RequestLine("GET /personaldata/{id}")
    ResponseResult<PersonalDataModel> getById(@PathVariable("id") String id);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /personaldata/add")
    @Body("model={model}")
    ResponseResult<PersonalDataModel> add(@RequestBody PersonalDataModel model);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /personaldata/update")
    @Body("model={model}")
    ResponseResult<PersonalDataModel> update(@RequestBody PersonalDataModel model);
}
