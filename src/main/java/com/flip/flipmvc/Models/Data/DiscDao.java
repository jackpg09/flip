package com.flip.flipmvc.Models.Data;

import com.flip.flipmvc.Models.Disc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DiscDao extends CrudRepository<Disc, Integer> {
}
