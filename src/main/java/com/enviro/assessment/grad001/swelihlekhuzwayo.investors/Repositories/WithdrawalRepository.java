package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Withdrawal;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
}
