package com.stackroute.controller;


import com.stackroute.domain.Question;
import com.stackroute.domain.UserCurrent;
import com.stackroute.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class UserProfileController {

    UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService=userProfileService;
    }


    @PostMapping("/question/{emailid}")
    public ResponseEntity<?> addQuestion(@PathVariable String emailid, @RequestBody Question question){
        return new ResponseEntity<String>(this.userProfileService.addQuestionToDB(emailid,question), HttpStatus.OK);
    }

    @PostMapping("/answer/{emailid}")
    public ResponseEntity<?> addAnswer(@PathVariable String emailid, @RequestBody Question question){
        return new ResponseEntity<>(this.userProfileService.addAnswerToDb(emailid,question),HttpStatus.OK);
    }

    @GetMapping("/getall/{emailid}")
    public ResponseEntity<UserCurrent> getAllInfo(@PathVariable String emailid){
        return new ResponseEntity<UserCurrent>(this.userProfileService.returnAllInfoFromDb(emailid),HttpStatus.FOUND);
    }

}
