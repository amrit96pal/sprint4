package com.stackroute.service;

import com.stackroute.domain.Question;
import com.stackroute.domain.UserCurrent;

public interface UserProfileService {
    String addQuestionToDB(String emailid, Question question);

    Question addAnswerToDb(String emailid, Question question);

    UserCurrent returnAllInfoFromDb(String emailid);
}
