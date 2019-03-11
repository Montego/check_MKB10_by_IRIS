package ru.vitasoft.pilipenko.MIAC_Tables.controller.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RESTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException{

        clearAuthenticationAttributes(request);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.getOutputStream().print(
                String.format("{\"message\": \"You succesfuly logged in as user [%s]\"}",
                        authentication.getName()));

        response.getOutputStream().print("");

    }
}
