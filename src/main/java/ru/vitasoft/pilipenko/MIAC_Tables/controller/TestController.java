package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.model.TestUsers;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.TestRepository;

@RestController
@RequestMapping("/rest")
public class TestController {

    @GetMapping("/")
    public String getSome(){

        return "Fuck OFF!";
    }

    @Autowired
    TestRepository testRepository;

    @GetMapping("/GetAll")
    public Iterable<TestUsers> testGetAll(){
        return testRepository.findAll();
    }

    @GetMapping("/{id}/GetOne")
    public TestUsers testGetByID(@PathVariable("id") Integer Id){
        return testRepository.findByUserId(Id);
    }

    @PutMapping("/UpdateOne")                               //В теле запроса приходит правильно отформатированный JSON
    public JSONObject testUpdateOne(@RequestBody TestUsers testUser)  {

        JSONObject response = new JSONObject();
        String messageTest = "";
        Integer userID = testUser.getUserId();

        boolean userIdIsFilled = userID!=null,userExist = false;

        if (!userIdIsFilled){
            messageTest = "Error: field ID must be filled";
        }

        if(userIdIsFilled){
            userExist = testRepository.findByUserId(userID) != null;
        }

        if (!userExist){
            messageTest = "Error: user doesn't exist";
        }

        if (userIdIsFilled && userExist){

            TestUsers newUser;
            newUser = testRepository.save(testUser);

            if(newUser==null){
                messageTest = "Error: User was not updated. SQL error";
            }else{
                messageTest = "Success: User was updated. Id: " + newUser.getUserId().toString();
            }
        }

        response.put("message", messageTest);

        return response;
    }

    @PostMapping("/NewOne")                                 //В теле запроса приходит правильно отформатированный JSON
    public JSONObject testNewOne(@RequestBody TestUsers testUser)  {

        boolean UserIdIsFilled = testUser.getUserId()!=null;

        JSONObject response = new JSONObject();
        String messageTest;

        if (UserIdIsFilled){
            messageTest = "Error: field ID must be empty";
        }else{

            TestUsers newUser;
            newUser = testRepository.save(testUser);

            if(newUser==null){
                messageTest = "Error: User was not created. SQL error";
            }else{
                messageTest = "Success: User was created. Id: " + newUser.getUserId().toString();
            };
        }

        response.put("message", messageTest);

        return response;
    }

    @DeleteMapping("/{id}/DeleteOne")
    public JSONObject testDeleteOneByID(@PathVariable("id") Integer Id){

        boolean errors = false,userExist;
        JSONObject response = new JSONObject();
        String messageTest;

        userExist = testRepository.findByUserId(Id) != null;

        if(userExist){
            try {
                testRepository.deleteById(Id);
            }catch (Exception e){
                System.out.printf(e.getMessage());
                errors = true;
            }
            if ((!errors) && testRepository.findByUserId(Id) == null) {
                messageTest = "Success: Запись " + Id.toString() + " успешно удалена.";
            }else{
                messageTest = "Error: Ошибка при попытке удаления записи " + Id.toString();
            }
        }else{
            messageTest = "Error: пользователь не найден " + Id.toString();
        }

        response.put("message", messageTest);

        return response;
    }
}
