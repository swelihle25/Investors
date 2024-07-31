package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Controllers;


package com.enviro.assessment.grad001.bonolo.investors.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.Dto.CreateWithdrawalDto;
import com.enviro.assessment.grad001.bonolo.investors.Entities.Investor;
import com.enviro.assessment.grad001.bonolo.investors.Entities.Withdrawal;
import com.enviro.assessment.grad001.bonolo.investors.Services.InvestorService;
import com.enviro.assessment.grad001.bonolo.investors.Services.WithdrawalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/api/withdrawals")
@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalService widthdrawalService;

    @PostMapping("")
    public ResponseEntity<List<Withdrawal>> createInvestor(@RequestBody CreateWithdrawalDto withdrawal) {
        try {

            List<Withdrawal> list = widthdrawalService.createWithdrawal(withdrawal);

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Withdrawal>> downloadWithdrawal(@PathVariable Long id) {
        try {

            this.widthdrawalService.writeProductsToCsv(id,"./job.csv");

            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // @G("")
    // public ResponseEntity<CreateWithdrawalDto> createInvestor(@RequestBody CreateWithdrawalDto withdrawal) {
    //     try {

    //         widthdrawalService.createWithdrawal(withdrawal);
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

}
