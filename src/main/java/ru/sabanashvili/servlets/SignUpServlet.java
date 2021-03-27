package ru.sabanashvili.servlets;

import ru.sabanashvili.modules.User;
import ru.sabanashvili.repositories.UsersRepository;
import ru.sabanashvili.repositories.UsersRepositoryInMemoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//сервлет, отвечающий за регистрацию
//аннотация определяет на какой урл реагирует сервлет
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UsersRepository usersRepository;

    @Override
    public void init() throws ServletException {
        this.usersRepository = new UsersRepositoryInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();
        //мы в реквест добавляем ключ-строка, значение-список, чтоб потом на странице у реквеста
        //вытащить список юзеров по указанному ключу
        req.setAttribute("usersFromServer", users);
        //получаем диспетчер на страницу /jsp/signUp.jsp
        //диспетчер управляет запросами(например, перенаправляет их)
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        //перенеаправление исходного запроса на эту страницу
        dispatcher.forward(req, resp);
    }
}
//получил запрос, вытащил пользователей, в аттрибуты добавил пользователей
//и скормил это jsp-странице
