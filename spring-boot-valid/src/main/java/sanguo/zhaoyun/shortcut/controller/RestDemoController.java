package sanguo.zhaoyun.shortcut.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;


@RestController
@RequestMapping(value = "/test")
@Validated
public class RestDemoController {

    @RequestMapping(value = "/validObject")
    public String validObject(@Validated @RequestBody RequestParam requestParam) {
        return requestParam.toString();
    }

    @RequestMapping(value = "/validBase")
    public String validBase(@Min(10) Integer count) {
        return "test = " + count;
    }

    @RequestMapping("/validGroup")
    public String saveUser(@RequestBody @Validated(ISaveGroup.class) RequestParam requestParam) {
        //必须填写name，才能通过(不检验agv,clientCardNo)
        return requestParam.toString();
    }
}
