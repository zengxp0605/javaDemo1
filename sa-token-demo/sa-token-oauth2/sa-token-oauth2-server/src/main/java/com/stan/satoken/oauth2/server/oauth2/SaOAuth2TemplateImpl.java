package com.stan.satoken.oauth2.server.oauth2;

import cn.dev33.satoken.oauth2.logic.SaOAuth2Template;
import cn.dev33.satoken.oauth2.model.SaClientModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author：zengxp
 * @date：2022/4/13 下午3:07
 */
@Slf4j
@Component
public class SaOAuth2TemplateImpl extends SaOAuth2Template {

    // 根据 id 获取 Client 信息
    @Override
    public SaClientModel getClientModel(String clientId) {
        log.info("getClientModel clientId: {}", clientId);
        // 此为模拟数据，真实环境需要从数据库查询
        if("1001".equals(clientId)) {
            return new SaClientModel()
                    .setClientId("10001")
                    .setClientSecret("aaaa-bbbb-cccc-dddd-eeee")
                    .setAllowUrl("*")
                    .setContractScope("userinfo")
                    .setIsAutoMode(true);
        }
        return null;
    }

    // 根据ClientId 和 LoginId 获取openid
    @Override
    public String getOpenid(String clientId, Object loginId) {
        log.info("getOpenid clientId: {}, loginId: {}", clientId, loginId);

        // 此为模拟数据，真实环境需要从数据库查询
        return "gr_SwoIN0MC1ewxHX_vfCW3BothWDZMMtx__";
    }

}
