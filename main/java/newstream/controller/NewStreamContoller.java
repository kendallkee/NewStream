package newstream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import newstream.controller.model.UserData;
import newstream.service.NewStreamService;

@RestController
@RequestMapping("/newstream")
@Slf4j
public class NewStreamContoller {
	@Autowired
	private NewStreamService newStreamService;
	
	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserData createUser(@RequestBody UserData userData) {
		log.info("Creating user {}", userData);
		
		return newStreamService.saveUser(userData);
	}
	
}
