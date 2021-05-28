package com.example.credit.controller;

import com.example.credit.model.CreditID;
import com.example.credit.model.CreditInfo;
import com.example.credit.model.CreditStat;
import com.example.credit.service.CreditInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreditContoller {

    @Autowired
    CreditInfoService creditInfoService;


    @GetMapping("/card-scheme/verify/{cardId}")
    @ResponseBody
    public CreditInfo getCreditInfo(@PathVariable("cardId") Long cardID)
    {

        return   creditInfoService.creditInfo(cardID);
    }

    @GetMapping("/card-scheme/stats")
    @ResponseBody
    public CreditStat getCreditstats(@RequestParam("start") int start, @RequestParam("limit") int limit)
    {

        return   creditInfoService.creditStat(start, limit);
    }



    @GetMapping("/card-scheme")
    public String getCreditInfoUi(Model model)
    {
        CreditInfo creditInfo =   creditInfoService.creditInfo(Long.valueOf(45717360));
        model.addAttribute("credit",creditInfo);
        return "card-scheme";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@ModelAttribute CreditID CreditID, Model model)
    {
        CreditInfo creditInfo =   creditInfoService.creditInfo(CreditID.getCreditId());
        model.addAttribute("credit",creditInfo);
        return "card-scheme";
    }
}
