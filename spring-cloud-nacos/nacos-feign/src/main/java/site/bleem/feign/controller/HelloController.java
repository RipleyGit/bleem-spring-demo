package site.bleem.feign.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.UuidUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.bleem.feign.client.BrdDataFeignClient;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author yubangshui
 * @desc todo
 * @date 2023/7/25
 */
@RestController
public class HelloController {
    @Resource
    private BrdDataFeignClient brdDataFeignClient;

    @GetMapping("/hello")
    public ResponseEntity<String> returnWorld() {
        return ResponseEntity.ok("world!");
    }
    @GetMapping("/hello/{content}")
    public ResponseEntity<String> settingEquipInfoPlayOrder(@PathVariable("content") @Validated String content) throws Exception {
        JSONObject key = new JSONObject();
        key.put("hid","12345687");
        key.put("equipType",270);
        key.put("port",10005);
        key.put("ip","172.22.6.73");
        List<JSONObject> equipKeyList = Arrays.asList(key);
        JSONObject dto = new JSONObject();
        dto.put("uuid", UuidUtils.generateUuid());
        dto.put("functionType",3);
        dto.put("equipKeyList",equipKeyList);
        dto.put("cycleCount",1);
        dto.put("infoContent",content);
        ResponseEntity responseEntity = brdDataFeignClient.settingEquipInfoPlayOrder(dto);
        return ResponseEntity.ok("world!");
    }
}
