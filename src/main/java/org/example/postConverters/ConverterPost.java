package org.example.postConverters;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.example.util.NamesUtil.USER_ID_PARAMETER;

public class ConverterPost {
    private HttpServletRequest request;

    public ConverterPost(HttpServletRequest request) {
        this.request = request;
    }

    public <T> T convertParameter(String parameter, Class<T> tclass) {
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

    public <V> V convertSessionAttribute(String parameterName) {
        V v = (V) request.getSession().getAttribute(parameterName);
        return v;
    }

    public <V> V convertRequestAttribute(String parameterName) {
        V v = (V) request.getAttribute(parameterName);
        return v;
    }


 /*   public <T> List<T> convertValues(String parameter, Class<T> tclass) {
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
    }*/
}
