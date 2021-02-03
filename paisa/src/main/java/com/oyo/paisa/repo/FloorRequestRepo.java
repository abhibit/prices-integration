package com.oyo.paisa.repo;

import com.oyo.paisa.entity.FloorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRequestRepo extends JpaRepository<FloorRequest,Integer> {




    @Query(value ="SELECT * FROM floor_requests where hotel_id = :hotelId",nativeQuery = true)
    List<FloorRequest> findAllByHotelIds(Integer hotelId);

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "UPDATE floor_requests SET status = :status, reviewed_at = :reviewedAt,reviewed_by_id= :reviewedById WHERE req_id = :reqId" , nativeQuery = true)
//    void updateFloorRequestStatus(@Param("status") Integer status, @Param("reviewedById") Integer reviewedById, @Param("reqId") Integer reqId, @Param("reviewedAt")LocalDateTime reviewedAt);

    FloorRequest findByReqId(Integer reqId);



}
