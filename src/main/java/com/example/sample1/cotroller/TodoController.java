package com.example.sample1.cotroller;

import com.example.sample1.dao.TodoDao;
import com.example.sample1.domain.Todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TodoController {

    @Autowired
    private DA
    private TodoDao todoDao;
    public TodoController() {
        todoDao = new TodoDao();
    }

    @GetMapping("/")

    public String home(Model model) {
        // 할 일 리스트 읽고 모델에 넣기
        List<Todo> list = todoDao.list();
        model.addAttribute("todoList", list);

        return "home";
    }

    @PostMapping("/add")
    public String add(Todo todo, RedirectAttributes rttr) {
        // 새 할 일 추가 하고 ,
        todoDao.insert(todo);
        // 결과 model 에 넣고
        // home 으로 redirect
        return "redirect:/";
    }
}
