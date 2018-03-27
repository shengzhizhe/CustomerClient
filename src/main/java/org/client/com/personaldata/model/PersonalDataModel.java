package org.client.com.personaldata.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author ld
 * @name 个人资料
 * @table
 * @remarks
 */
public class PersonalDataModel implements Serializable {

    @NotBlank(message = "主键丢失", groups = Update.class)
    private String uuid;

    @NotBlank(message = "名称不能为空", groups = {Add.class, Update.class})
    @Size(min = 1, max = 5, message = "名称长度为1-5位之间", groups = {Add.class, Update.class})
    @Pattern(regexp = "[\\u4E00-\\u9FA5]+", message = "名称必须是汉字", groups = {Add.class, Update.class})
    private String userName;

    @Size(min = 0, max = 2, message = "性别长度只有一位", groups = {Add.class, Update.class})
    @Pattern(regexp = "[M,F]", message = "性别选择错误", groups = {Add.class, Update.class})
    private String sex;

    @Pattern(regexp = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)" +
            "|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)",
            message = "身份证格式错误", groups = {Add.class, Update.class})
    private String IDNumber;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号格式错误", groups = {Add.class, Update.class})
    private String phone;

    @Pattern(regexp = "^[^&#<>'\\\"\\\\|+%\\\\\\\\]*$",message = "常驻地址不能包含特殊符号", groups = {Add.class, Update.class})
    private String permanentAddress;

    private String birthday;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public PersonalDataModel() {
        super();
    }

    public PersonalDataModel(String uuid, String userName, String sex, String IDNumber, String phone, String permanentAddress, String birthday) {
        this.uuid = uuid;
        this.userName = userName;
        this.sex = sex;
        this.IDNumber = IDNumber;
        this.phone = phone;
        this.permanentAddress = permanentAddress;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PersonalDataModel{" +
                "uuid='" + uuid + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
