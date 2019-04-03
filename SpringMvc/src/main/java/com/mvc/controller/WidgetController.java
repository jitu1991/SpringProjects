package com.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.model.Widget;
import com.mvc.repository.WidgetRepository;

@Controller
public class WidgetController {
	
	private Logger LOG = LoggerFactory.getLogger("WidgetController");

	@Autowired
	private WidgetRepository widgetRepository;

	@GetMapping("/widgets")
	public String getAllWidgets(Model model) {
		model.addAttribute("widgets", widgetRepository.findAll());
		return "widgets";
	}

	@GetMapping("/widget/{id}")
	public String getWidgetById(@PathVariable Long id, Model model) {
		Widget widget = widgetRepository.findById(id).orElse(new Widget());
		model.addAttribute("widget", widget);
		return "widget";
	}

	@GetMapping("/widget/new")
	public void newWidget(Model model) {
		Widget widget1 = new Widget(1L, "Widget1", "Widget1 Desc");
		Widget widget2 = new Widget(2L, "Widget2", "Widget2 Desc");
		Widget widget3 = new Widget(3L, "Widget3", "Widget3 Desc");

		widgetRepository.save(widget1);
		widgetRepository.save(widget2);
		widgetRepository.save(widget3);

		LOG.info("User count in DB: {}", widgetRepository.count());
	    LOG.info("User with ID 1: {}", widgetRepository.findById(1L));
		//model.addAttribute("widget", new Widget());
		//return "widgetform";
	}

	@PostMapping("/widget/")
	public String createWidget(Widget widget, Model model) {
		widgetRepository.save(widget);
		return "redirect:/widget/" + widget.getId();
	}

	@GetMapping("/widget/edit/{id}")
	public String editWidget(@PathVariable Long id, Model model) {
		Widget widget = widgetRepository.findById(id).orElse(new Widget());
		model.addAttribute("widget", widget);
		return "widgetform";
	}

	@PostMapping("/widget/{id}")
	public String updateWidget(Widget widget) {
		widgetRepository.save(widget);
		return "redirect:/widget/" + widget.getId();
	}

	@DeleteMapping("/widget/delete/{id}")
	public String deleteWidget(@PathVariable Long id) {
		widgetRepository.deleteById(id);
		return "redirect:/widgets";
	}
}