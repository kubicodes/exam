package com.kubicodes.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kubicodes.springboot.web.model.Exam;
import com.kubicodes.springboot.web.repository.ExamRepository;

@Controller
public class ExamController {
	
	@Autowired
	ExamRepository examRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/retrieve-exams", method=RequestMethod.GET)
	public String showExams(ModelMap model) {
		model.put("retrieveExams", examRepository.findAll());
		return "retrieve-exams";
	}
	
	@RequestMapping(value="/add-exam", method=RequestMethod.GET)
	public String showAddExamPage(ModelMap model) {
		model.addAttribute("exam", new Exam(0,"", "", new Date(), true));
		return "add-exam";
	}
	
	@RequestMapping(value="/delete-exam", method=RequestMethod.GET)
	public String deleteExam(@RequestParam int id) {
		examRepository.deleteById(id);
		return "redirect:/retrieve-exams";
	}
	
	@RequestMapping(value="/update-exam", method=RequestMethod.GET)
	public String ShowUpdateExamPage(@RequestParam int id, ModelMap model) {
		Exam exam = examRepository.findById(id).get();
		model.put("exam", exam);
		return "add-exam";
	}
	
	@RequestMapping(value="/update-exam", method=RequestMethod.POST)
	public String updateExam(@Valid Exam exam, BindingResult result) {
		if(result.hasErrors()) {
			return "add-exam";
		}
		examRepository.save(exam);
		return "redirect:/retrieve-exams";
	}
	
	@RequestMapping(value="/add-exam", method=RequestMethod.POST)
	public String addExam(ModelMap model, @Valid Exam exam, BindingResult result) {
		if(result.hasErrors()) {
			return "add-exam";
		}
		
		examRepository.save(exam);
		return "redirect:/retrieve-exams";
		
	}
	
	
	
}
