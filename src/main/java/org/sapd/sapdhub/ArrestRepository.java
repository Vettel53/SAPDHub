package org.sapd.sapdhub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ArrestRepository extends JpaRepository<Arrest, BigInteger>, JpaSpecificationExecutor<Arrest> {

    //void deleteByReport_id(BigInteger reportId);
    //Optional<Arrest> findById(BigInteger id);

}
