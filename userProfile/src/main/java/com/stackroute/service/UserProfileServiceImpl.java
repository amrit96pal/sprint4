package com.stackroute.service;

import com.stackroute.domain.Answer;
import com.stackroute.domain.Question;
import com.stackroute.domain.UserCurrent;
import com.stackroute.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {

    UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }


    @Override
    public String addQuestionToDB(String emailid, Question question) {
        boolean flag=true;
        UserCurrent userCurrent=userProfileRepository.findById(emailid).get();
        String givenQuestion=question.getQuestion();
        List<Question> mongoQues=userCurrent.getQuestions();

        for(int i=0;i<mongoQues.size();i++){
            if(mongoQues.get(i).getQuestion()==givenQuestion) {
                mongoQues.set(i, question);
                flag = false;
                break;
            }
        }
        if(flag==true){
            mongoQues.add(question);
        }
        userCurrent.setQuestions(mongoQues);
        userProfileRepository.save(userCurrent);
        return "Success";
    }

    @Override
    public Question addAnswerToDb(String emailid, Question question) {
        boolean flag=true;
        UserCurrent userCurrent=userProfileRepository.findById(emailid).get();
        List<Answer> givenAnsweres=question.getQuestion();
        List<Question> mongoAns=userCurrent.getAnswers();

        for(int i=0;i<mongoQues.size();i++){
            if(mongoQues.get(i).getQuestion()==givenQuestion) {
                mongoQues.set(i, question);
                flag = false;
                break;
            }
        }
        if(flag==true){
            mongoQues.add(question);
        }
        userCurrent.setQuestions(mongoQues);
        userProfileRepository.save(userCurrent);
        return "Success";
    }

    @Override
    public UserCurrent returnAllInfoFromDb(String emailid) {
        return null;
    }
}
