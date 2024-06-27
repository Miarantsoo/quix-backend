package com.project.quix.misajour;

import java.util.List;

import com.project.quix.tierces.NewPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/miseajour")
public class MiseAJourController {

    @Autowired
    private MiseAJourService miseajourService;

    @GetMapping
    public List<MiseAJour> getAllUtilisateurs(){
        return miseajourService.getAllMiseAJours();
    }

    @PostMapping("/authentify-user")
    @ResponseBody
    public String authentifyAnUser(@RequestHeader("Authorization") String token, @RequestBody NewPass newPassword){
        try {
            miseajourService.makeUserAuthentified(token, newPassword.getNewPassword());
            return "{\"state\":\"success\"}";
        } catch (Exception e) {
            return "{\"state\":\""+e.getMessage()+"\"}";
        }
    }

    @GetMapping("verify-user")
    @ResponseBody
    public String verifyUser(@RequestHeader("Authorization") String token){
        try {
            return miseajourService.verifyIfAlreadyAuthentified(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}