package ie.dcu.ee417.betteryou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.dcu.ee417.betteryou.entities.Feedback;
import ie.dcu.ee417.betteryou.repository.FeedbackRepository;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@GetMapping("/contact")
	public Iterable<Feedback> getFeedback() {
		return feedbackRepository.findAll();
	}
}
