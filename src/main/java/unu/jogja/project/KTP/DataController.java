/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unu.jogja.project.KTP;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asus
 */
@Controller
public class DataController {
     Data_1JpaController datactrl = new Data_1JpaController();
    List<Data_1> newdata = new ArrayList<>();

     @RequestMapping("/data")
  //  @ResponseBody
    public String getDataKTP(Model model){
        int record = datactrl.getData_1Count();
        String result = "";
        try{
            newdata = datactrl.findData_1Entities().subList(0,record);
        }
        catch(Exception e){
            result=e.getMessage();
        }
        model.addAttribute("goData", newdata);
        model.addAttribute("record", record);
        return "database";
    }
}
