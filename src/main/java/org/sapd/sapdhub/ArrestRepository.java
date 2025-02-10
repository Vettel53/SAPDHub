package org.sapd.sapdhub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface ArrestRepository extends JpaRepository<Arrest, BigInteger> {

    //void deleteByReport_id(BigInteger reportId);
    Optional<Arrest> findById(BigInteger id);

}
