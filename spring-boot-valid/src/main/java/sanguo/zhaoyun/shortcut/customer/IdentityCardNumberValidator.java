package sanguo.zhaoyun.shortcut.customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * {@link IdentityCardNumber} 自定义注解标签解析类
 *
 * @company: MEGVII
 * @author: tushiguang
 * @create: 2022/5/23 16:11
 **/
public class IdentityCardNumberValidator implements ConstraintValidator<IdentityCardNumber, Object> {

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return o.toString().startsWith("110");//
    }
}
