package org.client.com.cargoaddress.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author ld
 * @name 收货地址
 * @table
 * @remarks
 */
public class CargoAddressModel {

    @NotBlank(message = "主键丢失", groups = UPDATE.class)
    private String uuid;
    @NotBlank(message = "用户标识丢失", groups = {ADD.class, UPDATE.class})
    private String accId;
    @Size(max = 100, message = "收货地址限制长度为100位", groups = {ADD.class, UPDATE.class})
    @Pattern(regexp = "^[^&#<>'\\\"\\\\|+%\\\\\\\\]*$", message = "常驻地址不能包含特殊符号",
            groups = {ADD.class, UPDATE.class})
    private String address;
    //    是否为默认收货地址
    @Size(max = 1, message = "默认地址选择错误", groups = {ADD.class, UPDATE.class})
    @Pattern(regexp = "^[Y,N]$", message = "默认地址选择错误", groups = {ADD.class, UPDATE.class})
    private String defaults;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDefaults() {
        return defaults;
    }

    public void setDefaults(String defaults) {
        this.defaults = defaults;
    }

    public CargoAddressModel() {
        super();
    }

    public CargoAddressModel(String uuid, String accId, String address, String defaults) {
        this.uuid = uuid;
        this.accId = accId;
        this.address = address;
        this.defaults = defaults;
    }

    @Override
    public String toString() {
        return "CargoAddressModel{" +
                "uuid='" + uuid + '\'' +
                ", accId='" + accId + '\'' +
                ", address='" + address + '\'' +
                ", defaults='" + defaults + '\'' +
                '}';
    }
}
