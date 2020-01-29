package com.rishabh.springboot.controller;


import com.rishabh.springboot.databasecontroller.BranchDataBase;
import com.rishabh.springboot.databasecontroller.BranchRepo;
import com.rishabh.springboot.databasecontroller.DataBaseImplementaion;
import com.rishabh.springboot.databasecontroller.DataBaseRepo;
import com.rishabh.springboot.domain.Domain;
import com.rishabh.springboot.domain.DomainInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
public class ControllerPage implements ControllerInterface {

    @Autowired
    private DataBaseRepo dataBaseRepo;

    @Autowired
     private BranchRepo branchRepo;


    @Autowired
    DataBaseImplementaion dataBase;





    @RequestMapping("index")
    public String homePage()
    {

        return ("index");
    }


    @RequestMapping("nextpage")
    public ModelAndView login(@RequestParam(value="ENAME") String ENAME, @RequestParam(value="ECODE") String ECODE)
    {
        ModelAndView mv = new ModelAndView();
        boolean result = dataBaseRepo.existsById(ECODE);

      //  dataBase.setECODE(ECODE);

        if(result)
        {
            dataBase.setEcode(ECODE);
            dataBase.setEname(ENAME);
            mv.setViewName("next");
        }
        else
        {
            mv.setViewName("loginerrorpage");
        }

        return mv;
    }

    @Autowired
    Domain d;
    @RequestMapping("ctc_request")
    @ResponseBody
    public String ctc_page(@RequestParam(value="CTC") String CTC,@RequestParam(value="STATE") String STATE, Model model)
    {

         ModelAndView mv = new ModelAndView();

         Long ctc_got = Long.parseLong(CTC);

         dataBase.setCtc(ctc_got);
         dataBase.setLoc(STATE);

         dataBaseRepo.save(dataBase);

         BranchDataBase branchDataBase =  branchRepo.findById(STATE).get();

         System.out.println(branchDataBase);

         System.out.println("the hra percentage is"+branchDataBase.getHra_per());

         Long basic_ctc = d.basic_ctc(ctc_got,branchDataBase.getMinimum_wages());
         Long bonus_ctc = d.bonus_ctc(basic_ctc);
         Long employer_pf_contribution = d.employer_pf_contribution(basic_ctc);
         Long gratuity_from_ctc = d.gratuity_from_ctc(basic_ctc);
         Long grossTotal = d.gross_total(ctc_got,employer_pf_contribution,gratuity_from_ctc);
         Long employer_esi_contribution = d.employer_esi_contribution(grossTotal);
         Long employee_pf_contribution = d.employee_pf_contribution(basic_ctc);
         Long employee_esi_contribution = d.employee_esi_contribution(grossTotal);
         Long netpay = d.netpay(grossTotal,employee_pf_contribution,employee_esi_contribution);
         Long grossDed = d.grossDed(employee_pf_contribution,employee_esi_contribution);
         Long nettakehome = d.nettakehome(grossTotal,grossDed);
         Long difference = d.difference(nettakehome,netpay);
         Long ptgross = d.ptgross(netpay,grossDed);
         Long homerentallowance= d.homerentallowance(basic_ctc,bonus_ctc,grossDed,netpay,branchDataBase.getHra_per());

        dataBase.setBasic(basic_ctc);
        dataBase.setBonus(bonus_ctc);
        dataBase.setEmployer_pf(employer_pf_contribution);
        dataBase.setGratuity(gratuity_from_ctc);
        dataBase.setGross(grossTotal);
        dataBase.setEmployer_esi(employer_esi_contribution);
        dataBase.setEmployee_Pf(employee_pf_contribution);
        dataBase.setEmployee_esi(employee_esi_contribution);
        dataBase.setNet_Pay(netpay);
        dataBase.setGross_ded(grossDed);
        dataBase.setNet_take_home(nettakehome);
        dataBase.setDiff(difference);
        dataBase.setPt_gross(ptgross);
        dataBase.setHra(homerentallowance);


        dataBaseRepo.save(dataBase);

        System.out.println(basic_ctc);
        System.out.println(bonus_ctc);
        String ECODE = dataBase.getEcode();


//        model.addAttribute("ctc_got",ctc_got);
//        model.addAttribute("ECODE",ECODE);
//        model.addAttribute("basic_ctc",basic_ctc);
//        model.addAttribute("bonus_ctc",bonus_ctc);
//        model.addAttribute("employer_pf_contribution",employer_pf_contribution);
//        model.addAttribute("gratuity_from_ctc",gratuity_from_ctc);
//        model.addAttribute("employer_esi_contribution",employer_esi_contribution);
//        model.addAttribute("employee_pf_contribution",employee_pf_contribution);
//        model.addAttribute("employee_esi_contribution",employee_esi_contribution);
//        model.addAttribute("netpay",netpay);
//        model.addAttribute("grossDed",grossDed);
//        model.addAttribute("nettakehome",nettakehome);
//        model.addAttribute("difference",difference);
//        model.addAttribute("ptgross",ptgross);
//        model.addAttribute("homerentallowance",homerentallowance);
//        model.addAttribute("grossTotal",grossTotal);

        mv.addObject(dataBase);

         mv.setViewName("ctc_detail");

         return dataBaseRepo.findAll().toString();

    }



