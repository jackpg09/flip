package com.flip.flipmvc.Models.Data;

import com.flip.flipmvc.Models.MarketDisc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MarketDiscDao extends CrudRepository<MarketDisc, Integer> {


}
