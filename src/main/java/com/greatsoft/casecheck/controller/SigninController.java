package com.greatsoft.casecheck.controller;

import com.alibaba.fastjson.JSONObject;
import com.greatsoft.casecheck.common.AjaxResponse;
import com.greatsoft.casecheck.dto.account.LoginRequestDTO;
import com.greatsoft.casecheck.entiry.Account;
import com.greatsoft.casecheck.exception.BusinessException;
import com.greatsoft.casecheck.mapper.AccountMapper;
import com.greatsoft.casecheck.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/***
 * @author yangzhanbiao on 2019年04月30日18:04:38
 */
@RestController
public class SigninController {
    private static final Logger logger = LoggerFactory.getLogger(SigninController.class);
    @Autowired
    private AccountMapper accountMapper;
    @Value("${gxsoft.indexUrl}")
    private String indexUrl;
    @Value("${gxsoft.getToken}")
    private String token;
    @Value("${gxsoft.redirectUrl}")
    private String redirectUrl;
    @Value("${gxsoft.client}")
    private String client;

    @PostMapping("/signin")
    public AjaxResponse login(@RequestBody LoginRequestDTO loginRequestDto, HttpServletRequest request) {
        if (loginRequestDto == null && StringUtils.isBlank(loginRequestDto.getAccount()) && StringUtils.isBlank(loginRequestDto.getPassword())) {
            return AjaxResponse.failed("用户名或密码不可为空");
        }

        logger.info("用户名:{},密码:{}", loginRequestDto.getAccount(), loginRequestDto.getPassword());
        String password = MD5Util.GetMD5Code(loginRequestDto.getPassword());
        List<Account> accounts = null;
        try {
            accounts = accountMapper.findAccountsByAccountAndAndPassword(loginRequestDto.getAccount(), password);
        } catch (Exception e) {
            logger.error("查询失败，失败原因{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (accounts == null || accounts.size() == 0 || accounts.size() > 1) {
            return AjaxResponse.failed("用户名或密码不存在");
        }

        HttpSession session = request.getSession();
        session.setAttribute("account", accounts.get(0));
        return AjaxResponse.success();
    }

    /**
     * 退出
     *
     * @param request
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort()) + path + "/signin";
        return basePath;
    }

    /**
     * 单点登录对接接口
     *
     * @param request
     * @param response
     */
    @GetMapping("/oauth/code")
    public void getOauthToken(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");

        if (StringUtils.isBlank(code)) {
            try {
                //调用开放平台接口
                logger.info("访问109平台code接口，url:{}", indexUrl);
                response.sendRedirect(indexUrl);
            } catch (Exception e) {
                logger.error("访问109平台code接口失败，失败原因：{}", e.getMessage());
                throw new BusinessException("访问开发平台code接口失败");
            }
        }

        System.out.print("code=" + code);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        Base64 base64 = new Base64();
        try {
            headers.set("Authorization",
                    "basic " + base64.encodeToString(client.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            logger.error("base64加密异常{}", e.getMessage());
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
                null, headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = token + "&code=" + code
                + "&redirect_uri=" + redirectUrl;
        logger.info("访问109平台token接口url{}", url);

        //调用开放平台返回的参数
        String result = null;
        try {
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            result = exchange.getBody().toString();
        } catch (Exception e) {
            logger.error("访问109平台token接口失败，失败原因：{}", e.getMessage());
            throw new BusinessException("访问109平台token接口失败");
        }

        if (StringUtils.isBlank(result)) {
            logger.info("--------------------返回参数失败---------------");
            throw new BusinessException("返回参数失败");
        }

        Map<String, Object> tokenData = JSONObject.parseObject(result,
                Map.class);
        System.out.println("openid >>>>>>>>>>>> "
                + tokenData.get("open_id"));
        // 通过平台返回open_id查询系统用户信息
        String lid = (String) tokenData.get("open_id");
        if (StringUtils.isBlank(lid)) {
            logger.info("--------------------open_id获取失败---------------");
            throw new BusinessException("open_id获取失败");
        }

        List<Account> accounts = null;
        try {
            accounts = accountMapper.findAccountsByLid(lid);
        } catch (Exception e) {
            logger.info("查询人员信息异常{}", e.getMessage());
            throw new BusinessException("查询人员信息异常");
        }

        String prefix = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort());
        String goUrl=prefix+"/login";
        if (accounts != null && !accounts.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("account", accounts.get(0));
            goUrl = prefix+"/home";;
        }

        try {
            logger.info("跳转{}", goUrl);
            response.sendRedirect(goUrl);
        } catch (IOException e) {
            logger.error("跳转页面失败，失败原因：{}", e.getMessage());
            throw new BusinessException("跳转" + goUrl + "失败");
        }

    }
}
