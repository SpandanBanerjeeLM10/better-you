package ie.dcu.ee417.betteryou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ie.dcu.ee417.betteryou.entities.Feedback;
import ie.dcu.ee417.betteryou.repository.FeedbackRepository;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@PostMapping("/contact")
	public ResponseEntity<String> newContact(@RequestBody Feedback newFeedback) {
		try {
			// Save the new feedback to the database
			System.out.println("Received a POST for " + newFeedback.getUserName());
			System.out.println(newFeedback.getMessage());
			System.out.println(newFeedback.getEmail());
			feedbackRepository.save(newFeedback);
			
			System.out.println(newFeedback.getMessage());
			// Return a success response
			return new ResponseEntity<>("Feedback created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			// Return an error response
			return new ResponseEntity<>("Error creating feedback: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
