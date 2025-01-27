package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
