/*
 * Copyright (c) 2014-2018 www.itgardener.cn. All rights reserved.
 */

package cn.edu.nefu.library.web;

import cn.edu.nefu.library.common.ErrorMessage;
import cn.edu.nefu.library.common.LibException;
import cn.edu.nefu.library.common.RestData;
import cn.edu.nefu.library.common.util.JsonUtil;
import cn.edu.nefu.library.common.util.TokenUtil;
import cn.edu.nefu.library.core.model.User;
import cn.edu.nefu.library.service.BookCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author : chenchenT CMY
 * @date : 2018/10/28
 * @since : Java 8
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("api")
@RestController
public class BookCaseApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BookCaseService bookCaseService;

    @Autowired
    public BookCaseApi(BookCaseService bookCaseService) {
        this.bookCaseService = bookCaseService;
    }

    @RequestMapping(value = "/info/{studentId}", method = RequestMethod.GET)
    public RestData getLocation(@PathVariable(value = "studentId") String studentId, HttpServletRequest request) {
        User user = new User();
        user.setStudentId(studentId);
        logger.info("getLocation : " + JsonUtil.getJsonString(user));
        User currentUser = TokenUtil.getUserByToken(request);
        if (null != currentUser) {
            try {
                Map<String, Object> data = bookCaseService.getLocationByUserId(user);
                return new RestData(data);
            } catch (LibException e) {
                return new RestData(1, e.getMessage());
            }
        } else {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
    }

    @RequestMapping(value = "/num", method = RequestMethod.GET)
    public RestData getNum(HttpServletRequest request) {
        logger.info("getNum is running");
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        } else {

            try {
                List<Map<String, Object>> data = bookCaseService.getBagNum();
                return new RestData(data);
            } catch (LibException e) {
                return new RestData(1, e.getMessage());
            }
        }
    }

}
