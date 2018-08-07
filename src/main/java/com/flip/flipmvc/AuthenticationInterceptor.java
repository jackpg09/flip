package com.flip.flipmvc;

import com.flip.flipmvc.Models.Data.UserDao;
import com.flip.flipmvc.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.flip.flipmvc.Controllers.UserController.userSessionKey;

/**
 * Created by LaunchCode
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        // Authentication white list; add all publicly visible pages here
        List<String> nonAuthPages = Arrays.asList("/user/login", "/user/signUp", "/user/logout", "/home", "/flip", "/flip/disc");

        // Require sign-in for auth pages
        if ( !nonAuthPages.contains(request.getRequestURI()) ) {

            Integer userId = (Integer) request.getSession().getAttribute(userSessionKey);

            if (userId != null) {
                User user = userDao.findOne(userId);

                if (user != null)
                    return true;
            }

            response.sendRedirect("/user/login");
            return false;
        }

        return true;
    }

}