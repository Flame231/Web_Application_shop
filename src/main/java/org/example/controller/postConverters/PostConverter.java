package org.example.controller.postConverters;

import org.apache.commons.lang3.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.NamesUtil.USER_ID_PARAMETER;

public class PostConverter {
    private HttpServletRequest request;

    public PostConverter(HttpServletRequest request) {
        this.request = request;
    }

    public <T> T convert(String parameter, Class<T> tclass) {
        if (parameter != null) {
            if (!parameter.equals(USER_ID_PARAMETER)) {
                String requestResult = request.getParameter(parameter);
                if (requestResult != null && !requestResult.isEmpty()) {
                    if (tclass == Integer.class) {
                        return (T) Integer.valueOf(requestResult);
                    } else if (tclass == BigDecimal.class) {
                        return (T) new BigDecimal(requestResult);
                    } else if (tclass == String.class)
                        return (T) requestResult;
                    else if (tclass == LocalDate.class) {
                        return (T) LocalDate.parse(requestResult);
                    } else {
                        return null;
                    }
                }
            } else {
                return (T) request.getSession().getAttribute("userId");
            }
        }
        return null;
    }

    public <T> List<T> convertValues(String parameter, Class<T> tclass) {
        List<T> list = new ArrayList<>();
        if (parameter != null) {
            String[] requestResult = request.getParameterValues(parameter);
            for (String string : requestResult) {
                if (tclass.equals(Integer.class)) {
                    list.add((T) Integer.valueOf(string));
                } else if (tclass.equals(BigDecimal.class)) {
                    list.add((T) new BigDecimal(string));
                } else if (tclass.equals(LocalDate.class)) {
                    list.add((T) LocalDate.parse(string));
                }
            }
            return list;
        }
        return null;
    }
}