    //###################################################################################################

                                         // CURD OPERATION...


    @RequestMapping("ctc/{ctc}/{state}/{ecode}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<DataBaseImplementaion> ctc_page1(@PathVariable String ctc, @PathVariable String state, @PathVariable String ecode)
    {

        ModelAndView mv = new ModelAndView();

        Long ctc_got = Long.parseLong(ctc);

        dataBase = dataBaseRepo.findById(ecode).get();
        String ename = dataBase.getEname();
        System.out.println(ename);
        dataBase.setEname(ename);
        dataBase.setCtc(ctc_got);
        dataBase.setLoc(state);
        dataBase.setState(state);

        BranchDataBase branchDataBase =  branchRepo.findById(state).get();



        System.out.println(branchDataBase);

        System.out.println("the hra percentage is"+branchDataBase.getHra_per());

        Long basic_ctc = d.basic_ctc(ctc_got,branchDataBase.getMinimum_wages());
        Long bonus_ctc = d.bonus_ctc(basic_ctc);
        Long employer_pf_contribution = d.employer_pf_contribution(basic_ctc);
        Long gratuity_from_ctc = d.gratuity_from_ctc(basic_ctc);
        Long grossTotal = d.gross_total(ctc_got,employer_pf_contribution,gratuity_from_ctc);
        Long employer_esi_contribution = d.employer_esi_contribution(grossTotal);
        Long employee_pf_contribution = d.employee_pf_contribution(basic_ctc);
        Long employee_esi_contribution = d.employee_esi_contribution(grossTotal);
        Long netpay = d.netpay(grossTotal,employee_pf_contribution,employee_esi_contribution);
        Long grossDed = d.grossDed(employee_pf_contribution,employee_esi_contribution);
        Long nettakehome = d.nettakehome(grossTotal,grossDed);
        Long difference = d.difference(nettakehome,netpay);
        Long ptgross = d.ptgross(netpay,grossDed);
        Long homerentallowance= d.homerentallowance(basic_ctc,bonus_ctc,grossDed,netpay,branchDataBase.getHra_per());

        dataBase.setBasic(basic_ctc);
        dataBase.setBonus(bonus_ctc);
        dataBase.setEmployer_pf(employer_pf_contribution);
        dataBase.setGratuity(gratuity_from_ctc);
        dataBase.setGross(grossTotal);
        dataBase.setEmployer_esi(employer_esi_contribution);
        dataBase.setEmployee_Pf(employee_pf_contribution);
        dataBase.setEmployee_esi(employee_esi_contribution);
        dataBase.setNet_Pay(netpay);
        dataBase.setGross_ded(grossDed);
        dataBase.setNet_take_home(nettakehome);
        dataBase.setDiff(difference);
        dataBase.setPt_gross(ptgross);
        dataBase.setHra(homerentallowance);
        dataBase.setEcode(ecode);



        dataBaseRepo.save(dataBase);

        System.out.println(basic_ctc);
        System.out.println(bonus_ctc);



        mv.addObject(dataBase);

        mv.setViewName("ctc_detail");

        return dataBaseRepo.findById(ecode);

    }


    @RequestMapping(value = "employee/{ecode}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> findUserDetail(@PathVariable String ecode) {

//        dataBaseRepo.findById(ecode);
        return new ResponseEntity<>(dataBaseRepo.findById(ecode),HttpStatus.OK);
    }


   @PostMapping("employee")
   @ResponseBody

    public ResponseEntity<DataBaseImplementaion> newUser(DataBaseImplementaion dataBaseImplementaion)
        {
            System.out.println("inside new?user");
            dataBaseRepo.save(dataBaseImplementaion);
            //return dataBaseImplementaion;
            return new ResponseEntity<>(dataBaseImplementaion,HttpStatus.OK);
        }



    @DeleteMapping("employee/{ecode}")
    @ResponseBody
    public ResponseEntity<Object> deleteUser(@PathVariable String ecode)
    {
        System.out.println("inside delete");
        DataBaseImplementaion a = dataBaseRepo.getOne(ecode);
        dataBaseRepo.delete(a);
        return new ResponseEntity<>("working fine", HttpStatus.OK);
    }



 @PutMapping("employee/{ecode}")
 @ResponseBody
 public  ResponseEntity<Object> updateUser(@PathVariable String ecode,DataBaseImplementaion dataBaseImplementaion) {



     return new ResponseEntity<>(dataBaseRepo.findById(ecode)
             .map(dataBaseImplementaion1 -> {
                 dataBaseImplementaion1.setEname(dataBaseImplementaion.getEname());
                 //employee.setRole(newEmployee.getRole());
                 return dataBaseRepo.save(dataBaseImplementaion1);
             })
             .orElseGet(() -> {
                 dataBaseImplementaion.setEcode(ecode);
                 return dataBaseRepo.save(dataBaseImplementaion);
             }),HttpStatus.OK);
 }

}

