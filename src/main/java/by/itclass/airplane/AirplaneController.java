package by.itclass.airplane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AirplaneController {
    private AirplaneRepository repository;

    @Autowired
    public void setRepository(AirplaneRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAirplanes(Model model) {
        var airplanes = repository.findAll();
        model.addAttribute("airplanes", airplanes);
        return "index";
    }

    @GetMapping("/view/{id}")
    public String viewAirplane(@PathVariable(name = "id") int id, Model model) {
        var airplane = repository.findById(id).get();
        model.addAttribute("airplane", airplane);
        return "airplane";
    }

    @GetMapping("/add")
    public ModelAndView addAirplane() {
        return new ModelAndView("add-airplane", "airplane", new Airplane());
    }

    @PostMapping("/save")
    public String saveAirplane(@ModelAttribute(name = "airplane") Airplane airplane) {
        repository.save(airplane);
        return "redirect:/";
    }

    @GetMapping("/del/{id}")
    public String delAirplane(@PathVariable(name = "id") int id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateAirplane(@PathVariable(name = "id") int id) {
        var airplane = repository.findById(id).get();
        return new ModelAndView("upd-airplane", "airplane", airplane);
    }
}
