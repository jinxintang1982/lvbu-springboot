package sanguo.zhaoyun.shortcut.controller;


import sanguo.zhaoyun.shortcut.customer.IdentityCardNumber;

import javax.validation.constraints.NotNull;

public class RequestParam {

    @NotNull(message = "年龄不能为空")
    public Long age;

    @NotNull(message = "姓名不能为空", groups = {ISaveGroup.class})
    public String name;

    @IdentityCardNumber(message = "身份证号不能为空")
    public String clientCardNo;

    @Override
    public String toString() {
        return "RequestParam{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", clientCardNo='" + clientCardNo + '\'' +
                '}';
    }


}
