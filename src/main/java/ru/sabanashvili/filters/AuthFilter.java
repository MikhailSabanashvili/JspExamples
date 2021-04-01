package ru.sabanashvili.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 Чем отличается авторизация от аутентификации? Когда приходит пользователь, сначала проверяется есть ли у пользователя сессия
 То есть проверяется, проходил ли он авторизацию. Если сессии у пользователя нет, то он направляется на авторизацию - чтоб
 эту сессию получить(каждый пользователь на сервере должен работать в рамках сессии, сессия - это уникальный идентификатор
 пользователя)
 Если нажать F12 на страничке и перейти в куки, то после регистрации мы увидим
 куку JSESSIONID - это кука, которую создает сервер. Она обозначает идентификатор сессии
 У нее можно увидеть номер(на страничке)
 */
@WebFilter("/home")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //если сессия у данного юзера не существует, то он не зареган
        //getSession(false) - потому что метод может сам создать сесссию, а нам этого не надо
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("user")==null){
            servletRequest.getServletContext().getRequestDispatcher("/login").forward(request, response);
        }
        //если зареган, то передать пользователя дальше по цепочке(цепочка фильтров или на сервлет)
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
